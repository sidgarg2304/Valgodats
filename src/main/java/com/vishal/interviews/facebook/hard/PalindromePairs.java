package com.vishal.interviews.facebook.hard;

import java.util.*;
public class PalindromePairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new ArrayList<>();

		if (words == null || words.length == 0) {
			return res;
		}

		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			map.put(words[i], i);
		}

		for (int i = 0; i < words.length; i++) {
			String cur = words[i];

			if (isPalindrome(cur)) {
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

			String rev = new StringBuilder(cur).reverse().toString();
			if (map.containsKey(rev) && map.get(rev) != i) {
				List<Integer> temp = new ArrayList<>();
				temp.add(i);
				temp.add(map.get(rev));
				res.add(temp);
			}

			for (int j = 1; j < words[i].length(); j++) {
				String first = words[i].substring(0, j);
				String sec = words[i].substring(j, words[i].length());

				String firstRev = new StringBuilder(first).reverse().toString();
				String secRev = new StringBuilder(sec).reverse().toString();
				
				if(map.containsKey(firstRev) && isPalindrome(sec)) {
					List<Integer> temp = new ArrayList<>();
					temp.add(i);
					temp.add(map.get(firstRev));
					res.add(temp);
				}
				
				if(map.containsKey(secRev) && isPalindrome(first)) {
					List<Integer> temp = new ArrayList<>();
                    temp.add(map.get(secRev));
					temp.add(i);					
					res.add(temp);
				}
			}
		}

		return res;
	}

	boolean isPalindrome(String word) {
		int i = 0;
		int j = word.length() - 1;
		while (i <= j) {
			if (word.charAt(i) != word.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

}
