package com.Email_Service.Email_Service.controller;


import com.Email_Service.Email_Service.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/emails")
public class MailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendEmail(
            @RequestParam String recipientEmail,
            @RequestParam String subject,
            @RequestParam String body) {
        emailService.sendEmail(recipientEmail, subject, body);
        return "Email sent successfully!";
    }
}
