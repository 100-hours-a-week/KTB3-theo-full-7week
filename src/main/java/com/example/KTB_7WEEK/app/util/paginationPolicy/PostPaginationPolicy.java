package com.example.KTB_7WEEK.app.util.paginationPolicy;

import com.example.KTB_7WEEK.post.entity.Post;

import java.util.Comparator;
import java.util.function.Predicate;

public enum PostPaginationPolicy implements PaginationPolicy {
    DEFAULT(10);

    private final int size;

    PostPaginationPolicy(int size) {
        this.size = size;
    }

    @Override
    public int size() {
        return this.size;
    }

}
