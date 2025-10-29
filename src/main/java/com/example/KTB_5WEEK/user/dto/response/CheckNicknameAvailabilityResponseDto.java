package com.example.KTB_5WEEK.user.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public class CheckNicknameAvailabilityResponseDto {
    private String nickname;
    private boolean isAvailable;

    public CheckNicknameAvailabilityResponseDto() {

    }

    public String getNickname() {
        return nickname;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public static CheckNicknameAvailabilityResponseDto toDto(String nickname, boolean isAvailable) {
        CheckNicknameAvailabilityResponseDto dto = new CheckNicknameAvailabilityResponseDto();
        dto.nickname = nickname;
        dto.isAvailable = isAvailable;
        return dto;
    }
}
