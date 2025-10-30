package com.example.KTB_7WEEK.post.entity;


import com.example.KTB_7WEEK.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

@Entity
@Getter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", nullable = false, unique = true)
    private Long id = 0L;

    @Column(name = "author_id", nullable = false)
    private Long authorId = 0L;

    @Column(name = "title", length = 26, nullable = false)
    private String title = "";

    @Column(name = "article", nullable = false)
    private String article = "";

    @Column(name = "article_image")
    private String articleImage = "";

    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    private PostCategory category = PostCategory.NONE;

    @Column(name = "hit", nullable = false)
    private long hit = 0;

    @Column(name = "post_like", nullable = false)
    private long like = 0;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = this.createdAt;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

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
        return ++hit;
    }

    public long increaseLike() {
        return ++like;
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
