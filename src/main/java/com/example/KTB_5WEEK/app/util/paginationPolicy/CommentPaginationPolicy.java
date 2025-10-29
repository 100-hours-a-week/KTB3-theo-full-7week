package com.example.KTB_5WEEK.app.util.paginationPolicy;


import com.example.KTB_5WEEK.post.entity.Comment;

import java.util.Comparator;
import java.util.function.Predicate;

public enum CommentPaginationPolicy implements PaginationPolicy{
    DEFAULT(10,
            Comparator.comparing(Comment::getCreatedAt).thenComparing(Comment::getId),
            comment -> !comment.isDeleted());

    private final int limit;
    private final Comparator<Comment> comparator;
    private final Predicate<Comment> predicate;

    CommentPaginationPolicy(int limit, Comparator<Comment> comparator, Predicate<Comment> predicate) {
        this.limit = limit;
        this.comparator = comparator;
        this.predicate = predicate;
    }

    @Override
    public int limit() {
        return limit;
    }

    @Override
    public Comparator<Comment> comparator() {
        return comparator;
    }

    @Override
    public Predicate<Comment> predicate() {
        return predicate;
    }

    @Override
    public long offset(int page) {
        return (page - 1) * limit;
    }
}
