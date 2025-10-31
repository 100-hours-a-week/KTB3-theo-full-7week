package com.example.KTB_7WEEK.post.repository;

import com.example.KTB_7WEEK.post.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPostId(long postId);

}
