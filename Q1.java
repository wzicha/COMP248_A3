
// Assignment 3, Question 1
// Writen by: William Zicha 40127016
// For COMP 248 Section S - Fall 2021
// Java program to prompt the user for a leap or common year and display all the dates of the month are NOT the multiple of the month

import java.util.Scanner;

import java.util.*;

class Q1 {
	public static void main(String[] args) {
		// print header using print_message()
		print_message();

		// get year as input from user
		int year = get_user_input();

		// initialize months and days in an arrays
		String months[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		int days[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		System.out.println("\n");

		// loop that goes to 12
		for (int i = 0; i < months.length; i++) {
			// initialize header
			String header = "In " + months[i] + " the dates are not multiple of " + (i + 1) + " are:";

			// header for February
			if (i == 1) {
				days[i]++;
				if (is_leap(year)) {
					header = "In " + months[i] + " in a leap year, the dates are not multiple of " + (i + 1) + " are:";
				} else {
					header = "In " + months[i] + " in a common year, the dates are not multiple of " + (i + 1)
							+ " are:";
				}
			}

			// all non divisible days of month obtained "i" using get_days() method
			List<Integer> non_divisible_days = get_days(days[i], i + 1);

			// print the result for month "i"
			System.out.println(header);
			if (non_divisible_days.size() == 0) {
				System.out.println("No dates are found in this month!");
			} else {
				int index = 0;
				for (int j = 0; j < non_divisible_days.size(); j++) {
					System.out.print(non_divisible_days.get(j) + ", ");
					index++;
					if (index == 15) {
						System.out.println();
						index = 0;
					}
				}
				if (index != 0)
					System.out.println();
			}
			System.out.println();
		}
		System.out.println("Thank you for using this program!");

	}

	// print the header method
	public static void print_message() {
		System.out.println("\n-------****-------****-------****-------****-------");
		System.out.println("      Welcome to Calender Program!");
		System.out.println("-------****-------****-------****-------****-------\n");
	}

	// get year as user input until valid year is entered
	public static int get_user_input() {
		Scanner myScanner = new Scanner(System.in);
		int year = 0;
		while (true) {
			System.out.println("Please enter a 4-digit year:");
			year = myScanner.nextInt();
			myScanner.close();
			if (year >= 1000 && year <= 9999)
				break;
		}
		return year;
	}

	// year is leap or not
	public static boolean is_leap(int year) {
		if (year % 4 == 0 && year % 100 == 0 && year % 400 == 0)
			return true;
		if (year % 4 == 0 && year % 100 != 0)
			return true;
		return false;
	}

	// calculate all days that are not divisible by factor and return list
	public static List<Integer> get_days(int days, int factor) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= days; i++) {
			if (i % factor != 0) {
				list.add(i);
			}
		}
		return list;
	}
}