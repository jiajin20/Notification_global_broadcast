package com.test.message.controller;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationController {

    private final SimpMessagingTemplate messagingTemplate;

    public NotificationController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    // 发送通知
    @MessageMapping("/sendNotification")
    public void sendNotification(String message) {
        // 向所有连接的客户端发送通知
        messagingTemplate.convertAndSend("/topic/notifications", message);
    }
}
