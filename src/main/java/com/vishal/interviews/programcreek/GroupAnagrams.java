package com.vishal.interviews.programcreek;

import java.util.*;

public class GroupAnagrams {

	public static void main(String[] args) {

	}

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();

		Map<String, List<String>> map = new HashMap<>();

		for (int i = 0; i < strs.length; i++) {
			char[] arr = strs[i].toCharArray();
			Arrays.sort(arr);
			String sorted = String.valueOf(arr);

			if (!map.containsKey(sorted)) {
				map.put(sorted, new ArrayList<>());
			}
			map.get(sorted).add(strs[i]);
		}

		result.addAll(map.values());
		return result;
	}

}
