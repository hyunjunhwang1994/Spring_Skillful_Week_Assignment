package com.sparta.spring_skillful_week_assignment.dto;


import com.sparta.spring_skillful_week_assignment.entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostRequestDto {

    private String title;
    private String contents;
    private String author;




    @Builder
    public PostRequestDto(String title, String contents, String author) {
        this.title = title;
        this.contents = contents;
        this.author = author;

    }


    // dto -> entity
    public Post toEntity() {
        return Post.builder()
                .title(title)
                .contents(contents)
                .author(author)
                .build();
    }

}
