package com.example.tarea3;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Tarea3ApplicationTests {

	private Tarea3 Test = new Tarea3();

	@Test
	void contextLoads() {
		Test.push(100);
		Test.push(1000);
		Test.push((float) 19.95);
		assertEquals("[100.0, 1000.0, 19.95]", Test.print().toString());
		Test.pop();
		assertEquals("[1000.0, 19.95]", Test.print().toString());
		Test.clear();
		assertEquals("[]", Test.print().toString());
	}
}
