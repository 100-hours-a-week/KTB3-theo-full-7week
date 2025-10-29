package com.example.KTB_7WEEK.auth.dto.response;


public class LoginResponseDto {
    private long id = 0L;
    private boolean isLoginSuccess = false;

    public LoginResponseDto() {
    }

    public long getId() {
        return id;
    }

    public boolean isLoginSuccess() {
        return isLoginSuccess;
    }

    public static LoginResponseDto toDto(long id, boolean isLoginSuccess) {
        LoginResponseDto dto = new LoginResponseDto();
        dto.id = id;
        dto.isLoginSuccess = isLoginSuccess;
        return dto;
    }
}
