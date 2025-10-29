package com.example.KTB_7WEEK.user.dto.response;

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
