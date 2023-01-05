package com.sparta.spring_skillful_week_assignment;

import com.sparta.spring_skillful_week_assignment.dto.PostRequestDto;
import com.sparta.spring_skillful_week_assignment.dto.UserSignupRequestDto;
import com.sparta.spring_skillful_week_assignment.entity.Post;
import com.sparta.spring_skillful_week_assignment.entity.User;
import com.sparta.spring_skillful_week_assignment.entity.UserRoleEnum;
import com.sparta.spring_skillful_week_assignment.repository.PostRepository;
import com.sparta.spring_skillful_week_assignment.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SampleApplicationRunner implements ApplicationRunner {

    private final PostRepository postRepository;
    private final UserRepository userRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {


    }
}