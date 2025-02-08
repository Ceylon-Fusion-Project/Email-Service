package com.Email_Service.Email_Service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "email_logs")
public class EmailLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String recipientEmail; // Email address of the recipient

    @Column(nullable = false)
    private String subject; // Email subject

    @Column(columnDefinition = "TEXT", nullable = false)
    private String body; // Email body

    @Column(nullable = false)
    private String status; // Status of the email (e.g., SENT, FAILED)

    @Column(nullable = false)
    private LocalDateTime sentAt; // Timestamp when the email was sent

    @Column(columnDefinition = "TEXT")
    private String errorMessage; // Error message if the email failed to send
}
