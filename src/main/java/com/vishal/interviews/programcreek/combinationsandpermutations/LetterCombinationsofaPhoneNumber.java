package com.vishal.interviews.programcreek.combinationsandpermutations;

import java.util.*;

public class LetterCombinationsofaPhoneNumber {

	public static void main(String[] args) {

	}

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();

		String[] mapping = new String[] { "", "", "abc", "def" };

		Queue<String> queue = new LinkedList<>();
		queue.offer("");

		for (int i = 0; i < digits.length(); i++) {
			String cur = mapping[digits.charAt(i) - '0'];
			int size = queue.size();
			for (int j = 0; j < size; j++) {
				String prev = queue.poll();
				for (char p : cur.toCharArray()) {
					queue.offer(prev + p);
				}
			}
		}
		
		res.addAll(queue);
		
		return res;
	}

}
