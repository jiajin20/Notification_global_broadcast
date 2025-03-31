package com.test.message.service;

import com.test.message.dao.NotificationDao;
import com.test.message.model.Notification;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationDao notificationDao;

    public NotificationService(NotificationDao notificationDao) {
        this.notificationDao = notificationDao;
    }

    // 保存通知到数据库
    public void saveNotification(Notification notification) {
        notificationDao.saveNotification(notification);
    }

    // 获取所有通知
    public void sendAllNotifications() {
        notificationDao.getAllNotifications().forEach(notification -> {
            // 将通知通过 WebSocket 推送到所有连接的客户端
            // 这里我们可以将发送通知的功能加入
        });
    }
}
