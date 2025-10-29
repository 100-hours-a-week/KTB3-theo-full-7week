package com.example.KTB_5WEEK.app.util.db.table;

import com.example.KTB_5WEEK.user.entity.User;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class UserTable implements Table {
    private ConcurrentHashMap<Long, User> users = new ConcurrentHashMap<>();
    private AtomicLong sequence = new AtomicLong(1);

    public UserTable() {
    }

    @Override // DB User Table 조회
    public ConcurrentHashMap<Long, User> getTable() {
        return users;
    }

    public long increaseSequence() {
        return sequence.getAndIncrement();
    }

}
