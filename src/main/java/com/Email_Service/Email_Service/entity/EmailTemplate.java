package com.Email_Service.Email_Service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "email_templates")
public class EmailTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String templateName; // e.g., "USER_REGISTRATION", "BOOKING_CONFIRMATION"

    private String subject; // Email subject

    @Column(columnDefinition = "TEXT")
    private String body; // Email body with placeholders like {{username}}

    private String templateType; // "HTML" or "TEXT"
}
