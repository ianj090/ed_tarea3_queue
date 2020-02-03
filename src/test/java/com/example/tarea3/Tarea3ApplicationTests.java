package com.example.tarea3;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Tarea3ApplicationTests {

	private Tarea3 Test = new Tarea3();

	@Test
	void contextLoads() {
		Test.push("John", "200");
		Test.push("Mike", "300");
		Test.push("Ian", "26.34");
		assertEquals("[John, 200, Mike, 300, Ian, 26.34]", Arrays.toString(Test.print()));
		Test.pop();
		assertEquals("[John, 200, Mike, 300, null, null]", Arrays.toString(Test.print()));
		Test.clear();
		assertEquals("[null, null, null, null, null, null]", Arrays.toString(Test.print()));
	}
}
