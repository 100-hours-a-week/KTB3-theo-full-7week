package com.example.KTB_5WEEK.user.dto.response;

import com.example.KTB_5WEEK.app.util.DateTimePattern;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UpdatePasswordResponseDto {
    private long id;
    private String updatedAt;

    public UpdatePasswordResponseDto() {
    }

    public long getId() {
        return id;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public static UpdatePasswordResponseDto toDto(long id) {
        UpdatePasswordResponseDto dto = new UpdatePasswordResponseDto();
        dto.id = id;
        dto.updatedAt = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern(DateTimePattern.DEFAULT_DATE_TIME));
        return dto;
    }
}
