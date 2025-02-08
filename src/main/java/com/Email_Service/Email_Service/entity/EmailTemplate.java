package com.Email_Service.Email_Service.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "email_templates")
public class EmailTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String templateName; // Unique name for the template (e.g., REGISTRATION_VERIFICATION)

    @Column(nullable = false)
    private String subject; // Subject of the email template

    @Column(columnDefinition = "TEXT", nullable = false)
    private String body; // Body of the email template (can include placeholders like {name}, {verificationLink})
}
