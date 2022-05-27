package com.yasmine.pfe.services.implementations;

import com.yasmine.pfe.services.interfaces.EmailSenderService;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderServiceImplementation implements EmailSenderService{

    private final JavaMailSender mailSender;

    public EmailSenderServiceImplementation(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(String to, String subject, String message) {
        SimpleMailMessage simpleMailMessage =  new SimpleMailMessage();
        simpleMailMessage.setFrom("tenstep@gmail.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
         
        this.mailSender.send(simpleMailMessage);
        
    }
    
}
