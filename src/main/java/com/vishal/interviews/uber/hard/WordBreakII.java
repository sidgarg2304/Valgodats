package com.vishal.interviews.uber.hard;

import java.util.*;

public class WordBreakII {

	public static void main(String[] args) {

	}

	public List<String> wordBreak(String s, List<String> wordDict) {
		Map<String, List<String>> map = new HashMap<>();
		return dfs(s, wordDict, map);
	}

	List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> map) {
		if (map.containsKey(s)) {
			return map.get(s);
		}

		List<String> res = new ArrayList<>();
		if (s.isEmpty()) {
			res.add("");
			return res;
		}

		for (int i = 1; i < s.length(); i++) {
			String sub = s.substring(0, i);
			if (wordDict.contains(sub)) {
				List<String> rightSideRes = dfs(s.substring(i), wordDict, map);
				for(String r: rightSideRes) {
					res.add(sub + (r.isEmpty() ? "" : " ") + r);
				}
			}
		}

		map.put(s, res);

		return res;
	}

}
