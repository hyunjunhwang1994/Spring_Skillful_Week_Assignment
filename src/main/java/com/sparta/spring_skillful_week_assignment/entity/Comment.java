package com.sparta.spring_skillful_week_assignment.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sparta.spring_skillful_week_assignment.dto.CommentsRequestDto;
import com.sparta.spring_skillful_week_assignment.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Comment extends Timestamped {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private String contents;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "POST_ID", nullable = false)
    private Post post;


    public Comment(CommentsRequestDto requestDto, User user, Post post) {

        this.contents = requestDto.getContents();
        this.user = user;
        this.post = post;
    }

    public void updateComment(CommentsRequestDto requestDto) {
        this.contents = requestDto.getContents();
    }

}
