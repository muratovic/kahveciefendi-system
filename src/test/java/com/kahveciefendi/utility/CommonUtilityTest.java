package com.kahveciefendi.utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.kahveciefendi.base.KeyValuePair;

@RunWith(JUnit4.class)
public class CommonUtilityTest {
	
	@Test
	public void testIsNumericWithNumber(){
		boolean numeric = CommonUtility.isNumeric("1");
		assertTrue(numeric);
	}
	
	@Test
	public void testIsNumericWithString(){
		boolean notNumeric = CommonUtility.isNumeric("test");
		assertFalse(notNumeric);
	}
	
	@Test
	public void testIsNumericWithNull(){
		boolean notNumeric = CommonUtility.isNumeric(null);
		assertFalse(notNumeric);
	}
	
	@Test
	public void testgetUserInputWithNumber(){
		String inputData = "5";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		String userInput = CommonUtility.getUserInput();
		assertEquals(inputData, userInput);
	}
	
	@Test
	public void testgetUserInputWithString(){
		String inputData = "testMessage";
		System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
		String userInput = CommonUtility.getUserInput();
		assertEquals(inputData, userInput);
	}
	
	@Test
	public void testGetKeysAndValuesBeverages() throws FileNotFoundException {
		List<KeyValuePair> beveragesPairs = CommonUtility.getKeysAndValues("beverages.properties");
		assertEquals(6, beveragesPairs.size());
	}

	@Test
	public void testGetKeysAndValuesCondiments() throws FileNotFoundException {
		List<KeyValuePair> condimentsPairs = CommonUtility.getKeysAndValues("condiments.properties");
		assertEquals(3, condimentsPairs.size());
	}

}
