package com.test.message.controller;

import com.test.message.dto.NotificationRequestDto;


import com.test.message.service.NotificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:8080")  // 允许来自指定源的跨域请求
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    // 获取所有通知
    @GetMapping
    public List<com.test.message.model.Notification> getNotifications() {
        return notificationService.getAllNotifications();
    }


    @PostMapping("/send")
    public ResponseEntity<?> sendNotification( @RequestBody NotificationRequestDto request) {
        System.out.println(request);
        try {

            notificationService.saveNotification(request.getEmailRequest().getContent());

            notificationService.broadcastNotification(request.getNotification());

            notificationService.sendNotificationToAll(request.getEmailRequest().getContent());
            return ResponseEntity.ok("通知已发送");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("发送失败");
        }
    }








}
