package com.example.KTB_7WEEK.app.util.db.table;

import java.util.concurrent.ConcurrentHashMap;

// Table 인터페이스
public interface Table<T> {
    ConcurrentHashMap<Long, T> getTable();

}
