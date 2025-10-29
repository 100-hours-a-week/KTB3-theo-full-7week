package com.example.KTB_5WEEK.app.util.db.table;


import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class TokenBlackListTable {
    private Set<String> blackList = Collections.synchronizedSet(new HashSet<>());

    public TokenBlackListTable() {
    }

    public Set<String> getTable() {
        return blackList;
    }
}
