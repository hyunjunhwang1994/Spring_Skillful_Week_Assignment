package com.sparta.spring_skillful_week_assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class PostDeleteResponseDto {


    private int status;
    private String message;
    private Object data;
    public PostDeleteResponseDto(int status, String message,Object data) {
        this.status = status;
        this.message = message;

        this.data = data;
    }

}
