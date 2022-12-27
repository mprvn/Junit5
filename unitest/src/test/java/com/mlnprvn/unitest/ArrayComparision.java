package com.mlnprvn.unitest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArrayComparision {
	@Test
	public void arrayTest() {
		String[] expected = {"Apple", "Orage", "Mango"};
		String[] actual = {"Apple", "Orage", "Mango"};
		assertArrayEquals(expected, actual);
	}
	
	@Test
	@Disabled
	public void arrayMismatchTest() {
		String[] expected = {"Apple", "cake", "Mango"};
		String[] actual = {"Apple", "Orage", "Mango"};
		assertArrayEquals(expected, actual);
	}

}
