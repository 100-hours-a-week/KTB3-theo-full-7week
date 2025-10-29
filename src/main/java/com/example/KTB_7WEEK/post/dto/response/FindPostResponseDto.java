package com.example.KTB_7WEEK.post.dto.response;

import com.example.KTB_7WEEK.post.entity.Post;
import com.example.KTB_7WEEK.post.entity.PostCategory;
import com.example.KTB_7WEEK.app.util.DateTimePattern;

import java.time.format.DateTimeFormatter;

public class FindPostResponseDto {
    private long id = 0L;
    private long authorId = 0L;
    private String title = "";
    private String article = "";
    private String articleImage = "";
    private PostCategory category = PostCategory.NONE;

    private long hit = 0;
    private long like = 0;
    private String createdAt = "";
    private String updatedAt = "";
    private boolean isDeleted = false;

    public FindPostResponseDto() {
    }

    public long getId() {
        return id;
    }

    public long getAuthorId() {
        return authorId;
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

    public long getHit() {
        return hit;
    }

    public long getLike() {
        return like;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public static FindPostResponseDto toDto(Post post) {
        FindPostResponseDto dto = new FindPostResponseDto();
        dto.id = post.getId();
        dto.authorId = post.getAuthorId();
        dto.title = post.getTitle();
        dto.article = post.getArticle();
        dto.articleImage = post.getArticleImage();
        dto.category = post.getCategory();
        dto.hit = post.getHit();
        dto.like = post.getLike();
        dto.createdAt = post.getCreatedAt().format(
                DateTimeFormatter.ofPattern(DateTimePattern.DEFAULT_DATE_TIME));
        dto.updatedAt = post.getUpdatedAt().format(
                DateTimeFormatter.ofPattern(DateTimePattern.DEFAULT_DATE_TIME));
        dto.isDeleted = post.isDeleted();
        return dto;
    }
}
