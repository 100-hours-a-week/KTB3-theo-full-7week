package com.example.KTB_5WEEK.auth.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public class LoginRequestDto {
    @Schema(description = "로그인 요청 이메일", example = "test@test.com")
    private String email;
    @Schema(description = "로그인 요청 비밀번호", example = "1q2w3e4r!Q")
    private String password;

    public LoginRequestDto() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
