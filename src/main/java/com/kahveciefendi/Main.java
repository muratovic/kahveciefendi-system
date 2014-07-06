package com.kahveciefendi;

import org.apache.log4j.Logger;

import com.kahveciefendi.base.KahveciEfendi;

public class Main {
	
	private static final Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		logger.info("Application started!");
		KahveciEfendi kahveciEfendi = new KahveciEfendi();
		kahveciEfendi.takeOrder();
		logger.info("Finished! Took " + (System.currentTimeMillis() - startTime) + "ms");
	}
	
}
