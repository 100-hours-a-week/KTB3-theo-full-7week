package com.example.KTB_7WEEK.post.repository;

import java.util.List;
import java.util.Optional;

import com.example.KTB_7WEEK.post.entity.Post;
import com.example.KTB_7WEEK.post.entity.Comment;

public interface PostRepository {

    List<Post> findAllPost();

    Optional<Post> createPost(Post post);

    Optional<Post> findPostById(long id);

    Optional<Post> updatePostById(long id, Post target);

    Optional<Post> deletePostById(long id);

    List<Comment> findCommentsByPostId(long id);

    Optional<Comment> createComment(Comment comment);

    Optional<Comment> findCommentById(long id);

    Optional<Comment> updateCommentById(long id, Comment target);

    public Optional<Comment> deleteCommentById(long id);
}
