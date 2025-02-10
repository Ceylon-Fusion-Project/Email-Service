package com.Email_Service.Email_Service.service;

import com.Email_Service.Email_Service.entity.EmailTemplate;
import com.Email_Service.Email_Service.repo.EmailTemplateRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EmailService {

    private final JavaMailSender mailSender;
    private final EmailTemplateRepository templateRepository;

    public EmailService(JavaMailSender mailSender, EmailTemplateRepository templateRepository) {
        this.mailSender = mailSender;
        this.templateRepository = templateRepository;
    }

    public void sendEmail(String recipientEmail, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
        System.out.println("Email sent to: " + recipientEmail);
    }

    public void sendTemplateEmail(String recipientEmail, String templateName, Map<String, String> variables) throws MessagingException {
        EmailTemplate template = templateRepository.findByTemplateName(templateName)
                .orElseThrow(() -> new RuntimeException("Email template not found: " + templateName));

        String subject = template.getSubject();
        String body = replacePlaceholders(template.getBody(), variables);

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(recipientEmail);
        helper.setSubject(subject);
        helper.setText(body, true);

        mailSender.send(message);
        System.out.println("Template email sent to: " + recipientEmail);
    }

    private String replacePlaceholders(String templateBody, Map<String, String> variables) {
        String body = templateBody;
        for (Map.Entry<String, String> entry : variables.entrySet()) {
            body = body.replace("{{" + entry.getKey() + "}}", entry.getValue());
        }
        return body;
    }
}
