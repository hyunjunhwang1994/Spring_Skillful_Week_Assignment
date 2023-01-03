package com.sparta.spring_skillful_week_assignment.dto;


import lombok.*;


@Data
@Getter
@AllArgsConstructor
@Builder
public class UserSignupResponseDto<T> {

    private int statusCode;
    private String responseMessage;
    private T data;


    public UserSignupResponseDto(int statusCode, String responseMessage) {
        this.statusCode = statusCode;
        this.responseMessage = responseMessage;
        this.data =null;

    }


    public static <T> UserSignupResponseDto<T> responseDto(final int statusCode, final String responseMessage) {

        return responseDto(statusCode, responseMessage, null);
    }

    public static <T> UserSignupResponseDto<T> responseDto(final int statusCode, final String responseMessage, final T t) {
        return UserSignupResponseDto.<T>builder()
                .data(t)
                .statusCode(statusCode)
                .responseMessage(responseMessage)
                .build();
    }

}
