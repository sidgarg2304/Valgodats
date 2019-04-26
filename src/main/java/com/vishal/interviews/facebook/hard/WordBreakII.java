package com.vishal.interviews.facebook.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> wordBreak(String s, List<String> wordDict) {
		return dfs(s, wordDict, new HashMap<>());		
	}

	List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> map) {

		if (map.containsKey(s)) {
			return map.get(s);
		}

		List<String> res = new ArrayList<>();
		if (s.isEmpty()) {
			res.add("");
			map.put("", res);
			return res;
		}

		int st = 0;
		for (int i = 0; i < s.length(); i++) {
			String sub = s.substring(st, i + 1);
			if (wordDict.contains(sub)) {
				List<String> subPartRes = dfs(s.substring(i + 1), wordDict, map);
				for (String subRes : subPartRes) {
					res.add(sub + (subRes.isEmpty() ? "" : " ") + subRes);
				}
			}
		}
		map.put(s, res);

		return res;
	}

}
