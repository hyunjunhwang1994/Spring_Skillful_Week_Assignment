package com.sparta.spring_skillful_week_assignment.controller;


import com.sparta.spring_skillful_week_assignment.dto.UserLoginRequestDto;
import com.sparta.spring_skillful_week_assignment.dto.UserLoginResponseDto;
import com.sparta.spring_skillful_week_assignment.dto.UserSignupRequestDto;
import com.sparta.spring_skillful_week_assignment.dto.UserSignupResponseDto;
import com.sparta.spring_skillful_week_assignment.message.ResponseMessage;
import com.sparta.spring_skillful_week_assignment.message.StatusCode;
import com.sparta.spring_skillful_week_assignment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public UserSignupResponseDto signup(@RequestBody @Validated UserSignupRequestDto userSignupRequestDto
            , Errors errors) {
        // 유효성 검증
        if (errors.hasErrors()) {
            return UserSignupResponseDto.responseDto(StatusCode.OK
                    , errors.getFieldError().getDefaultMessage(), userSignupRequestDto);
        }

        return userService.signup(userSignupRequestDto);
    }


    @PostMapping("/login")
    public ResponseEntity<UserLoginResponseDto> login(@RequestBody UserLoginRequestDto userLoginRequestDto, HttpServletResponse response) {
        UserLoginResponseDto userLoginResponseDto = userService.login(userLoginRequestDto, response);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json",
                Charset.forName("UTF-8")));

        return new ResponseEntity<>(userLoginResponseDto, headers, userLoginResponseDto.getStatus());
    }

}
