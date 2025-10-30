package com.example.KTB_7WEEK.post.entity;


import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id", nullable = false, unique = true)
    private Long id = 0L;

    @Column(name = "post_id", nullable = false)
    private Long postId = 0L;

    @Column(name = "author_id", nullable = false)
    private Long authorId = 0L;

    @Column(name = "content", nullable = false, length = 200)
    private String content = "";

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = createdAt;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;

    public Comment() {
    }

    public Comment(Builder builder) {
        this.id = builder.id;
        this.postId = builder.postId;
        this.authorId = builder.authorId;
        this.content = builder.content;
    }

    public Comment(String content) {
        this.content = content;
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

    public static class Builder {
        private Long id = 0L;
        private Long postId = 0L;
        private Long authorId = 0L;
        private String content = "";

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder postId(long postId) {
            this.postId = postId;
            return this;
        }

        public Builder authorId(long authorId) {
            this.authorId = authorId;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Comment build() {
            return new Comment(this);
        }
    }
}
