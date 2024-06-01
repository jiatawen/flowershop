package com.flowershop.service.user;

import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public interface EmailService {
    public String sendEmail(String email) throws MessagingException;

    public boolean check(String code, String email);
}
