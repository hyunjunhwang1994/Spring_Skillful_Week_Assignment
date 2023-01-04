package com.sparta.spring_skillful_week_assignment.dto;

import com.sparta.spring_skillful_week_assignment.entity.Comment;
import com.sparta.spring_skillful_week_assignment.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostResponseDto {

    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String title;
    private String contents;
    private String author;
    private String username;

    private List<Comment> comment;



    // entity -> dto
    public PostResponseDto(Post post, List<Comment> comment) {
        this.id = post.getId();
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
        this.title = post.getTitle();
        this.contents = post.getContents();
        this.author = post.getAuthor();
        this.username = post.getUser().getUsername();
        this.comment = comment;
    }

}
