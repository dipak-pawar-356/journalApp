package net.engineeringdigest.journalApp;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public class JournalEntryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

//    @BeforeEach
//    void setUp() {
//        userRepository.deleteAll();
//
//        // Create a test user WITHOUT any journal entries
//        User user = new User();
//        user.setId(new ObjectId());
//        user.setUserName("testuser");
//        user.setPassword("password");
//        user.setJournalEntries(Collections.emptyList());  // 🚫 No journal entries
//
//        userRepository.save(user);
//    }

//    @Test
////    @WithMockUser(username = "testuser")
//    public void testGetAll_whenNoEntries_then404() throws Exception {
//        mockMvc.perform(get("/journals"))
//                .andExpect(status().isNotFound());  // ✅ Expect 404 since no journal entries exist
//    }
}
