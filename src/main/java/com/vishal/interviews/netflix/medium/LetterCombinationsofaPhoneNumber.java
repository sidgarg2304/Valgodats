package com.vishal.interviews.netflix.medium;

import java.util.*;

public class LetterCombinationsofaPhoneNumber {

	public static void main(String[] args) {

	}

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();

		String[] map = new String[] { "", "", "abc", "def", "ghi" };

		Queue<String> queue = new LinkedList<>();
		queue.offer("");

		for (int i = 0; i < digits.length(); i++) {
			int p = digits.charAt(i) - '0';
			String val = map[p];
		}
		return res;
	}

}
