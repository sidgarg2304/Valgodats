package com.vishal.interviews.top100linkedquestions.medium;

import java.util.*;

public class LetterCombinationsofaPhoneNumber {

	public static void main(String[] args) {

	}

	public List<String> letterCombinations(String digits) {

		String[] map = new String[] { "", "", "abc", "def", "ghi" };
		List<String> res = new ArrayList<>();

		Queue<String> queue = new LinkedList<>();
		queue.offer("");
		for (int i = 0; i < digits.length(); i++) {
			String m = map[digits.charAt(i) - '0'];
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				String p = queue.poll();
				for (char c : m.toCharArray()) {
					queue.offer(p + c);
				}
			}
		}

		res.addAll(queue);
		
		return res;
	}

}
