package com.example.KTB_5WEEK.app.util.paginationPolicy;

import com.example.KTB_5WEEK.post.entity.Post;

import java.util.Comparator;
import java.util.function.Predicate;

public enum PostPaginationPolicy implements PaginationPolicy {
    DEFAULT(10,
            Comparator.comparing(Post::getCreatedAt).thenComparing(Post::getId),
            post -> !post.isDeleted());

    private final int limit;
    private final Comparator<Post> comparator;
    private final Predicate<Post> predicate;

    PostPaginationPolicy(int limit, Comparator<Post> comparator, Predicate<Post> predicate) {
        this.limit = limit;
        this.comparator = comparator;
        this.predicate = predicate;
    }

    @Override
    public int limit() {
        return this.limit;
    }

    @Override
    public Comparator<Post> comparator() {
        return this.comparator;
    }

    @Override
    public Predicate<Post> predicate() {
        return this.predicate;
    }

    @Override
    public long offset(int page) {
        return (page - 1) * limit;
    }
}
