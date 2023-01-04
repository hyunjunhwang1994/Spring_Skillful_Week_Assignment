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

        User user = new User("abcdEFG1", "abcdEFG123$", UserRoleEnum.USER);
        userRepository.save(user);

        User user2 = new User("abcdEF2G1", "abcdEFG1213$",UserRoleEnum.USER);
        userRepository.save(user2);


        PostRequestDto postRequestDto = new PostRequestDto(
                "제목1", "컨텐츠1"
        );

        PostRequestDto postRequestDto2 = new PostRequestDto(
                "제목2", "컨텐츠2"
        );

        Post post1 = new Post(postRequestDto, user);
        Post post2 = new Post(postRequestDto2, user2);

        postRepository.save(post1);
        postRepository.save(post2);

    }
}