package com.sparta.spring_skillful_week_assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostDeleteResponseDto {


    private int status;
    private String message;
    private Object data;


}
