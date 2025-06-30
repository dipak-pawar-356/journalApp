package net.engineeringdigest.journalApp.service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class EmailServiceTests {

    @InjectMocks
    private EmailService emailService;

    @Mock
    private JavaMailSender javaMailSender;


    @Test
    public void sendEmailTest() {
        emailService.sendEmail(
                "dipakpawaras356@gmail.com",
                "Test Subject",
                "Test Body"
        );

        verify(javaMailSender, times(1)).send(any(SimpleMailMessage.class));
    }
}
