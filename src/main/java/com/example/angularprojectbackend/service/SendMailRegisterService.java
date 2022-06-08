package com.example.angularprojectbackend.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public record SendMailRegisterService (JavaMailSender mailSender){
    public void mailToRegister() {

            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setTo("natwui001@gmail.com");
            simpleMailMessage.setFrom("mailforstudy556677@gmail.com");
            simpleMailMessage.setText("สวัสดี");
            simpleMailMessage.setSubject("Hello");

            mailSender.send(simpleMailMessage);
    }
}
