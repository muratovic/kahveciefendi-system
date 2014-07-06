package com.kahveciefendi.base;

public class Condiment extends Beverage{

	/**
	 * This field is used for decorator pattern.
	 */
	private IBeverage beverage;

	public Condiment(IBeverage beverage, String description, double cost){
		super(description, cost);
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return this.beverage.getDescription() + ", "+ super.getDescription();
	}
	
	@Override
	public double cost() {
		return this.beverage.cost() + super.cost();
	}
	
	@Override
	public String toString() {
		return this.getDescription() + " = " + this.cost() ;
	}

}
