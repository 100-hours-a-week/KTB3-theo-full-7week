package com.example.KTB_5WEEK.user.repository.user;

import com.example.KTB_5WEEK.user.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserRepository {
    List<User> findAll();

    Optional<User> regist(User user);

    Optional<User> findById(long id);

    Optional<User> updateById(long id, User target);

    Optional<User> deleteById(long id);
}
