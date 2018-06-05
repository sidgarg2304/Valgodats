package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

public class GroupAnagrams {

	public static void main(String[] args) {

	}

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();

		if (strs == null || strs.length == 0) {
			return res;
		}

		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			char[] arr = s.toCharArray();
			Arrays.sort(arr);
			if (!map.containsKey(String.valueOf(arr))) {
				map.put(String.valueOf(arr), new ArrayList<>());
			}
			map.get(String.valueOf(arr)).add(s);
		}

		res.addAll(map.values());
		return res;
	}

}
