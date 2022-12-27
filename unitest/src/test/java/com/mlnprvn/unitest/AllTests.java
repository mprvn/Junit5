package com.mlnprvn.unitest;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@SelectClasses({ ArrayComparision.class, BeforeAfterTest.class, UnitestApplicationTests.class,
		VakidateInputException.class, ParameterisedTests.class })
@Suite
public class AllTests {

}
