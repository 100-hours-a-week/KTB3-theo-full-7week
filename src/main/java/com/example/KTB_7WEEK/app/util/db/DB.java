package com.example.KTB_7WEEK.app.util.db;

import com.example.KTB_7WEEK.app.util.db.table.Table;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class DB {
    private HashMap<String, Table> table_list = new HashMap<>(); // TableList in DB

    public DB() {
    }

    // 테이블 생성 in DB
    public void createTable(String table_name, Table table) {
        table_list.put(table_name, table);
    }

    // 테이블 가져오기 in DB
    public Table getTable(String table_name) {
        return table_list.get(table_name);
    }
}

