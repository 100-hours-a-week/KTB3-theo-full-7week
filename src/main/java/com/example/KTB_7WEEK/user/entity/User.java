package com.example.KTB_7WEEK.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Primary;

import java.time.LocalDateTime;

@Entity
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id = 0L;

    @Column(name = "email", nullable = false, unique = true)
    private String email = "";

    @Column(name = "password", nullable = false, length = 20)
    private String password = "";

    @Column(name = "nickname", nullable = false, length = 10)
    private String nickname = "";

    @Column(name = "profile_image")
    private String profileImage = "";

    @Column(name = "create_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = createdAt;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;

    public User() {
    }

    public User(Builder builder) {
        this.id = builder.id;
        this.email = builder.email;
        this.password = builder.password;
        this.nickname = builder.nickname;
        this.profileImage = builder.profileImage;
    }

    public boolean isDeleted() {
        return this.isDeleted;
    }

    public void identify(long id) {
        this.id = id;
    }

    public void updateNow() {
        this.updatedAt = LocalDateTime.now();
    }

    public void softDelete() {
        this.isDeleted = true;
    }

    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public static class Builder {
        private long id = 0L;
        private String email = "";
        private String password = "";
        private String nickname = "";
        private String profileImage = "";

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public Builder profileImage(String profileImage) {
            this.profileImage = profileImage;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
