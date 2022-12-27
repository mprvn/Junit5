package com.mlnprvn.unitest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
class InvalidAgeException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7299219071342728863L;

	InvalidAgeException(String message){
		super(message);
	}
}
@SpringBootTest
public class VakidateInputException {
	
   public void validateAge(int age ) throws InvalidAgeException {
	   if(age>18) {
		   throw new InvalidAgeException("Age is not valid ");
	   }
   }
   
   
   @Test public void testvalidateAge() throws InvalidAgeException {
	   
	   Exception exception = assertThrows(InvalidAgeException.class, () -> {
	        validateAge(20);
	    });

	    String expectedMessage = "Age is not valid ";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
   }
   
 @Test public void testvalidateAgeParent() throws InvalidAgeException {
	   
	   Exception exception = assertThrows(Exception.class, () -> {
	        validateAge(20);
	    });

	    String expectedMessage = "Age is not valid ";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
   }

}
