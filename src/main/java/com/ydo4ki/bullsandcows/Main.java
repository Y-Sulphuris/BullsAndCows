package com.ydo4ki.bullsandcows;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome! Enter amount of digits to guess: ");
		int digits;
		while(true) try {
			String line = scanner.nextLine();
			digits = Integer.parseInt(line);
			break;
		} catch (NumberFormatException e) {
			System.out.println("Invalid input :(");
			continue;
		}
		String number = generateNumber(digits);
		System.out.println(number);
		
		System.out.println(
				"Number guessed, now try to guess it.\n" +
				"The output will indicate how far are you from the number:\n" +
				"bull means that your guess contains a correct digit in a right place, cow means that your guess contains a correct digit in a wrong place"
		);
		while(true) {
			String input = scanner.nextLine();
			int bulls = 0, cows = 0;
			if (input.equals(number)) {
				System.out.println("4 bulls! You won!");
				System.exit(0);
			}
			for (int i = 0, Len = input.length(); i < Len; i++) {
				char ch = input.charAt(i);
				if (number.charAt(i) == ch) bulls++;
				else {
					if (number.indexOf(ch) > 0) cows++;
				}
			}
			System.out.println(bulls + " bulls, " + cows + " cows");
		}
	}
	
	private static String generateNumber(int digits) {
		char[] symbols = new char[digits];
		for (int i = 0; i < symbols.length; i++) {
			symbols[i] = (char)ThreadLocalRandom.current().nextInt('1','9'+1);
		}
		return String.valueOf(symbols);
	}
}