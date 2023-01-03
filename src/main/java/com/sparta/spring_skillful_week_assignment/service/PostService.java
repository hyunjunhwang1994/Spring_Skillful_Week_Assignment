package com.sparta.spring_skillful_week_assignment.service;


import com.sparta.spring_skillful_week_assignment.dto.PostDeleteResponseDto;
import com.sparta.spring_skillful_week_assignment.dto.PostRequestDto;
import com.sparta.spring_skillful_week_assignment.dto.PostResponseDto;
import com.sparta.spring_skillful_week_assignment.entity.Post;
import com.sparta.spring_skillful_week_assignment.entity.User;
import com.sparta.spring_skillful_week_assignment.jwt.JwtUtil;
import com.sparta.spring_skillful_week_assignment.message.ResponseMessage;
import com.sparta.spring_skillful_week_assignment.message.StatusCode;
import com.sparta.spring_skillful_week_assignment.repository.PostRepository;
import com.sparta.spring_skillful_week_assignment.repository.UserRepository;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;


    public PostResponseDto createPost(PostRequestDto requestDto, HttpServletRequest request) {

        String token = jwtUtil.resolveToken(request);
        Claims claims;


        if (token != null) {

            if (jwtUtil.validateToken(token)) {

                claims = jwtUtil.getUserInfoFromToken(token);

                System.out.println("토큰검증");
            } else {
                throw new IllegalArgumentException("Token Error");
            }

            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                    () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
            );



            Post post = new Post(requestDto, user);

            postRepository.save(post);

            PostResponseDto postResponseDto = new PostResponseDto(post);

            return postResponseDto;

        } else {
            return null;
        }













    }


    @Transactional(readOnly = true)
    public List<PostResponseDto> getPosts() {

        List<Post> postList = postRepository.findAllByOrderByModifiedAtDesc();

        List<PostResponseDto> postResponseDtoList = new ArrayList<>();

        for (Post post : postList) {
            PostResponseDto postResponseDto = new PostResponseDto(post);//todo
            postResponseDtoList.add(postResponseDto);

        }

        return postResponseDtoList;

    }

    @Transactional(readOnly = true)
    public PostResponseDto readPost(Long id) {

        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 글이 존재하지 않습니다.")
        );


        PostResponseDto postResponseDto = new PostResponseDto(post);


        return postResponseDto;
    }



    @Transactional
    public PostDeleteResponseDto deletePost(Long id, HttpServletRequest request) {

        String token = jwtUtil.resolveToken(request);
        Claims claims;


        if (token != null) {

            if (jwtUtil.validateToken(token)) {

                claims = jwtUtil.getUserInfoFromToken(token);

            } else {
                throw new IllegalArgumentException("Token Error");
            }

            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                    () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
            );


            int result = postRepository.deleteByIdAndUser_Id(id, user.getId());


            if(result == 1){
                PostDeleteResponseDto postDeleteResponseDto = new PostDeleteResponseDto(
                        StatusCode.OK, ResponseMessage.POST_DELETE_SUCCESS,result);
                return postDeleteResponseDto;
            }else {
                PostDeleteResponseDto postDeleteResponseDto = new PostDeleteResponseDto(
                        StatusCode.OK, ResponseMessage.POST_DELETE_FAIL,result);
                return postDeleteResponseDto;
            }

            }else{
                return null;
            }




    }

    @Transactional
    public PostResponseDto updatePost(Long id, PostRequestDto requestDto, HttpServletRequest request) {



        String token = jwtUtil.resolveToken(request);
        Claims claims;


        if (token != null) {

            if (jwtUtil.validateToken(token)) {

                claims = jwtUtil.getUserInfoFromToken(token);

            } else {
                throw new IllegalArgumentException("Token Error");
            }

            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                    () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
            );


            Post post = postRepository.findByIdAndUser_Id(id, user.getId());

            if(post != null){


                post.updatePost(requestDto);

                PostResponseDto postResponseDto = new PostResponseDto(post);

                return postResponseDto;
            }else{
                return null;
            }

        } else {
            return null;
        }




















    }





}
