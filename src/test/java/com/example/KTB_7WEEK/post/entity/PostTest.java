package com.example.KTB_7WEEK.post.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PostTest {

    @PersistenceContext
    EntityManager entityManager;

    @Test
    @Rollback(false)
    void tableCreateTest() {
        Post post = new Post.Builder()
                .authorId(1)
                .title("sample_title")
                .article("sample_article")
                .articleImage("sample_image_url")
                .category(PostCategory.COMMUNITY)
                .build();

            entityManager.persist(post);
    }

}