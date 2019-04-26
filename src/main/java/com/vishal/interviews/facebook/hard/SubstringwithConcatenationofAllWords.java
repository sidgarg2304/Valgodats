package com.vishal.interviews.facebook.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<>();
		
		if (s == null || s.length() == 0 || words == null || words.length == 0) {
			return res;
		}

		Map<String, Integer> inputMap = new HashMap<>();
		for (String w : words) {
			inputMap.put(w, inputMap.getOrDefault(w, 0) + 1);
		}

		int len = words[0].length();
		for (int l = 0; l < len; l++) {
			Map<String, Integer> map = new HashMap<>();
			int count = 0;
			int st = l;
			for (int i = l; i <= s.length() - len; i += len) {
				String sub = s.substring(i, i + len);
				if (inputMap.containsKey(sub)) {
					map.put(sub, map.getOrDefault(sub, 0) + 1);
					count++;

					while (map.get(sub) > inputMap.get(sub)) {
						String prev = s.substring(st, st + len);
						map.put(prev, map.get(prev) - 1);
						count--;
						st += len;
					}

					if (count == words.length) {
						res.add(st);						
						String prev = s.substring(st, st + len);
						map.put(prev, map.get(prev) - 1);
						count--;
						st += len;
					}
				} else {
					count = 0;
					st = i + len;
					map.clear();
				}
			}
		}
		return res;

	}

}
