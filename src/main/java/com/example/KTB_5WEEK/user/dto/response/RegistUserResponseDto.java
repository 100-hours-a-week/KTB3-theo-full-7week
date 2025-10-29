package com.example.KTB_5WEEK.user.dto.response;


import com.example.KTB_5WEEK.user.entity.User;

public class RegistUserResponseDto {
    private long id;

    public RegistUserResponseDto() {

    }

    public long getId() {
        return this.id;
    }

    public static RegistUserResponseDto toDto(User user) {
        RegistUserResponseDto dto = new RegistUserResponseDto();
        dto.id = user.getId();
        return dto;
    }

}
