package com.prismatic.leavemanagementsystem.controller;

import com.prismatic.leavemanagementsystem.entity.User;
import com.prismatic.leavemanagementsystem.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequestMapping(value = "/lms")
@CrossOrigin("*")
public class RegistrationController {


    @Autowired
    private MailService notificationService;

    @Autowired
    private User user;

    /**
     *
     * @return
     */
//    @RequestMapping("/send-mail")
    @PostMapping("/send-mail")
    public String send() {

        /*
         * Creating a User with the help of User class that we have declared and setting
         * Email address of the sender.
         */
        user.setEmailAddress("ramkrishna@prissoft.net");  //Receiver's email address
        /*
         * Here we will call sendEmail() for Sending mail to the sender.
         */
        try {
            notificationService.sendEmail(user);
        } catch (MailException mailException) {
            System.out.println(mailException);
        }
        return "Congratulations! Your mail has been send to the user.";
    }

    /**
     *
     * @return
     * @throws javax.mail.MessagingException
     */
    @RequestMapping("/send-mail-attachment")
    public String sendWithAttachment() throws MessagingException {

        /*
         * Creating a User with the help of User class that we have declared and setting
         * Email address of the sender.
         */
        user.setEmailAddress("ramkrishna@prissoft.net"); //Receiver's email address

        /*
         * Here we will call sendEmailWithAttachment() for Sending mail to the sender
         * that contains a attachment.
         */
        try {
            notificationService.sendEmailWithAttachment(user);
        } catch (MailException mailException) {
            System.out.println(mailException);
        }
        return "Congratulations! Your mail-attachment has been send to the user.";
    }


}
