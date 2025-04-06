package com.test.message.service;

import com.test.message.mapper.NotificationMapper;
import com.test.message.mapper.UserMapper;
import com.test.message.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @Autowired
    private NotificationMapper notificationMapper;
    @Autowired
    private UserMapper  userMapper;
    @Autowired
    private EmailService emailService;


    public List<Notification> getAllNotifications() {
        return notificationMapper.findAll();
    }

    public void saveNotification(String message) {
        Notification notification = new Notification();
        notification.setMessage(message);
        notification.setCreatedAt(LocalDateTime.now());
        notificationMapper.save(notification);
    }

    public void broadcastNotification(Notification notification) {
        messagingTemplate.convertAndSend("/topic/notifications", notification);
    }

    public void sendNotificationToAll(String message) {
        List<String> emails = userMapper.getAllEmails();
        for (String email : emails) {
            try {
                emailService.sendSimpleMail(new String[] { email }, "新通知", message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
