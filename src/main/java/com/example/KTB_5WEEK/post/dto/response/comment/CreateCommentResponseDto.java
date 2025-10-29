package com.example.KTB_5WEEK.post.dto.response.comment;

import com.example.KTB_5WEEK.post.entity.Comment;
import io.swagger.v3.oas.annotations.media.Schema;

public class CreateCommentResponseDto {
    private long id;
    private String content;

    public CreateCommentResponseDto() {
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public static CreateCommentResponseDto toDto(Comment comment) {
        CreateCommentResponseDto dto = new CreateCommentResponseDto();
        dto.id = comment.getId();
        dto.content = comment.getContent();
        return dto;
    }
}
