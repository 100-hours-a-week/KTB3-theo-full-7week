package com.example.KTB_7WEEK.app.util.db.table;

import com.example.KTB_7WEEK.post.entity.Comment;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class CommentTable implements Table {
    private ConcurrentHashMap<Long, Comment> comments = new ConcurrentHashMap<>();
    private AtomicLong sequence = new AtomicLong(1);

    public CommentTable() {
    }

    @Override
    public ConcurrentHashMap<Long, Comment> getTable() {
        return this.comments;
    }

    public long increaseSequence() {
        return sequence.getAndIncrement();
    }
}
