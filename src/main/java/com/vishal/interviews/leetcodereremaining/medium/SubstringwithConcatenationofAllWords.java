package com.vishal.interviews.leetcodereremaining.medium;

import java.util.*;

/**
 * 30. Substring with Concatenation of All Words
 * 
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
 *
 */
public class SubstringwithConcatenationofAllWords {

	public static void main(String[] args) {

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

		for (int j = 0; j < len; j++) {
			Map<String, Integer> map = new HashMap<>();
			int st = j;
			int count = 0;
			for (int i = j; i <= s.length() - len; i += len) {
				String sub = s.substring(i, i + len);
				if (inputMap.containsKey(sub)) {
					map.put(sub, map.getOrDefault(sub, 0) + 1);
					count++;

					while (map.get(sub) > inputMap.get(sub)) {
						String temp = s.substring(st, st + len);
						map.put(temp, map.get(temp) - 1);
						count--;
						st += len;
					}

					if (count == words.length) {
						res.add(st);

						String temp = s.substring(st, st + len);
						map.put(temp, map.get(temp) - 1);
						count--;
						st += len;
					}
				} else {
					map.clear();
					st = i + len;
					count = 0;
				}

			}
		}
		return res;
	}

}
