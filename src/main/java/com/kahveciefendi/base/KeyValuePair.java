package com.kahveciefendi.base;

import com.kahveciefendi.utility.CommonUtility;

/**
 * Wrapper class for properties that are read from the property files.
 * 
 * @author omer
 * @see CommonUtility 
 */

public class KeyValuePair {
	
	private String key;
	private double value;
	
	public KeyValuePair(String key, double value) {
		this.key = key;
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
}
