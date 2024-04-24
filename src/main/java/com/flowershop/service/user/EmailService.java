package com.flowershop.service.user;

import javax.mail.MessagingException;

public interface EmailService {
    public String sendEmail(String email) throws MessagingException;

    public boolean register(String code, String email);
}
