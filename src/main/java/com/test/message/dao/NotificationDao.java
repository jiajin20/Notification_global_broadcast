package com.test.message.dao;


import com.test.message.model.Notification;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NotificationDao {

    private final JdbcTemplate jdbcTemplate;

    public NotificationDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveNotification(Notification notification) {
        String sql = "INSERT INTO notifications (message) VALUES (?)";
        jdbcTemplate.update(sql, notification.getMessage());
    }

    public List<Notification> getAllNotifications() {
        String sql = "SELECT * FROM notifications";
        return jdbcTemplate.query(sql, (RowMapper<Notification>) (rs, rowNum) ->
                new Notification(rs.getString("message"))
        );
    }
}
