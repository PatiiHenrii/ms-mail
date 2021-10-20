package com.ms.mail.services;

import com.ms.mail.enums.StatusMail;
import com.ms.mail.models.MailModel;
import com.ms.mail.repositories.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MailService {

    @Autowired
    MailRepository mailRepository;

    private JavaMailSender mailSender;

    public MailModel sendMail(MailModel mailModel) {
        mailModel.setSendDateMail(LocalDateTime.now());
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(mailModel.getMailFrom());
            message.setTo(mailModel.getMailTo());
            message.setSubject(mailModel.getSubject());
            message.setText(mailModel.getText());
            mailSender.send(message);
            mailModel.setStatusMail(StatusMail.SENT);
        } catch (NullPointerException e){
            mailModel.setStatusMail(StatusMail.ERROR);
        } finally {
            return mailRepository.save(mailModel);
        }
    }
}
