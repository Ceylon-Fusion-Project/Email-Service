package com.Email_Service.Email_Service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "email_templates")
public class EmailTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "template_name", nullable = false, unique = true)
    private String templateName; // e.g., "USER_REGISTRATION", "BOOKING_CONFIRMATION"

    @Column(name = "subject", nullable = false)
    private String subject; // Email subject

    @Column(name = "body", columnDefinition = "TEXT", nullable = false)
    private String body; // Email body with placeholders like {{username}}

    @Column(name = "template_type", nullable = false)
    private String templateType; // "HTML" or "TEXT"

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
