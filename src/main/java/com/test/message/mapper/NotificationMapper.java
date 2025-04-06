package com.test.message.mapper;

import com.test.message.model.Notification;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NotificationMapper {

    @Select("SELECT * FROM notifications")
    List<Notification> findAll();

    @Insert("INSERT INTO notifications (message, created_at) VALUES (#{message}, #{createdAt})")
    void save(Notification notification);
}
