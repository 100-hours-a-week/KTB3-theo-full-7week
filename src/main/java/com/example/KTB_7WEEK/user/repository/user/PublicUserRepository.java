package com.example.KTB_7WEEK.user.repository.user;

import com.example.KTB_7WEEK.user.entity.User;
import com.example.KTB_7WEEK.app.util.db.table.UserTable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PublicUserRepository implements UserRepository {
    private final UserTable userTable;

    public PublicUserRepository(UserTable table) {
        this.userTable = table;
    }

    @Override // 전체 User 조회
    public List<User> findAll() {
        return userTable.getTable().values().stream().toList();
    }

    @Override // User PK 조회
    public Optional<User> findById(long id) {
        return Optional.ofNullable(userTable.getTable().get(id));
    }

    @Override // 회원가입
    public Optional<User> regist(User user) {
        ConcurrentHashMap<Long, User> users = userTable.getTable();
        long userId = userTable.increaseSequence();
        user.identify(userId);
        users.put(userId, user);
        return Optional.ofNullable(users.get(userId));
    }

    @Override // User 수정 By Id
    public Optional<User> updateById(long id, User target) {
        target.updateNow();
        userTable.getTable().put(id, target);
        return Optional.ofNullable(userTable.getTable().get(id));
    }

    @Override // User 삭제 By Id
    public Optional<User> deleteById(long id) {
        User delete_user = findById(id).get();
        delete_user.softDelete();
        updateById(id, delete_user);
        return Optional.ofNullable(userTable.getTable().remove(id));
    }
}
