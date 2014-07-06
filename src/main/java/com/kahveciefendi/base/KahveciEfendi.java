package com.kahveciefendi.base;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.kahveciefendi.utility.CommonUtility;
import com.kahveciefendi.utility.ConsoleOutputUtility;

public class KahveciEfendi {

	public static final String BEVERAGE_PROPERTY = "beverages.properties";
	public static final String CONDIMENT_PROPERTY = "condiments.properties";
	private static final Logger logger = Logger.getLogger(KahveciEfendi.class);

	public void takeOrder() {
		ConsoleOutputUtility.printWelcomeMessage();
		List<IBeverage> orderList = new ArrayList<IBeverage>();
		List<KeyValuePair> beverageList = CommonUtility.getKeysAndValues(KahveciEfendi.BEVERAGE_PROPERTY);
		boolean isBeveragePartFinished = false;
		IBeverage beverage = null;
		while (!isBeveragePartFinished) {
			ConsoleOutputUtility.printIntroductionMessage(beverageList, orderList, beverage);
			String input = CommonUtility.getUserInput();
			boolean isNumeric = CommonUtility.isNumeric(input);
			logger.debug("Given bevearage input : " + input + " Is numeric : " + isNumeric);
			if (isNumeric) {
				beverage = this.prepareBeverage(beverageList, input);
				continue;
			}
			logger.info("Given branching option is " + input.toLowerCase());
			switch (input.toLowerCase().charAt(0)) {
			case ConsoleOutputUtility.QUIT:
				logger.info("Customer cancelled the program");
				ConsoleOutputUtility.printOrderCancelledMessage();
				System.exit(0);
			case ConsoleOutputUtility.COMPLETE_ORDER:
				logger.debug("Customer completed his order");
				ConsoleOutputUtility.printOrderCompletedMessage();
				isBeveragePartFinished = true;
				break;
			case ConsoleOutputUtility.ADD_CURRENT_BEVERAGE:
				logger.debug("Customer wanted to add current beverage " + beverage.getDescription()
						+ " without condiment");
				orderList.add(beverage);
				beverage = null;
				continue;
			case ConsoleOutputUtility.ADD_CONDIMENT_TO_BEVERAGE:
				logger.debug("Customer wanted to add condiment to his current beverage : " + beverage.getDescription());
				beverage = this.addCondiment(beverage);
				// Current may be cancelled so check if cancelled or not before
				// adding to order
				if (beverage != null) {
					orderList.add(beverage);
				}
				logger.debug("Current confirmed beverage size is " + orderList.size());
				beverage = null;
				continue;
			case ConsoleOutputUtility.CANCEL_LAST_BEVERAGE:
				if (orderList.isEmpty()) {
					logger.debug("Nothing to cancel!");
					ConsoleOutputUtility.printNoConfirmedOrderMessage();
				} else {
					IBeverage cancalledBeverage = orderList.remove(orderList.size() - 1);
					logger.info("Customer wanted to cancel last confirmed beverage : "
							+ cancalledBeverage.getDescription());
					ConsoleOutputUtility.printCancelLastBeverageMessage(cancalledBeverage);
					beverage = null;
				}
				continue;
			default:
				logger.info("Given branching option is not valid!" + input.toLowerCase());
				ConsoleOutputUtility.printInvalidInputMessage();
			}
		}
		ConsoleOutputUtility.printTotalOrder(orderList);
	}

	public IBeverage prepareBeverage(List<KeyValuePair> beverageList, String input) {
		IBeverage beverage = null;
		KeyValuePair beverageKeyValuePair = CommonUtility.getPairFromGivenList(beverageList, input);
		if (beverageKeyValuePair == null) {
			logger.info("Given number is out of range!");
			ConsoleOutputUtility.printInvalidInputMessage();
			return null;
		}
		beverage = new Beverage(beverageKeyValuePair.getKey(), beverageKeyValuePair.getValue());
		logger.debug("Beverage is created " + beverage);
		return beverage;
	}

	public IBeverage addCondiment(IBeverage beverage) {
		List<KeyValuePair> condimentList = CommonUtility.getKeysAndValues(KahveciEfendi.CONDIMENT_PROPERTY);
		boolean isCondimentPartFinished = false;
		while (!isCondimentPartFinished) {
			ConsoleOutputUtility.printOptionsForCondiment();
			CommonUtility.printList(condimentList);
			String inputForCondiment = CommonUtility.getUserInput();
			boolean isNumericCondiment = CommonUtility.isNumeric(inputForCondiment);
			logger.debug("Given condiment input : " + inputForCondiment + " Is numeric : " + isNumericCondiment);
			if (isNumericCondiment) {
				beverage = this.prepareCondiment(condimentList, beverage, inputForCondiment);
				continue;
			}
			switch (inputForCondiment.toLowerCase().charAt(0)) {
			case ConsoleOutputUtility.QUIT:
				logger.info("Customer cancelled the program");
				ConsoleOutputUtility.printOrderCancelledMessage();
				System.exit(0);
			case ConsoleOutputUtility.COMPLETE_CURRENT_AND_GOTO_BEVERAGE_MENU:
				logger.debug("Customer confirmed current beverage " + beverage + " Returning main menu");
				ConsoleOutputUtility.printConfirmCurrentBeverageMessage();
				ConsoleOutputUtility.printGotoBeverageMenu();
				isCondimentPartFinished = true;
				break;
			case ConsoleOutputUtility.CANCEL_CURRENT_AND_GOTO_BEVERAGE_MENU:
				logger.debug("Customer cancelled current beverage " + beverage + " Returning main menu");
				ConsoleOutputUtility.printCancelCurrentBeverageMessage();
				ConsoleOutputUtility.printGotoBeverageMenu();
				isCondimentPartFinished = true;
				beverage = null;
				break;
			default:
				logger.info("Given branching option is not valid!" + inputForCondiment.toLowerCase());
				ConsoleOutputUtility.printInvalidInputMessage();
			}
		}
		return beverage;
	}

	public IBeverage prepareCondiment(List<KeyValuePair> condimentList, IBeverage beverage , String input) {
		KeyValuePair condimentKeyValuePair = CommonUtility.getPairFromGivenList(condimentList, input);
		if (condimentKeyValuePair == null) {
			logger.info("Given number is out of range!");
			ConsoleOutputUtility.printInvalidInputMessage();
			return null;
		}
		IBeverage condiment = new Condiment(beverage, condimentKeyValuePair.getKey(), condimentKeyValuePair.getValue());
		logger.debug("Condiment is created " + beverage);
		return condiment;
	}

}
