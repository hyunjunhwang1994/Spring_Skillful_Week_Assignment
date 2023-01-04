package com.sparta.spring_skillful_week_assignment.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sparta.spring_skillful_week_assignment.dto.PostRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Entity
@NoArgsConstructor
public class Post extends Timestamped{



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;


    @Column(length = 50000, nullable = false)
    private String contents;

    @Column(nullable = false)
    private String author;



    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @OneToMany(mappedBy = "post")
    List<Comment> comments = new ArrayList<>();

    @Builder
    public Post(Long id, String title, String contents, String author) {

        this.id = id;
        this.title = title;
        this.contents = contents;
        this.author = author;

    }

    public Post(PostRequestDto requestDto, User user) {

        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.author = requestDto.getAuthor();
        this.user = user;
    }

    public void updatePost(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.author = requestDto.getAuthor();
    }

}
