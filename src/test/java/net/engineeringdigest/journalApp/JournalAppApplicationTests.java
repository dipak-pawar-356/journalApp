package net.engineeringdigest.journalApp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = JournalAppApplication.class)
@ActiveProfiles("test") // and use dummy properties in application-test.yml

class JournalAppApplicationTests {

	@Test
	void contextLoads() {
	}

}
