package com.vishal.algorithms.combinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationsPhoneNumbersAlgorithms {

	public static Map<Integer, char[]> phoneKeyMap = new HashMap<Integer, char[]>();

	public static void main(String[] args) {
		phoneKeyMap.put(0, new char[] {});
		phoneKeyMap.put(2, new char[] { 'a', 'b', 'c' });
		phoneKeyMap.put(3, new char[] { 'd', 'e', 'f' });
		phoneKeyMap.put(4, new char[] { 'g', 'h', 'i' });
		phoneKeyMap.put(5, new char[] { 'j', 'k', 'l' });
		phoneKeyMap.put(6, new char[] { 'm', 'n', 'o' });
		phoneKeyMap.put(7, new char[] { 'p', 'q', 'r', 's' });
		phoneKeyMap.put(8, new char[] { 't', 'u', 'v' });
		phoneKeyMap.put(9, new char[] { 'w', 'x', 'y', 'z' });

		testCombinationWordsForSelectedNumbers();
	}

	public static void testCombinationWordsForSelectedNumbers() {

		combinationWordsForSelectedNumbers("23");

	}

	public static void combinationWordsForSelectedNumbers(String selectedNumbers) {
		List<List<Character>> result = new ArrayList<>();
		combinationWordsForSelectedNumbers(selectedNumbers, 0, new ArrayList<Character>(), result);

		System.out.println("combinations are " + result);

	}

	public static void combinationWordsForSelectedNumbers(String selectedNumbers, int start, List<Character> temp,
			List<List<Character>> result) {

		if (start == selectedNumbers.length()) {
			List<Character> curResult = new ArrayList<>();
			curResult.addAll(temp);
			result.add(curResult);
			return;
		}

		for (int i = start; i < selectedNumbers.length(); i++) {
			char[] possibleChars = phoneKeyMap.get(Integer.valueOf("" + selectedNumbers.charAt(i)));
			for (int j = 0; j < possibleChars.length; j++) {
				temp.add(possibleChars[j]);
				combinationWordsForSelectedNumbers(selectedNumbers, i + 1, temp, result);
				temp.remove(temp.size() - 1);
			}
		}

	}

}
