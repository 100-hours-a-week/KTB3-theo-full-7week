package com.example.KTB_7WEEK.user.entity;

import java.time.LocalDateTime;

public class User {
    private long id = 0L;
    private String email = "";
    private String password = "";
    private String nickname = "";
    private String profileImage = "";
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = createdAt;
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

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
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
