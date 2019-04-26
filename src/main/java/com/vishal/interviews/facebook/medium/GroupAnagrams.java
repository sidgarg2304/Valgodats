package com.vishal.interviews.facebook.medium;

import java.util.*;

/**
 * 49. Group Anagrams
 * 
 * Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
 *
 */
public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
