package com.example.KTB_5WEEK.post.entity;


import java.time.LocalDateTime;

public class Comment {
    private long id = 0L;
    private long postId = 0L;
    private long userId = 0L;
    private String content = "";
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = createdAt;
    private boolean isDeleted = false;

    public Comment() {
    }

    public Comment(long id, long postId, long userId, String content) {
        this.id = id;
        this.postId = postId;
        this.userId = userId;
        this.content = content;
    }

    public Comment(long userId, long postId, String content) {
        this.userId = userId;
        this.postId = postId;
        this.content = content;
    }

    public Comment(String content) {
        this.content = content;
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

    public void updateContent(String content) {
        this.content = content;
    }

    public void updateNow() {
        this.updatedAt = LocalDateTime.now();
    }

    public void softDelete() {
        this.isDeleted = true;
    }
}
