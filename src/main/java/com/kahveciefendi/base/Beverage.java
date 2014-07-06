package com.kahveciefendi.base;

public class Beverage implements IBeverage {

	private String description;
	private double cost;
	
	public Beverage(String description, double cost) {
		this.description = description;
		this.cost = cost;
	}

	
	@Override
	public String getDescription() {
		return this.description;
	}

	
	@Override
	public double cost() {
		return this.cost;
	}
	
	@Override
	public String toString() {
		return this.getDescription() + " = " + cost() + "TL";
	}

}
