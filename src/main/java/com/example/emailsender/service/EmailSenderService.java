package com.example.emailsender.service;

import jakarta.mail.MessagingException;

public interface EmailSenderService {

    String messageSender(String email,String subject,String message);
    String sendEmailWithAttachment(String toEmail,
                                        String body,
                                        String subject,
                                        String attachment) throws MessagingException;

}
