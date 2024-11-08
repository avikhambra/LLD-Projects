package com.example.ecom.services.emailAdapter;

import com.example.ecom.libraries.Sendgrid;

public class SendGridAdapterApi implements SendEmailAdapter {
    private Sendgrid sendgrid;

    public SendGridAdapterApi() {
        this.sendgrid = new Sendgrid();
    }

    @Override
    public void sendEmailAsync(String email, String subject, String body) {
        sendgrid.sendEmailAsync(email,subject,body);
        return;
    }
}
