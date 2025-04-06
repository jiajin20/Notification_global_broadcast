package com.test.message.dto;

import com.test.message.model.EmailRequest;
import com.test.message.model.Notification;

public class NotificationRequestDto {
    private Notification notification;
    private EmailRequest emailRequest;
    private String content;

    public Notification getNotification() {
        return notification;
    }


    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public EmailRequest getEmailRequest() {
        return emailRequest;
    }

    public void setEmailRequest(EmailRequest emailRequest) {
        this.emailRequest = emailRequest;
    }
}
