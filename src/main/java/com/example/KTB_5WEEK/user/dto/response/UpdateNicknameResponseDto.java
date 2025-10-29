package com.example.KTB_5WEEK.user.dto.response;

import com.example.KTB_5WEEK.app.util.DateTimePattern;
import com.example.KTB_5WEEK.user.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UpdateNicknameResponseDto {
    private long id;
    private String nickname;
    private String createdAt;
    private String updatedAt;

    public UpdateNicknameResponseDto() {
    }

    public long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public static UpdateNicknameResponseDto toDto(User user) {
        UpdateNicknameResponseDto dto = new UpdateNicknameResponseDto();
        dto.id = user.getId();
        dto.nickname = user.getNickname();
        dto.createdAt = user.getCreatedAt()
                .format(DateTimeFormatter.ofPattern(DateTimePattern.DEFAULT_DATE_TIME));
        dto.updatedAt = user.getUpdatedAt()
                .format(DateTimeFormatter.ofPattern(DateTimePattern.DEFAULT_DATE_TIME));
        return dto;
    }
}
