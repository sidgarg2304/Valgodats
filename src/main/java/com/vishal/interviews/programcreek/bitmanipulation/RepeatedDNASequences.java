package com.vishal.interviews.programcreek.bitmanipulation;

import java.util.*;

public class RepeatedDNASequences {

	public static void main(String[] args) {

		System.out.println(findRepeatedDnaSequencesSimple("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
	}

	// For example, given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", return:
	// ["AAAAACCCCC", "CCCCCAAAAA"].

	public static List<String> findRepeatedDnaSequences(String s) {
		List<String> res = new ArrayList<>();

		if (s == null || s.length() <= 10) {
			return res;
		}

		Map<Character, Integer> map = new HashMap<>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);

		Map<Integer, Integer> hashMap = new HashMap<>();
		int hash = 0;
		for (int i = 0; i < s.length(); i++) {
			hash <<= 2;
			hash += map.get(s.charAt(i));
			if (i >= 9) {
				hash &= (1 << 20) - 1;
				hashMap.put(hash, map.getOrDefault(hash, 0) + 1);
				if (hashMap.get(hash) == 2) {
					res.add(s.substring(i-9, i+1));
				}
			}
		}

		return res;

	}

	public static List<String> findRepeatedDnaSequencesSimple(String s) {
		List<String> res = new ArrayList<>();

		if (s == null || s.length() <= 10) {
			return res;
		}

		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i <= s.length() - 10; i++) {

			String sub = s.substring(i, i + 10);
			map.put(sub, map.getOrDefault(sub, 0) + 1);
			if (map.get(sub) == 2) {
				res.add(sub);
			}
		}

		return res;
	}

}
