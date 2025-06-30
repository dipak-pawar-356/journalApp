package net.engineeringdigest.journalApp.service;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@ActiveProfiles("test")
@SpringBootTest
public class RedisTests {


    @Autowired
    @MockitoBean
    private RedisTemplate<String, String> redisTemplate;





    @Disabled
    @Test
    void testSendMail(){

        redisTemplate.opsForValue().set("email","sai@email.com");

        Object salary= redisTemplate.opsForValue().get("salary");

        int x=56;


    }
}