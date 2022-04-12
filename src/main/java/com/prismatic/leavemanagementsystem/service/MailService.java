package com.prismatic.leavemanagementsystem.service;


import com.prismatic.leavemanagementsystem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailService {

    /*
     * The Spring Framework provides an easy abstraction for sending email by using
     * the JavaMailSender interface, and Spring Boot provides auto-configuration for
     * it as well as a starter module.
     */
    private JavaMailSender javaMailSender;

    /**
     *
     * @param javaMailSender
     */
    @Autowired
    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    /**
     * This function is used to send mail without attachment.
     * @param user
     * @throws MailException
     */

    public void sendEmail(User user) throws MailException {

        /*
         * This JavaMailSender Interface is used to send Mail in Spring Boot. This
         * JavaMailSender extends the MailSender Interface which contains send()
         * function. SimpleMailMessage Object is required because send() function uses
         * object of SimpleMailMessage as a Parameter
         */

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmailAddress());
        mail.setCc("ramkrishna.sheral@gmail.com");
        mail.setSubject("Leave Application For Medical Leave");
        mail.setText("Hello sir," +
                "I am feeling sick ,so request you to grant a holiday leave for me");

        /*
         * This send() contains an Object of SimpleMailMessage as an Parameter
         */
        javaMailSender.send(mail);
    }

    /**
     * This fucntion is used to send mail that contains a attachment.
     *
     * @param user
     * @throws MailException
     * @throws javax.mail.MessagingException
     */
    public void sendEmailWithAttachment(User user) throws MailException, MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setTo(user.getEmailAddress());
        helper.setSubject("Testing Mail API with Attachment");
        helper.setText("Please find the attached document below.");

//        ClassPathResource classPathResource = new ClassPathResource("C:\\Users\\admin\\Desktop\\medicine_ prescription.jpg");
//        helper.addAttachment(classPathResource.getFilename(), classPathResource);

        FileSystemResource fileSystem
                = new FileSystemResource(new File("C:\\Users\\admin\\Desktop\\medicine_prescription.jpg"));

        helper.addAttachment(fileSystem.getFilename(),
                fileSystem);
        javaMailSender.send(mimeMessage);
    }

}