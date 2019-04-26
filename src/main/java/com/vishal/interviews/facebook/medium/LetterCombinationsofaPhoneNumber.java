package com.vishal.interviews.facebook.medium;

import java.util.*;

/**
 * 17. Letter Combinations of a Phone Number
 * 
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 */
public class LetterCombinationsofaPhoneNumber {

	public static void main(String[] args) {

	}
	
	 public List<String> letterCombinations(String digits) {
       if (digits == null || digits.length() == 0) {
			return new ArrayList<>();
		}

		String[] mappings = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tvu", "wxyz" };

		Queue<String> queue = new LinkedList<>();
		queue.offer("");
		for (int i = 0; i < digits.length(); i++) {
			String mapping = mappings[digits.charAt(i) - '0'];
           int size = queue.size();
			for (int j = 0; j < size; j++) {
				String prev = queue.poll();
				for (char p : mapping.toCharArray()) {
					queue.offer(prev + p);
				}
			}
		}

		List<String> res = new ArrayList<>(queue);		
		
		return res;
   }

}
