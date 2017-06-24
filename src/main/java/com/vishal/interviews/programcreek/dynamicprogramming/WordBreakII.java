package com.vishal.interviews.programcreek.dynamicprogramming;

import java.util.*;

public class WordBreakII {

	public static void main(String[] args) {

		String s = "abc";
		System.out.println("sub is " + s.substring(3));
	}

	public List<String> wordBreak(String s, List<String> wordDict) {

		return dfs(s, wordDict, new HashMap<>());
	}

	List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> map) {
		if (map.containsKey(s)) {
			return map.get(s);
		}

		List<String> res = new ArrayList<>();

		if (s.length() == 0) {
			res.add("");
			map.put(s, res);
			return res;
		}

		for (int i = 0; i < s.length(); i++) {
			String sub = s.substring(0, i + 1);
			if (wordDict.contains(sub)) {
				List<String> subResults = dfs(s.substring(i + 1), wordDict, map);
				for (String r : subResults) {
					res.add(sub + (r.isEmpty() ? "" : " ") + r);
				}
			}
		}

		map.put(s, res);

		return res;
	}

}
