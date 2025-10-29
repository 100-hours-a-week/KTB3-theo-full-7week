package com.example.KTB_7WEEK.app.util.db.table;

import com.example.KTB_7WEEK.user.entity.User;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class EmailTable implements Table{
    private ConcurrentHashMap<String, User> emails = new ConcurrentHashMap<>();

    @Override
    public ConcurrentHashMap<String, User> getTable() {
        return this.emails;
    }

}
