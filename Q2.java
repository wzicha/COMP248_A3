
// Assignment 3, Question 2
// Writen by: William Zicha 40127016
// For COMP 248 Section S - Fall 2021
// Java program to prompt the user for a sequence of items with its price in the format of “Item1$Price1,Item2$Price2,Item3$Price3,” as one string.
// program should separate the string into the item name and price individually and save the item names and prices in two different arrays (2D-character array and integer array) 
// and display the list of items, total price accordingly. 
import java.util.Scanner;

class Q2 {

	public static void main(String args[]) {
		// Define Scanner
		Scanner myScanner = new Scanner(System.in);

		// Declare variables
		String itemsPrice;
		int totalPrice = 0;

		// Take user input
		System.out.println("------****------****------****------****------");
		System.out.println("Welcome to Shopping List Program!");
		System.out.println("------****------****------****------****------");

		System.out.println("\nPlease enter your shopping list (item$price and separate by comma):");
		itemsPrice = myScanner.nextLine();

		// User input on delimiter ','stores each item and price
		String[] splittedItems = itemsPrice.split("[,]", 0);

		// Number of items in the list
		int itemsCount = splittedItems.length;

		// If user entered valid items and price
		if (!itemsPrice.equals("0")) {
			// Arrays to store item names and prices
			String[] itemNames = new String[itemsCount];
			int[] prices = new int[itemsCount];

			// splittedItems to names and prices
			for (int i = 0; i < itemNames.length; i++) {
				String[] temp = splittedItems[i].split("[$]", 0);
				itemNames[i] = temp[0];
				prices[i] = Integer.parseInt(temp[1]);
			}

			// Print item names
			System.out.println("\nHere is the list of items:\n");
			for (int i = 0; i < itemsCount; i++) {
				System.out.println("No." + (i + 1) + " " + itemNames[i]);
				totalPrice += prices[i];
			}

			// Print price
			System.out.println("The total price is: $." + totalPrice);
		} else {
			System.out.println("\nYou have 0 items in the list now!");
		}

		// Print thanks message
		System.out.println("\nThank you for using this program!");

		myScanner.close();
	}
}