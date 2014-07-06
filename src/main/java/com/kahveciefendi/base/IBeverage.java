package com.kahveciefendi.base;

/**
 * Interface for Beverage.
 * 
 * @see Beverage
 * @author omer
 *
 */
public interface IBeverage {

	/**
	 * Returns description of beverage.
	 * @return description
	 */
	String getDescription();
	
	/**
	 * Returns cost of beverage.
	 * @return cost
	 */
	double cost();
	
}
