package com.example.KTB_7WEEK.post.repository;

import com.example.KTB_7WEEK.post.exception.comment.CommentNotFoundException;
import com.example.KTB_7WEEK.app.util.db.table.PostTable;
import com.example.KTB_7WEEK.app.util.db.table.CommentTable;
import com.example.KTB_7WEEK.post.entity.Post;
import com.example.KTB_7WEEK.post.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class PublicPostRepository implements PostRepository {
    private PostTable postTable;
    private CommentTable commentTable;

    public PublicPostRepository(PostTable postTable, CommentTable commentTable) {
        this.postTable = postTable;
        this.commentTable = commentTable;
    }

    @Override // 전체 Post 조회
    public List<Post> findAllPost() {
        return postTable.getTable().values().stream().toList();
    }

    @Override // Post 생성
    public Optional<Post> createPost(Post post) {
        long postId = postTable.increaseSequence();
        post.identify(postId);
        postTable.getTable().put(postId, post);
        return Optional.ofNullable(postTable.getTable().get(postId));
    }

    @Override // Post PK 조회
    public Optional<Post> findPostById(long id) {
        return Optional.ofNullable(postTable.getTable().get(id));
    }

    @Override // Post 수정 By Id
    public Optional<Post> updatePostById(long id, Post target) {
        target.updateNow();
        postTable.getTable().put(id, target);
        return Optional.ofNullable(postTable.getTable().get(id));
    }

    @Override // Post 삭제 By Id
    public Optional<Post> deletePostById(long id) {
        Post deletePost = findPostById(id).get();
        deletePost.delete();
        updatePostById(id, deletePost);
        return Optional.ofNullable(postTable.getTable().remove(id));
    }

    // 댓글 생성
    public Optional<Comment> createComment(Comment comment) {
        long commentId = commentTable.increaseSequence();
        comment.identify(commentId);
        commentTable.getTable().put(commentId, comment);
        return Optional.ofNullable(commentTable.getTable().get(commentId));
    }

    // 모든 Comment 조회 By Post Id
    public List<Comment> findCommentsByPostId(long id) {
        return commentTable.getTable().values().stream()
                .filter(post -> post.getPostId() == id).toList();
    }

    // Comment 조회 By Comment Id
    public Optional<Comment> findCommentById(long id) {
        return Optional.ofNullable(commentTable.getTable().get(id));
    }

    // Comment 수정 By ID
    public Optional<Comment> updateCommentById(long id, Comment target) {
        target.updateNow();
        commentTable.getTable().put(id, target);
        return Optional.ofNullable(commentTable.getTable().get(id));
    }

    // Comment 삭제 By ID
    public Optional<Comment> deleteCommentById(long id) {
        Comment deleteComment = findCommentById(id).orElseThrow(() -> new CommentNotFoundException());
        deleteComment.softDelete();
        updateCommentById(id, deleteComment);
        return Optional.ofNullable(commentTable.getTable().remove(id));
    }
}
