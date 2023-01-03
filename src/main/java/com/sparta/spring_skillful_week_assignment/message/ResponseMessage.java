package com.sparta.spring_skillful_week_assignment.message;

public class ResponseMessage {
    public static final String LOGIN_SUCCESS = "로그인 성공";
    public static final String LOGIN_FAIL = "로그인 실패";
    public static final String READ_USER = "회원 정보 조회 성공";
    public static final String NOT_FOUND_USER = "회원을 찾을 수 없습니다.";
    public static final String CREATED_USER = "회원 가입 성공";
    public static final String CREATED_USER_FAIL = "회원 가입 실패";
    public static final String CREATED_USER_FAIL_ALREADY_EXISTS = "회원 가입 실패 / 이미 존재하는 아이디 입니다.";
    public static final String CREATED_USER_FAIL_USERNAME_FAIL = "회원 가입 실패 / 아이디는 최소 4자 이상, 10자 이하 / 알파벳 소문자, 숫자를 포함해야 합니다.";
    public static final String CREATED_USER_FAIL_PASSWORD_FAIL = "회원 가입 실패 / 비밀번호는 최소 8자 이상, 15자 이하 / 알파벳 대소문자, 숫자를 포함해야 합니다.";
    public static final String UPDATE_USER = "회원 정보 수정 성공";
    public static final String DELETE_USER = "회원 탈퇴 성공";
    public static final String INTERNAL_SERVER_ERROR = "서버 내부 에러";
    public static final String DB_ERROR = "데이터베이스 에러";

    public static final String POST_DELETE_SUCCESS = "글 삭제 성공";
    public static final String POST_DELETE_FAIL = "글 삭제 실패";
}
