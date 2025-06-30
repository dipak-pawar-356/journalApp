//package net.engineeringdigest.journalApp.service;
//import net.engineeringdigest.journalApp.entity.User;
////import net.engineeringdigest.journalApp.model.User;
//import net.engineeringdigest.journalApp.repository.UserRepository;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ArgumentsSource;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.junit.jupiter.params.provider.ValueSource;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
////import org.springframework.boot.test.mock.mockito.MockBean;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class UserServiceTests {
//
//    @Autowired
//    @MockitoBean
//    private UserRepository userRepository;
//
//    @Autowired
//    private UserService userService;
//
//
//
//    @ParameterizedTest
//    @ArgumentsSource(UserArgumentsProvider.class)
//    public void testFindByUserName(User user){
//        assertTrue(userService.saveNewUser(user));
//    }
//
//
//    @Disabled
//    @ParameterizedTest
//    @CsvSource({
//            "ramRAM","abc","guru"
//    })
//    public void testFindByUserName(String name){
//        assertNotNull(userRepository.findByUserName(name));
//    }
//}






//package net.engineeringdigest.journalApp.service;

//import net.engineeringdigest.journalApp.entity.User;
//import net.engineeringdigest.journalApp.repository.UserRepository;
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ArgumentsSource;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.junit.jupiter.params.provider.ValueSource;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@ExtendWith(MockitoExtension.class)
//@AutoConfigureDataMongo
//public class UserServiceTests {
//
//    @Autowired
//    @Mock
//    private UserRepository userRepository;
//
//    @Autowired
//    @InjectMocks
//    private UserService userService;
//
//
//    @Disabled
//    @ParameterizedTest
//    @ArgumentsSource(UserArgumentsProvider.class)
//    public void testSaveNewUser(User user) {
//        assertTrue(userService.saveNewUser(user));
//    }
//
//    @Disabled
//    @ParameterizedTest
//    @CsvSource({
//            "1,1,2",
//            "2,10,12",
//            "3,3,9"
//    })
//    public void test(int a, int b, int expected){
//        assertEquals(expected, a + b);
//    }
//
//    @Test
//    void testFindByUserName() {
//        User mockUser = new User();
//        mockUser.setUserName("dipak");
//
//        when(userRepository.findByUserName("dipak")).thenReturn(Optional.of(mockUser));
//
//        Optional<User> result = userService.findByUserName("dipak");
//        assertTrue(result.isPresent()); // ✅ Should pass now
//    }
//}











package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)  // Only Mockito
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testFindByUserName() {
        User mockUser = User.builder()
                .userName("dipak")
                .password("1234")
                .email("dipak@test.com")
                .build();

        when(userRepository.findByUserName("dipak")).thenReturn(mockUser);

        User result = userService.findByUserName("dipak");

        assertNotNull(result);
        assertEquals("dipak", result.getUserName());
    }
}

