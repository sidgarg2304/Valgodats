package com.vishal.interviews.uber.hard;

import java.util.*;

public class PalindromePairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new ArrayList<>();

		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			map.put(words[i], i);
		}

		for (int i = 0; i < words.length; i++) {
			String cur = words[i];

			if (isPalindromw(cur)) {
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

			for (int j = 1; j < cur.length(); j++) {
				String first = cur.substring(0, j);				
				String firstRev = new StringBuilder(first).reverse().toString();
				String sec = cur.substring(j);
				String secRev = new StringBuilder(sec).reverse().toString();
				
				if(map.containsKey(firstRev) && isPalindromw(sec)) {
					List<Integer> temp = new ArrayList<>();
					temp.add(i);
					temp.add(map.get(firstRev));
					res.add(temp);
				}
				
				if(map.containsKey(secRev) && isPalindromw(first)) {
					List<Integer> temp = new ArrayList<>();
					temp.add(map.get(secRev));
					temp.add(i);					
					res.add(temp);
				}
			}
		}
		return res;
	}

	boolean isPalindromw(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
