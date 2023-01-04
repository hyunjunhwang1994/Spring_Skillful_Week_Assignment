package com.sparta.spring_skillful_week_assignment.dto;


import com.sparta.spring_skillful_week_assignment.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PostCommentResponseDto {


    private Long id;
    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;
    private String contents;
    private String username;

    public PostCommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
        this.contents = comment.getContents();
        this.username = comment.getUser().getUsername();
    }
}
