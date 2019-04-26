package com.vishal.interviews.uber.medium;

import java.util.*;

public class SortCharactersByFrequency {

	public static void main(String[] args) {
		SortCharactersByFrequency s = new SortCharactersByFrequency();
		s.frequencySort("tree");
	}

	public String frequencySort(String s) {

		if(s == null || s.length() == 0) {
			return s;
		}
		
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}		

		List<Character>[] countArray = new List[s.length() + 1];

		for (Map.Entry<Character, Integer> e : map.entrySet()) {
			if (countArray[e.getValue()] == null) {
				countArray[e.getValue()] = new ArrayList<>();
			}
			countArray[e.getValue()].add(e.getKey());
		}

		StringBuilder res = new StringBuilder();
		for (int count = countArray.length - 1; count >= 0; count--) {
			if (countArray[count] == null) {
				continue;
			}
			for (char c : countArray[count]) {
				for (int i = 0; i < count; i++) {
					res.append(c);
				}
			}
		}
		return res.toString();
	}

}
