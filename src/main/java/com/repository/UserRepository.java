package com.example.my_project.repository;

import com.example.my_project.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int saveUser(User user) {
        String sql = "INSERT INTO users (username, email, password, phone) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, user.getUsername(), user.getEmail(), user.getPassword(), user.getPhone());
    }

    public boolean validateUser(String username, String password) {
        String sql = "SELECT password FROM users WHERE username = ?";

        try {
            String storedPassword = jdbcTemplate.queryForObject(sql, String.class, username);

            // Check if passwords match
            return storedPassword != null && storedPassword.equals(password);
        } catch (EmptyResultDataAccessException e) {
            return false; // No user found
        }
    }

}
