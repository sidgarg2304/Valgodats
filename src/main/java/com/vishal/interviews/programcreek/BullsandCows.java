package com.vishal.interviews.programcreek;

import java.util.*;

/**
 * You are playing the following Bulls and Cows game with your friend: You write
 * down a number and ask your friend to guess what the number is. Each time your
 * friend makes a guess, you provide a hint that indicates how many digits in
 * said guess match your secret number exactly in both digit and position
 * (called "bulls") and how many digits match the secret number but locate in
 * the wrong position (called "cows"). Your friend will use successive guesses
 * and hints to eventually derive the secret number.
 * 
 * For example: Secret number: "1807" Friend's guess: "7810"
 * 
 * Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.) Write a
 * function to return a hint according to the secret number and friend's guess,
 * use A to indicate the bulls and B to indicate the cows. In the above example,
 * your function should return "1A3B".
 */
public class BullsandCows {

	public static void main(String[] args) {

		System.out.println(getHint("1807", "7810"));
	}

	public static String getHint(String secret, String guess) {

		if (secret == null || guess == null || secret.length() != guess.length()) {
			return "";
		}

		int bulls = 0;

		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < secret.length(); i++) {
			char s = secret.charAt(i);
			char g = guess.charAt(i);

			if (s == g) {
				bulls++;
			} else {
				map.put(s, map.getOrDefault(s, 0) + 1);
			}
		}

		int cows = 0;
		for (int i = 0; i < guess.length(); i++) {
			char s = secret.charAt(i);
			char g = guess.charAt(i);
			if (s == g) {
				continue;
			}
			if (map.containsKey(guess.charAt(i))) {
				cows++;
				map.put(g, map.get(g) - 1);
				if (map.get(g) == 0) {
					map.remove(g);
				}
			}
		}

		return bulls + "A" + cows + "B";
	}

}
