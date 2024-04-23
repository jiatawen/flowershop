package com.flowershop.controller.user;


import com.flowershop.service.user.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;
    /**
     * 获取验证码
     * @param email 收件人
     * @return 验证码信息
     */
    @GetMapping("/code")
    public String getCode(@RequestParam("email")String email) throws MessagingException {
        return emailService.sendEmail(email);
    }
}
