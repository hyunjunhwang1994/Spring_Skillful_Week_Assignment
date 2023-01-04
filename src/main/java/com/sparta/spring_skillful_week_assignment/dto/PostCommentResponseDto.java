package com.sparta.spring_skillful_week_assignment.dto;


import com.sparta.spring_skillful_week_assignment.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostCommentResponseDto {


    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;
    private String Contents;

    public PostCommentResponseDto(Comment comment) {
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
        this.Contents = comment.getContents();
    }
}
