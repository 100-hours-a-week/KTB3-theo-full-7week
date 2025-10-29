package com.example.KTB_5WEEK.post.dto.response;

import com.example.KTB_5WEEK.post.entity.Post;
import com.example.KTB_5WEEK.post.entity.PostCategory;
import com.example.KTB_5WEEK.app.util.DateTimePattern;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UpdateMyPostResponseDto {
    private long id;
    private String title;
    private String article;
    private String articleImage;
    private PostCategory category;
    private String updateAt;

    public UpdateMyPostResponseDto() {
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArticle() {
        return article;
    }

    public String getArticleImage() {
        return articleImage;
    }

    public PostCategory getCategory() {
        return category;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public static UpdateMyPostResponseDto toDto(Post post) {
        UpdateMyPostResponseDto dto = new UpdateMyPostResponseDto();
        dto.id = post.getId();
        dto.title = post.getTitle();
        dto.article = post.getArticle();
        dto.articleImage = post.getArticleImage();
        dto.category = post.getCategory();
        dto.updateAt = post.getUpdatedAt()
                .format(DateTimeFormatter.ofPattern(DateTimePattern.DEFAULT_DATE_TIME));

        return dto;
    }
}
