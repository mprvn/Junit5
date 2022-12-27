package com.mlnprvn.unitest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class BeforeAfterTest {

	@BeforeAll public static void beforeAllTest() {
		System.out.println("Before All test .... ");
	}
	
	@AfterAll public static void AfterAllTest() {
		System.out.println("After All test .... ");
	}
	
	@BeforeEach public void beforeEachTest() {
		System.out.println("Before Each test .... ");
	}
	
	@AfterEach public void AfterEachTest() {
		System.out.println("After Each test .... ");
	}
	
	public int add(int a , int b ) {
		return a+b;
	}
	@Test
	public void testAddMethod() {
		assertEquals(6, add(2,4));
	}
	
	@Test
	public void negativeTestAddMethod() {
		assertEquals( add(-2,-3), -5);
	}
}
