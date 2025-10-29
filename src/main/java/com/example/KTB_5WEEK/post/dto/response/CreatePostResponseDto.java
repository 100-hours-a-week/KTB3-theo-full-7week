package com.example.KTB_5WEEK.post.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public class CreatePostResponseDto {
    private long id;

    public CreatePostResponseDto() {
    }

    public long getId() {
        return id;
    }

    public static CreatePostResponseDto toDto(long id) {
        CreatePostResponseDto dto = new CreatePostResponseDto();
        dto.id = id;
        return dto;
    }
}
