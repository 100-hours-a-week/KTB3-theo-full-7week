package com.example.KTB_7WEEK.auth.repository;

import com.example.KTB_7WEEK.app.util.db.table.TokenBlackListTable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TokenRepository {
    private TokenBlackListTable tokenBlackListTable;

    public TokenRepository(TokenBlackListTable tokenBlackListTable) {
        this.tokenBlackListTable = tokenBlackListTable;
    }

    public List<String> findAllTokenBlackList() {
        return tokenBlackListTable.getTable().stream().toList();
    }

    public Optional<Boolean> isBlackList(String token) {
        return Optional.ofNullable(tokenBlackListTable.getTable().contains(token));
    }

    public Optional<Boolean> toBlackList(String token) {
        System.out.println(tokenBlackListTable.getTable());
        return Optional.ofNullable(tokenBlackListTable.getTable().add(token));
    }
}
