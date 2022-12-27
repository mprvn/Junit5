package com.mlnprvn.unitest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Month;
import java.util.EnumSet;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ParameterisedTests {
	//https://www.baeldung.com/parameterized-tests-junit-5
	  public static boolean isOdd(int number) {
	        return number % 2 != 0;
	    }
	  
	  public static boolean isBlank(String input) {
	        return input == null || input.trim().isEmpty();
	    }
	  
	  
	  @ParameterizedTest
	  @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE}) // six numbers
	  void isOdd_ShouldReturnTrueForOddNumbers(int number) {
	      assertTrue(ParameterisedTests.isOdd(number));
	  }
	  
	  @ParameterizedTest
	  @ValueSource(strings = {"", "  "})
	  void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
	      assertTrue(ParameterisedTests.isBlank(input));
	  }
	  
	  @ParameterizedTest
	  @NullSource
	  void isBlank_ShouldReturnTrueForNullInputs(String input) {
	      assertTrue(ParameterisedTests.isBlank(input));
	  }
	  
	  
	  @ParameterizedTest
	  @EmptySource
	  void isBlank_ShouldReturnTrueForEmptyStrings(String input) {
	      assertTrue(ParameterisedTests.isBlank(input));
	  }
	  
	  @ParameterizedTest
	  @NullAndEmptySource
	  @ValueSource(strings = {"  ", "\t", "\n"})
	  void isBlank_ShouldReturnTrueForAllTypesOfBlankStrings(String input) {
	      assertTrue(ParameterisedTests.isBlank(input));
	  }
	  
	  @ParameterizedTest
	  @EnumSource(Month.class) // passing all 12 months
	  void getValueForAMonth_IsAlwaysBetweenOneAndTwelve(Month month) {
	      int monthNumber = month.getValue();
	      assertTrue(monthNumber >= 1 && monthNumber <= 12);
	  }
	  
	  @ParameterizedTest
	  @EnumSource(value = Month.class, names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"})
	  void someMonths_Are30DaysLong(Month month) {
	      final boolean isALeapYear = false;
	      assertEquals(30, month.length(isALeapYear));
	  }
	  
	  @ParameterizedTest
	  @EnumSource(
	    value = Month.class,
	    names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER", "FEBRUARY"},
	    mode = EnumSource.Mode.EXCLUDE)
	  void exceptFourMonths_OthersAre31DaysLong(Month month) {
	      final boolean isALeapYear = false;
	      assertEquals(31, month.length(isALeapYear));
	  }
	  
	  @ParameterizedTest
	  @EnumSource(value = Month.class, names = ".+BER", mode = EnumSource.Mode.MATCH_ANY)
	  void fourMonths_AreEndingWithBer(Month month) {
	      EnumSet<Month> months =
	        EnumSet.of(Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER);
	      assertTrue(months.contains(month));
	  }
	  
	  @ParameterizedTest
	  @CsvSource({"test,TEST", "tEst,TEST", "Java,JAVA"})
	  void toUpperCase_ShouldGenerateTheExpectedUppercaseValue(String input, String expected) {
	      String actualValue = input.toUpperCase();
	      assertEquals(expected, actualValue);
	  }
	  
	  
	  @ParameterizedTest
	  @CsvSource(value = {"test:test", "tEst:test", "Java:java"}, delimiter = ':')
	  void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(String input, String expected) {
	      String actualValue = input.toLowerCase();
	      assertEquals(expected, actualValue);
	  }
	  
	  @ParameterizedTest
	  @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
	  void toUpperCase_ShouldGenerateTheExpectedUppercaseValueCSVFile(
	    String input, String expected) {
	      String actualValue = input.toUpperCase();
	      assertEquals(expected, actualValue);
	  }
	  
	  private static Stream<Arguments> provideStringsForIsBlank() {
		    return Stream.of(
		      Arguments.of(null, true),
		      Arguments.of("", true),
		      Arguments.of("  ", true),
		      Arguments.of("not blank", false)
		    );
		}
	  
	  @ParameterizedTest
	  @MethodSource("provideStringsForIsBlank")
	  void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input, boolean expected) {
	      assertEquals(expected, ParameterisedTests.isBlank(input));
	  }
	  
	  @ParameterizedTest
	  @MethodSource // hmm, no method name ...
	  void isBlank_ShouldReturnTrueForNullOrBlankStringsOneArgument(String input) {
	      assertTrue(ParameterisedTests.isBlank(input));
	  }

	  private static Stream<String> isBlank_ShouldReturnTrueForNullOrBlankStringsOneArgument() {
	      return Stream.of(null, "", "  ");
	  }
}
