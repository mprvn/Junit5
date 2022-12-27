package com.mlnprvn.unitest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UnitestApplicationTests {

	public int add(int a , int b ) {
		return a+b;
	}
	@Test
	public void testAddMethod() {
		assertEquals(6, add(2,4));
	}
	
	@Test
	@Disabled
	public void negativeTestAddMethod() {
		assertEquals( add(-2,-3), 5);
	}
	
	
	@Test
	void contextLoads() {
	}

}
