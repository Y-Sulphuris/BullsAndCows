package com.ydo4ki.bullsandcows;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome! Enter amount of digits to guess: ");
		int digits;
		while(true) try {
			String line = scanner.nextLine();
			digits = Integer.parseInt(line);
			if (digits < 1 || digits > 9) {
				System.out.println("Amount must be between 1 and 9");
				continue;
			}
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
		while (true) {
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
		List<Character> possibleDigits = new ArrayList<>();
		Collections.addAll(possibleDigits, '1', '2', '3', '4', '5', '6', '7', '8', '9');
		
		char[] symbols = new char[digits];
		for (int i = 0; i < symbols.length; i++) {
			symbols[i] = possibleDigits.remove(ThreadLocalRandom.current().nextInt(0, possibleDigits.size()));
		}
		return String.valueOf(symbols);
	}
}