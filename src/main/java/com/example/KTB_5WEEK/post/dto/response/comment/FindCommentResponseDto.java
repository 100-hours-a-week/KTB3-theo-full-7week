package com.example.KTB_5WEEK.post.dto.response.comment;

import com.example.KTB_5WEEK.app.util.DateTimePattern;
import com.example.KTB_5WEEK.post.entity.Comment;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FindCommentResponseDto {
    private long id;
    private long userId;
    private String content;
    private String created_at;
    private String updated_at;

    public FindCommentResponseDto() {
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public static FindCommentResponseDto toDto(Comment comment) {
        FindCommentResponseDto dto = new FindCommentResponseDto();
        dto.id = comment.getId();
        dto.userId = comment.getUserId();
        dto.content = comment.getContent();
        dto.created_at = comment.getCreatedAt()
                .format(DateTimeFormatter.ofPattern(DateTimePattern.DEFAULT_DATE_TIME));
        dto.updated_at = comment.getUpdatedAt()
                .format(DateTimeFormatter.ofPattern(DateTimePattern.DEFAULT_DATE_TIME));
        return dto;
    }
}
