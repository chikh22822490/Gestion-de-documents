package com.yasmine.pfe.services.interfaces;

public interface EmailSenderService {
    void sendEmail(String to, String subject, String message);
}
