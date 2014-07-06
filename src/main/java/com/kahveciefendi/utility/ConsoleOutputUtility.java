package com.kahveciefendi.utility;

import java.util.List;

import com.kahveciefendi.base.IBeverage;
import com.kahveciefendi.base.KeyValuePair;

/**
 * Utility class for strings that are used by console
 * 
 * @author omer
 *
 */
public class ConsoleOutputUtility {

	/**
	 * Constants for branching options
	 */
	public static final String QUIT = "q";
	public static final String COMPLETE_ORDER = "f";
	public static final String CANCEL_LAST_BEVERAGE = "c";
	public static final String ADD_CONDIMENT_TO_BEVERAGE = "a";
	public static final String CANCEL_CURRENT_AND_GOTO_BEVERAGE_MENU = "m";
	public static final String COMPLETE_CURRENT_AND_GOTO_BEVERAGE_MENU = "u";
	public static final String ADD_CURRENT_BEVERAGE = "b";

	private ConsoleOutputUtility() {

	}

	public static void printWelcomeMessage() {
		System.out.println("\t\tKahveci Efendiye Hoş Geldiniz!\n");
	}

	public static void printChooseBeverageMessage() {
		System.out.println("Lütfen aşağıdaki menüden içecek tercihinizi belirtiniz:\n");
	}

	public static void printChooseCondimentMessage() {
		System.out.println("Lütfen ekstranızı seçiniz");
	}

	public static void printOrderCancelledMessage() {
		System.out.println("Siparişinizi iptal ettiniz.\n\nİyi günler!");
	}

	public static void printOrderCompletedMessage() {
		System.out.println("Siparişinizi tamamladınız.");
	}

	public static void printCurrentBeverageCancelledMessage() {
		System.out
				.println("Şu an hazırlamakta olduğunuz siparişinizi iptal ettiniz! Siparişiniz yeni içeçek ile devam edecektir.");
	}

	public static void printGotoBeverageMenu() {
		System.out.println("İçeçek menüsüne dönüyorsunuz");
	}

	public static void printInvalidInputMessage() {
		System.out.println("Lütfen geçerli bir giriş yapınız!");
	}

	public static void printNewBeverageMessage() {
		System.out.println("Yeni içeçek eklemek istediniz.");
	}

	public static void printCancelLastBeverageMessage(IBeverage beverage) {
		System.out.println("Son siparişiniz olan " + beverage.getDescription() + " iptal edildi!");
	}
	
	public static void printCancelCurrentBeverageMessage() {
		System.out.println("Hazırlamakta olduğunuz içeçeğinizi iptal ettiniz!");
	}
	
	public static void printConfirmCurrentBeverageMessage() {
		System.out.println("Hazırlamakta olduğunuz içeçeğiniz sepetinize eklendi!");
	}

	public static void printMainOptions() {
		System.out.println(ConsoleOutputUtility.COMPLETE_ORDER + "-Siparişinizi tamamlayın");
		System.out.println(ConsoleOutputUtility.QUIT + "-Sipariş sisteminden çıkın");
		System.out.println();
	}

	public static void printOptionWhileHavingBeverage() {
		System.out.println(ConsoleOutputUtility.ADD_CONDIMENT_TO_BEVERAGE + "-İçeceğinize ekstra ekleyin");
		System.out.println(ConsoleOutputUtility.ADD_CURRENT_BEVERAGE + "-İçeceğinizi sepete ekleyin");
		System.out.println(ConsoleOutputUtility.CANCEL_LAST_BEVERAGE + "-Son siparişinizi iptal edin");
		printMainOptions();
	}

	public static void printOptionsForCondiment() {
		System.out.println("Lütfen ekstranızı seçiniz");
		System.out.println(ConsoleOutputUtility.COMPLETE_CURRENT_AND_GOTO_BEVERAGE_MENU + "-Onaylayıp ana menüye dönün\t ");
		System.out.println(ConsoleOutputUtility.CANCEL_CURRENT_AND_GOTO_BEVERAGE_MENU + "-İptal edip ana menüye dönün");
		System.out.println(ConsoleOutputUtility.QUIT + "-Sipariş sisteminden çıkın");
	}

	public static void printNoConfirmedOrderMessage() {
		System.out.println("Onaylanmış siparişiniz bulunmamaktadır.");
	}

	public static void printCurrentOrders(List<IBeverage> orderList) {
		if (orderList.isEmpty()) {
			return;
		}
		System.out.print("Sepetinizde bulunan ürünler : ");
		for (IBeverage beverage : orderList) {
			System.out.print(beverage.getDescription() + " ");
		}
		System.out.println();
	}

	public static void printCurrentBeverage(IBeverage beverage) {
		System.out.println("Şu an hazırlamakta olduğunuz siparişiniz: " + beverage.getDescription());
	}

	public static void printTotalOrder(List<IBeverage> orderList) {
		if (orderList.isEmpty()) {
			System.out.println("Hiçbir içeçek siparişi vermediniz!\n\nİyi günler dileriz!");
			return;
		}
		System.out.println("Verdiğiniz siparişler:");
		int totalCost = 0;

		for (IBeverage beverage : orderList) {
			System.out.println(beverage.getDescription() + " = " + beverage.cost());
			totalCost += beverage.cost();
		}
		System.out.println("Ödemeniz gereken toplam tutar = " + totalCost + "TL");
		System.out.println("\nSiparişiniz için teşekkür ederiz!");
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
