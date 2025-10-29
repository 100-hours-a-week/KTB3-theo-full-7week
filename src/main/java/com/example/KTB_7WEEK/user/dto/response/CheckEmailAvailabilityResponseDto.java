package com.example.KTB_7WEEK.user.dto.response;


public class CheckEmailAvailabilityResponseDto {
    private String email;
    private boolean isAvailable;

    public CheckEmailAvailabilityResponseDto() {

    }

    public String getEmail() {
        return email;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public static CheckEmailAvailabilityResponseDto toDto(String email, boolean isAvailable) {
        CheckEmailAvailabilityResponseDto dto = new CheckEmailAvailabilityResponseDto();
        dto.email = email;
        dto.isAvailable = isAvailable;
        return dto;
    }
}
