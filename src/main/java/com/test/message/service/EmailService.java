package com.test.message.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmailService {

    @Resource
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.from}")
    private String from;
    public void sendSimpleMail(String[] to, String subject, String content) {
        if (to == null || to.length == 0) {
            throw new IllegalArgumentException("No recipients specified.");
        }
        if (content == null || content.trim().isEmpty()) {
            throw new IllegalArgumentException("Email content cannot be empty.");
        }
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        javaMailSender.send(message);
    }


}

