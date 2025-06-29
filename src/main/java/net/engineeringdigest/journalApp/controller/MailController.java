package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class MailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/send-mail")
    public String testMail() {
        emailService.sendEmail("dipakpawaras356@gmail.com", "Test Subject", "Test Body");
        return "Mail Sent";
    }
}
