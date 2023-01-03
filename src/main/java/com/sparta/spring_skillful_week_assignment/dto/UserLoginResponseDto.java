package com.sparta.spring_skillful_week_assignment.dto;


import com.sparta.spring_skillful_week_assignment.message.ResponseMessage;
import com.sparta.spring_skillful_week_assignment.message.StatusCode;
import lombok.Data;

@Data
public class UserLoginResponseDto {

    private int status;
    private String message;
    private Object data;


    public UserLoginResponseDto(int status, String message,Object data) {
        this.status = status;
        this.message = message;

        this.data = data;
    }
}
