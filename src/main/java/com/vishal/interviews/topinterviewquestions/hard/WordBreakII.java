package com.vishal.interviews.topinterviewquestions.hard;

import java.util.*;

public class WordBreakII {

	public static void main(String[] args) {

	}

	public List<String> wordBreak(String s, List<String> wordDict) {

		return dfs(s, wordDict, new HashMap<>());
	}

	List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> map) {
		if (map.containsKey(s)) {
			return map.get(s);
		}
		List<String> res = new ArrayList<>();

		if (s == null || s.length() == 0) {
			res.add("");
			return res;
		}

		for (int i = 0; i < s.length(); i++) {
			String sub = s.substring(0, i + 1);
			if (wordDict.contains(sub)) {
				List<String> nextRes = dfs(s.substring(i + 1), wordDict, map);
				for (String n : nextRes) {
					res.add(sub + (n.isEmpty() ? "" : " ") + n);
				}
			}
		}
		map.put(s, res);
		return res;

	}

}
