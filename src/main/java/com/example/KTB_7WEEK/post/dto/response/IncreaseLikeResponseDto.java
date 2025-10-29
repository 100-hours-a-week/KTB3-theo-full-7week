package com.example.KTB_7WEEK.post.dto.response;

import com.example.KTB_7WEEK.app.util.DateTimePattern;
import com.example.KTB_7WEEK.post.entity.Post;

import java.time.format.DateTimeFormatter;

public class IncreaseLikeResponseDto {
    private long id;
    private long like;
    private String updateAt;

    public IncreaseLikeResponseDto() {
    }

    public long getId() {
        return id;
    }

    public long getLike() {
        return like;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public static IncreaseLikeResponseDto toDto(Post post) {
        IncreaseLikeResponseDto dto = new IncreaseLikeResponseDto();
        dto.id = post.getId();
        dto.like = post.getLike();
        dto.updateAt = post.getUpdatedAt()
                .format(DateTimeFormatter.ofPattern(DateTimePattern.DEFAULT_DATE_TIME));
        return dto;
    }
}
