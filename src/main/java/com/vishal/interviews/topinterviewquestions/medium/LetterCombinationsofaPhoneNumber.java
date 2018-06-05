package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

public class LetterCombinationsofaPhoneNumber {

	public static void main(String[] args) {

	}

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();

		if (digits == null || digits.length() == 0) {
			return res;
		}

		String[] map = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		Queue<String> queue = new LinkedList<>();
		queue.offer("");

		for (int i = 0; i < digits.length(); i++) {

			int d = digits.charAt(i) - '0';
			String m = map[d];

			int size = queue.size();
			for (int j = 0; j < size; j++) {
				String prev = queue.poll();
				for (int k = 0; k < m.length(); k++) {
					queue.offer(prev + m.charAt(k));
				}
			}

		}

		res.addAll(queue);

		return res;
	}

}
