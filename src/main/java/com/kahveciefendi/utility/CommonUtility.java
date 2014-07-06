package com.kahveciefendi.utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.kahveciefendi.base.KeyValuePair;

/**
 * Utility class for common operations
 * @author omer
 *
 */
public class CommonUtility {

	private CommonUtility(){
	}
	
	/**
	 * Checks whether given input is numeric or not
	 * @param input
	 */
	public static boolean isNumeric(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	
	public static void printList(List<KeyValuePair> pairList) {
		for (int i = 0; i < pairList.size(); i++) {
			KeyValuePair pair = pairList.get(i);
			StringBuilder builder = new StringBuilder();
			builder.append(i + 1).append("-").append(pair.getKey()).append(" = ").append(pair.getValue())
					.append("TL");
			System.out.println(builder.toString());
		}
	}

	public static String getUserInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String readLine = null;
		try {
			readLine = br.readLine();
		} catch (IOException ioe) {
			System.err.println("I/O Error!" + ioe.getMessage());
		}
		return readLine;
	}

	public static KeyValuePair getPairFromGivenList(List<KeyValuePair> pairList, String userInput) {
			KeyValuePair pair = null;
			int i = Integer.parseInt(userInput);
			int size = pairList.size();
			if (i > 0 && i <= size) {
				pair = pairList.get(i - 1);
			} 
			return pair;
	}
	
	public static List<KeyValuePair> getKeysAndValues(String propFileName) {
		List<KeyValuePair> pairList = new ArrayList<KeyValuePair>();
		try {
			InputStream inputStream = CommonUtility.class.getClassLoader().getResourceAsStream(propFileName);
			if (inputStream == null) {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			Properties prop = new Properties();
			prop.load(inputStream);
			Enumeration<Object> enuKeys = prop.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = prop.getProperty(key);
				pairList.add(new KeyValuePair(key, Double.valueOf(value)));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pairList;
	}
		
}
