package com.example.KTB_7WEEK.post.dto.response;

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
