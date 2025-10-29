package com.example.KTB_7WEEK.post.entity;


import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

public class Post {
    // id ~ category : User가 조회 수정 가능
    private long id = 0L;
    private long authorId = 0L;
    private String title = "";
    private String article = "";
    private String articleImage = "";
    private PostCategory category = PostCategory.NONE;

    // User Invisible data, 서버 내부적으로 값 설정
    private AtomicLong hit = new AtomicLong(0);
    private AtomicLong like = new AtomicLong(0);
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = this.createdAt;
    private boolean isDeleted = false;

    public Post() {
    }

    public Post(Builder builder) {
        this.id = builder.id;
        this.authorId = builder.authorId;
        this.title = builder.title;
        this.article = builder.article;
        this.articleImage = builder.articleImage;
        this.category = builder.category;
    }

    public Post(long authorId, String title, String article, String articleImage, PostCategory category) {
        this.authorId = authorId;
        this.title = title;
        this.article = article;
        this.category = category;
        this.articleImage = articleImage;

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

    public PostCategory getCategory() {
        return category;
    }

    public long getHit() {
        return hit.get();
    }

    public long getLike() {
        return like.get();
    }

    public String getArticleImage() {
        return articleImage;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void identify(long id) {
        this.id = id;
    }

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateArticle(String article) {
        this.article = article;
    }

    public void updateArticleImage(String articleImage) {
        this.articleImage = articleImage;
    }

    public void updateCategory(PostCategory category) {
        this.category = category;
    }

    public void updateNow() {
        this.updatedAt = LocalDateTime.now();
    }

    public void delete() {
        this.isDeleted = true;
    }

    public long increaseHit() {
        return hit.getAndIncrement();
    }

    public long increaseLike() {
        return like.getAndIncrement();
    }

    public static class Builder {
        private long id = 0L;
        private long authorId = 0L;
        private String title = "";
        private String article = "";
        private String articleImage = "";
        private PostCategory category = PostCategory.NONE;

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder authorId(long authorId) {
            this.authorId = authorId;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder article(String article) {
            this.article = article;
            return this;
        }

        public Builder articleImage(String articleImage) {
            this.articleImage = articleImage;
            return this;
        }

        public Builder category(PostCategory category) {
            this.category = category;
            return this;
        }

        public Post build() {
            return new Post(this);
        }
    }
}
