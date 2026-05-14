package com.example.demo

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@Disabled("E2E automation exercise: Spring context smoke test not required")
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
