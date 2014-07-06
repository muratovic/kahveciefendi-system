package com.kahveciefendi.base;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.kahveciefendi.base.Beverage;
import com.kahveciefendi.base.IBeverage;
import com.kahveciefendi.base.KahveciEfendi;

@RunWith(JUnit4.class)
public class KahveciEfendiTest {

	@Test
	public void testPrepareBeverageWithTwoItems(){
		KahveciEfendi kahveciEfendi = new KahveciEfendi();
		KeyValuePair latte = new KeyValuePair("Latte", 5.0);
		KeyValuePair cay = new KeyValuePair("Cay", 3.0);
		List<KeyValuePair> beverageList = new ArrayList<KeyValuePair>();
		beverageList.add(latte);
		beverageList.add(cay);
		IBeverage preparedBeverage = kahveciEfendi.prepareBeverage(beverageList, "1");
		assertEquals("Latte", preparedBeverage.getDescription());
	}
	
	@Test
	public void testPrepareBeverageWithEmptyList(){
		KahveciEfendi kahveciEfendi = new KahveciEfendi();
		List<KeyValuePair> beverageList = new ArrayList<KeyValuePair>();
		IBeverage preparedBeverage = kahveciEfendi.prepareBeverage(beverageList, "1");
		assertEquals(null, preparedBeverage);

	}
	
	@Test
	public void testPrepareBeverageWithInvalidInput(){
		KahveciEfendi kahveciEfendi = new KahveciEfendi();
		KeyValuePair latte = new KeyValuePair("Latte", 5.0);
		KeyValuePair cay = new KeyValuePair("Cay", 3.0);
		List<KeyValuePair> beverageList = new ArrayList<KeyValuePair>();
		beverageList.add(latte);
		beverageList.add(cay);
		IBeverage preparedBeverage = kahveciEfendi.prepareBeverage(beverageList, "4");
		assertEquals(null, preparedBeverage);
	}
	
	@Test
	public void testPrepareCondimentWithTwoItems(){
		KahveciEfendi kahveciEfendi = new KahveciEfendi();
		IBeverage latte = new Beverage("Latte", 5.0);
		List<KeyValuePair> condimentList = new ArrayList<KeyValuePair>();
		condimentList.add(new KeyValuePair("Milk", 2.0));		
		condimentList.add(new KeyValuePair("Mint", 3.0));		
		IBeverage preparedCondiment = kahveciEfendi.prepareCondiment(condimentList, latte, "1");
		assertEquals("Latte, Milk", preparedCondiment.getDescription());
	}
	
	@Test
	public void testPrepareCondimentWithEmptyList(){
		KahveciEfendi kahveciEfendi = new KahveciEfendi();
		IBeverage latte = new Beverage("Latte", 5.0);
		List<KeyValuePair> condimentList = new ArrayList<KeyValuePair>();
		IBeverage preparedCondiment = kahveciEfendi.prepareCondiment(condimentList, latte, "1");
		assertEquals(null, preparedCondiment);
	}
	
	@Test
	public void testPrepareCondimentWithInvalidInput(){
		KahveciEfendi kahveciEfendi = new KahveciEfendi();
		IBeverage latte = new Beverage("Latte", 5.0);
		List<KeyValuePair> condimentList = new ArrayList<KeyValuePair>();
		condimentList.add(new KeyValuePair("Milk", 2.0));		
		condimentList.add(new KeyValuePair("Mint", 3.0));		
		IBeverage preparedCondiment = kahveciEfendi.prepareCondiment(condimentList, latte, "10");
		assertEquals(null, preparedCondiment);
	}
	
}