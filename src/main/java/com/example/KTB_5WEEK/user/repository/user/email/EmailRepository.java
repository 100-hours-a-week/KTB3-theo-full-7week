package com.example.KTB_5WEEK.user.repository.user.email;

import com.example.KTB_5WEEK.user.entity.User;
import com.example.KTB_5WEEK.app.util.db.table.EmailTable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class EmailRepository {
    private final EmailTable emailTable;

    public EmailRepository(EmailTable emailTable) {
        this.emailTable = emailTable;
    }

    // User find By email
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(emailTable.getTable().get(email));
    }

    // Insert User to Email Table
    public Optional<User> mapUserByEmail(User user) {
        ConcurrentHashMap<String, User> emails = emailTable.getTable();
        emails.put(user.getEmail(), user);
        return Optional.ofNullable(emails.get(user.getEmail()));
    }

    // Delete User to Email Table
    public Optional<User> deleteUserByEmail(String email) {
        ConcurrentHashMap<String, User> emails = emailTable.getTable();

        return Optional.ofNullable(emails.remove(email));
    }

}
