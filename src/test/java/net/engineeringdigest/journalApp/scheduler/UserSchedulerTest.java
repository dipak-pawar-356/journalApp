package net.engineeringdigest.journalApp.scheduler;


import net.engineeringdigest.journalApp.model.SentimentData;
import net.engineeringdigest.journalApp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
public class UserSchedulerTest{



    @Autowired
    private UserScheduler userScheduler;

    @MockitoBean
    private KafkaTemplate<String, SentimentData> kafkaTemplate;

    @MockitoBean
    private UserService userService;

    @MockitoBean
    private JavaMailSender mailSender;

    @Test
    public void testFetchUsersAndSendSaMail(){
        userScheduler.fetchUsersAndSendSaMail();
    }
}