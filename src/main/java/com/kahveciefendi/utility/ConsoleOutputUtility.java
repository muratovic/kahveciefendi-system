package com.kahveciefendi.utility;

import java.util.List;

import org.apache.log4j.Logger;

import com.kahveciefendi.base.IBeverage;
import com.kahveciefendi.base.KahveciEfendi;
import com.kahveciefendi.base.KeyValuePair;

/**
 * Utility class for strings that are used by console
 * 
 * @author omer
 *
 */
public class ConsoleOutputUtility {

	private static final Logger logger = Logger.getLogger(ConsoleOutputUtility.class);
	
	/**
	 * Constants for branching options
	 */
	public static final char QUIT = 'q';
	public static final char COMPLETE_ORDER = 'f';
	public static final char CANCEL_LAST_BEVERAGE = 'c';
	public static final char ADD_CONDIMENT_TO_BEVERAGE = 'a';
	public static final char CANCEL_CURRENT_AND_GOTO_BEVERAGE_MENU = 'm';
	public static final char COMPLETE_CURRENT_AND_GOTO_BEVERAGE_MENU = 'u';
	public static final char ADD_CURRENT_BEVERAGE = 'b';

	private ConsoleOutputUtility() {

	}

	public static void printWelcomeMessage() {
		System.out.println("\t\tKahveci Efendiye Hos Geldiniz!\n");
	}

	public static void printChooseBeverageMessage() {
		System.out.println("Lutfen asagidaki menuden icecek tercihinizi belirtiniz:\n");
	}

	public static void printChooseCondimentMessage() {
		System.out.println("Lutfen ekstranizi seciniz");
	}

	public static void printOrderCancelledMessage() {
		System.out.println("Siparisinizi iptal ettiniz.\n\nIyi gunler!");
	}

	public static void printOrderCompletedMessage() {
		System.out.println("Siparisinizi tamamladiniz.");
	}

	public static void printCurrentBeverageCancelledMessage() {
		System.out
				.println("Su an hazirlamakta oldugunuz siparisinizi iptal ettiniz! Siparisiniz yeni icecek ile devam edecektir.");
	}

	public static void printGotoBeverageMenu() {
		System.out.println("Icecek menusune donuyorsunuz");
	}

	public static void printInvalidInputMessage() {
		System.out.println("Lutfen gecerli bir giris yapiniz!");
	}

	public static void printNewBeverageMessage() {
		System.out.println("Yeni icecek eklemek istediniz.");
	}

	public static void printCancelLastBeverageMessage(IBeverage beverage) {
		System.out.println("Son siparisiniz olan " + beverage.getDescription() + " iptal edildi!");
	}
	
	public static void printCancelCurrentBeverageMessage() {
		System.out.println("Hazirlamakta oldugunuz iceceginizi iptal ettiniz!");
	}
	
	public static void printConfirmCurrentBeverageMessage() {
		System.out.println("Hazirlamakta oldugunuz iceceginiz sepetinize eklendi!");
	}

	public static void printMainOptions() {
		System.out.println(ConsoleOutputUtility.COMPLETE_ORDER + "-Siparisinizi tamamlayin");
		System.out.println(ConsoleOutputUtility.QUIT + "-Siparis sisteminden cikin");
		System.out.println();
	}

	public static void printOptionWhileHavingBeverage() {
		System.out.println(ConsoleOutputUtility.ADD_CONDIMENT_TO_BEVERAGE + "-Iceceginize ekstra ekleyin");
		System.out.println(ConsoleOutputUtility.ADD_CURRENT_BEVERAGE + "-Iceceginizi sepete ekleyin");
		System.out.println(ConsoleOutputUtility.CANCEL_LAST_BEVERAGE + "-Son siparisinizi iptal edin");
		printMainOptions();
	}

	public static void printOptionsForCondiment() {
		System.out.println("Lutfen ekstranizi seciniz");
		System.out.println(ConsoleOutputUtility.COMPLETE_CURRENT_AND_GOTO_BEVERAGE_MENU + "-Onaylayip ana menuye donun\t ");
		System.out.println(ConsoleOutputUtility.CANCEL_CURRENT_AND_GOTO_BEVERAGE_MENU + "-Iptal edip ana menuye donun");
		System.out.println(ConsoleOutputUtility.QUIT + "-Siparis sisteminden cikin\n");
	}

	public static void printNoConfirmedOrderMessage() {
		System.out.println("Onaylanmis siparisiniz bulunmamaktadir.");
	}

	public static void printCurrentOrders(List<IBeverage> orderList) {
		if (orderList.isEmpty()) {
			return;
		}
		System.out.print("Sepetinizde bulunan urunler : ");
		for (IBeverage beverage : orderList) {
			System.out.print(beverage.getDescription() + " ");
		}
		System.out.println();
	}

	public static void printCurrentBeverage(IBeverage beverage) {
		System.out.println("Su an hazirlamakta oldugunuz siparisiniz: " + beverage.getDescription());
	}

	public static void printTotalOrder(List<IBeverage> orderList) {
		if (orderList.isEmpty()) {
			System.out.println("Hicbir icecek siparisi vermediniz!\n\nIyi gunler dileriz!");
			logger.debug("No order to calculate");
			return;
		}
		StringBuilder builder = new StringBuilder();
		builder.append("Given order is : ");
		System.out.println("Verdiginiz siparisler:");
		int totalCost = 0;

		for (IBeverage beverage : orderList) {
			builder.append("\n").append(beverage.getDescription()).append(" = ").append(beverage.cost());
			System.out.println(beverage.getDescription() + " = " + beverage.cost());
			totalCost += beverage.cost();
		}
		builder.append("\nTotal cost is = ").append(totalCost);
		logger.info(builder.toString());
		System.out.println("Odemeniz gereken toplam tutar = " + totalCost + "TL");
		System.out.println("\nSiparisiniz icin tesekkur ederiz!");
	}
	
	public static void printIntroductionMessage(List<KeyValuePair> beverageList, List<IBeverage> orderList, IBeverage beverage) {
		if (beverage == null) {
			ConsoleOutputUtility.printChooseBeverageMessage();
			ConsoleOutputUtility.printMainOptions();
			CommonUtility.printList(beverageList);
		} else {
			ConsoleOutputUtility.printCurrentOrders(orderList);
			ConsoleOutputUtility.printCurrentBeverage(beverage);
			ConsoleOutputUtility.printOptionWhileHavingBeverage();
		}

	}

}
