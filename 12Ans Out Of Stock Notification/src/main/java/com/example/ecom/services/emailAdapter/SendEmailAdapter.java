package com.example.ecom.services.emailAdapter;

public interface SendEmailAdapter {
    void sendEmailAsync(String email, String subject, String body);
}
