package com.example.KTB_5WEEK.post.dto.response;

import com.example.KTB_5WEEK.app.util.DateTimePattern;
import com.example.KTB_5WEEK.post.entity.Post;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class IncreaseHitResponseDto {
    private long id;
    private long hit;
    private String updateAt;

    public IncreaseHitResponseDto() {
    }

    public long getId() {
        return id;
    }

    public long getHit() {
        return hit;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public static IncreaseHitResponseDto toDto(Post post) {
        IncreaseHitResponseDto dto = new IncreaseHitResponseDto();
        dto.id = post.getId();
        dto.hit = post.getHit();
        dto.updateAt = post.getUpdatedAt()
                .format(DateTimeFormatter.ofPattern(DateTimePattern.DEFAULT_DATE_TIME));
        return dto;
    }
}
