package com.sparta.spring_skillful_week_assignment.controller;

import com.sparta.spring_skillful_week_assignment.dto.PostDeleteResponseDto;
import com.sparta.spring_skillful_week_assignment.dto.PostRequestDto;
import com.sparta.spring_skillful_week_assignment.dto.PostResponseDto;
import com.sparta.spring_skillful_week_assignment.dto.UserLoginResponseDto;
import com.sparta.spring_skillful_week_assignment.message.StatusCode;
import com.sparta.spring_skillful_week_assignment.service.PostService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@ApiOperation(value = "Post Rest API 입니다.")
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto, HttpServletRequest request) {

        return postService.createPost(requestDto, request);
    }

    @GetMapping("/posts")
    public List<PostResponseDto> getPosts() {

        return postService.getPosts();
    }

    @GetMapping("/posts/{id}")
    public PostResponseDto readPost(@PathVariable Long id) {

        PostResponseDto postResponseDto = postService.readPost(id);

        return postResponseDto;
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<PostDeleteResponseDto>  deletePost(@PathVariable Long id, HttpServletRequest request) {

        PostDeleteResponseDto postDeleteResponseDto = postService.deletePost(id,request);


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json",
                Charset.forName("UTF-8")));

        return new ResponseEntity<>(postDeleteResponseDto, headers, StatusCode.OK);

    }


    @PutMapping("/posts/{id}")
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto,
                                      HttpServletRequest request) {

        PostResponseDto postResponseDto = postService.updatePost(id, requestDto, request);


        return postResponseDto;
    }

}
