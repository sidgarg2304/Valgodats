package com.vishal.interviews.programcreek;

import java.util.*;

public class PalindromePairs {

	public static void main(String[] args) {

	}

	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new ArrayList<>();

		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < words.length; i++) {
			map.put(words[i], i);
		}

		for (int i = 0; i < words.length; i++) {
			if (isPalindrome(words[i])) {
				if (map.containsKey("") && map.get("") != i) {
					List<Integer> temp = new ArrayList<>();
					temp.add(i);
					temp.add(map.get(""));
					res.add(temp);
					
					temp = new ArrayList<>();
					temp.add(map.get(""));
					temp.add(i);					
					res.add(temp);
				}
			}

			String reverse = new StringBuilder(words[i]).reverse().toString();
			if (map.containsKey(reverse) && map.get(reverse) != i) {
				List<Integer> temp = new ArrayList<>();
				temp.add(i);
				temp.add(map.get(reverse));
				res.add(temp);
			}

			for (int j = 1; j < words[i].length(); j++) {
				String left = words[i].substring(0, j);
				String right = words[i].substring(j, words[i].length());
				String leftReverse = new StringBuilder(left).reverse().toString();
				String rightReverse = new StringBuilder(right).reverse().toString();

				if(isPalindrome(left) && map.containsKey(rightReverse)){
					//rightRverse + left + right
					List<Integer> temp = new ArrayList<>();
					
					temp.add(map.get(rightReverse));
					temp.add(i);					
					res.add(temp);
				}
				
				if(isPalindrome(right) && map.containsKey(leftReverse)){
					//left + right +  leftReverse
					List<Integer> temp = new ArrayList<>();										
					temp.add(i);
					temp.add(map.get(leftReverse));
					res.add(temp);
				}
			}
		}
		return res;
	}

	boolean isPalindrome(String s) {
		return true;
	}

}
