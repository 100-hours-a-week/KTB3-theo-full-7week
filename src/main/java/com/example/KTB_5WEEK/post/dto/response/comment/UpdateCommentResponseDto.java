package com.example.KTB_5WEEK.post.dto.response.comment;

import com.example.KTB_5WEEK.app.util.DateTimePattern;
import com.example.KTB_5WEEK.post.entity.Comment;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UpdateCommentResponseDto {
    private long id;
    private long postId;
    private long userId;
    private String content;
    private String createAt;
    private String updateAt;

    public UpdateCommentResponseDto() {
    }

    public long getId() {
        return id;
    }

    public long getPostId() {
        return postId;
    }

    public long getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }

    public String getCreateAt() {
        return createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public static UpdateCommentResponseDto toDto(Comment comment) {
        UpdateCommentResponseDto dto = new UpdateCommentResponseDto();
        dto.id = comment.getId();
        dto.postId = comment.getPostId();
        dto.userId = comment.getUserId();
        dto.content = comment.getContent();
        dto.createAt = comment.getCreatedAt()
                .format(DateTimeFormatter.ofPattern(DateTimePattern.DEFAULT_DATE_TIME));
        dto.updateAt = comment.getUpdatedAt()
                .format(DateTimeFormatter.ofPattern(DateTimePattern.DEFAULT_DATE_TIME));

        return dto;
    }
}
