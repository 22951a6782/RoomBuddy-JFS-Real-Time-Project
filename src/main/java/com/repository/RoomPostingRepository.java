package com.example.my_project.repository;

import com.example.my_project.entity.RoomPosting;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class RoomPostingRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int saveRoomPosting(RoomPosting roomPosting) {
        String sql = "INSERT INTO room_postings (full_name, city, rent, description, phone) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, roomPosting.getFullName(), roomPosting.getCity(), roomPosting.getRent(), roomPosting.getDescription(), roomPosting.getPhone());
    }
    
}
