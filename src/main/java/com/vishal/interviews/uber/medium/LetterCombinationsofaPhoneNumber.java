package com.vishal.interviews.uber.medium;

import java.util.*;

public class LetterCombinationsofaPhoneNumber {

	public static void main(String[] args) {

	}

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if(digits == null || digits.length() == 0) {
			return res;
		}
		String[] mapping = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		Queue<String> queue = new LinkedList<>();
		queue.offer("");

		for (int i = 0; i < digits.length(); i++) {
			int d = digits.charAt(i) - '0';
			String map = mapping[d];
			while (!queue.isEmpty() && queue.peek().length() == i) {
				String prev = queue.poll();

				for (int j = 0; j < map.length(); j++) {
					queue.offer(prev + map.charAt(j));
				}
			}
		}
		res.addAll(queue);
		return res;
	}

}
