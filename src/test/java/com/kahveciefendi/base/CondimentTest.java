package com.kahveciefendi.base;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.kahveciefendi.base.Beverage;
import com.kahveciefendi.base.Condiment;
import com.kahveciefendi.base.IBeverage;

@RunWith(JUnit4.class)
public class CondimentTest {

	@Test
	public void testCostMethodWithOneCondiment(){
		IBeverage latte = new Beverage("Latte", 5);
		IBeverage milk = new Condiment(latte, "Milk", 2);
		assertEquals(7, milk.cost(), 0);
	}
	
	@Test
	public void tesCostMethodWithMoreThatOneCondiments(){
		IBeverage latte = new Beverage("Latte", 5);
		IBeverage milk = new Condiment(latte, "Milk", 2);
		IBeverage condiment = new Condiment(milk, "Mint", 3);
		assertEquals(10, condiment.cost(),0);
		
	}
	
	@Test
	public void testGetDescriptionMethodWithOneCondiment(){
		IBeverage latte = new Beverage("Latte", 5);
		IBeverage milk = new Condiment(latte, "Milk", 2);
		assertEquals("Latte, Milk", milk.getDescription());
	}
	
	@Test
	public void testGetDescriptionMethodWithMoreThanOneCondiments(){
		IBeverage latte = new Beverage("Latte", 5);
		IBeverage milk = new Condiment(latte, "Milk", 2);
		IBeverage mint= new Condiment(milk, "Mint", 3);
		assertEquals("Latte, Milk, Mint", mint.getDescription());
		
	}
	
}
