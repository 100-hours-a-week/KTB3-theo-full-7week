package com.example.KTB_7WEEK.post.repository;

import com.example.KTB_7WEEK.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicPostJpaRepository extends JpaRepository<Post, Long> {
}
