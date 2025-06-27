package net.engineeringdigest.journalApp.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTests {

    @Autowired
    private EmailService emailService;

    @Test
    public void senEmailTest(){
        emailService.sendEmail("psaikumariiitkottayam@gmail.com","Hello , This is sai from another email"," hello sai, this is sai kumar from USA");
    }

}