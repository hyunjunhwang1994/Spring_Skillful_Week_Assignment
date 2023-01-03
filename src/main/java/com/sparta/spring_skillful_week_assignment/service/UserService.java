package com.sparta.spring_skillful_week_assignment.service;


import com.sparta.spring_skillful_week_assignment.dto.*;
import com.sparta.spring_skillful_week_assignment.entity.User;
import com.sparta.spring_skillful_week_assignment.message.ResponseMessage;
import com.sparta.spring_skillful_week_assignment.message.StatusCode;
import com.sparta.spring_skillful_week_assignment.jwt.JwtUtil;
import com.sparta.spring_skillful_week_assignment.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Transactional
    public UserSignupResponseDto signup(UserSignupRequestDto userSignupRequestDto) {
        String username = userSignupRequestDto.getUsername();
        String password = userSignupRequestDto.getPassword();


        // 회원 중복 확인
        Optional<User> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            return UserSignupResponseDto.responseDto(StatusCode.OK
                    , ResponseMessage.CREATED_USER_FAIL_ALREADY_EXISTS, userSignupRequestDto );

        }

        User user = new User(username, password);
        userRepository.save(user);
        return UserSignupResponseDto.responseDto(StatusCode.OK
                , ResponseMessage.CREATED_USER, userSignupRequestDto );
    }


    @Transactional(readOnly = true)
    public UserLoginResponseDto login(UserLoginRequestDto userLoginRequestDto, HttpServletResponse response) {
        String username = userLoginRequestDto.getUsername();
        String password = userLoginRequestDto.getPassword();

        // 사용자 확인
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("등록된 사용자가 없습니다.")
        );

        // 비밀번호 확인
        if(!user.getPassword().equals(password)){
            throw  new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        response.addHeader(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(user.getUsername()));
        return new UserLoginResponseDto(StatusCode.OK,
                ResponseMessage.LOGIN_SUCCESS,
                new UserJwtDto(user.getUsername(),response.getHeader("Authorization")));
    }
}
