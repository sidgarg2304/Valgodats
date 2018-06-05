package com.vishal.interviews.topinterviewquestions.hard;

import java.util.*;

/**
 * Example 1:
Given the following words in dictionary,

[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
The correct order is: "wertf".

Example 2:
Given the following words in dictionary,

[
  "z",
  "x"
]
The correct order is: "zx".

Example 3:
Given the following words in dictionary,

[
  "z",
  "x",
  "z"
]
 * @author vkotha
 *
 */
public class AlienDictionary {

	public static void main(String[] args) {

	}

	public String alienOrderBFS(String[] words) {		

		if (words == null || words.length == 0) {
			return "";
		}

		Map<Character, Set<Character>> depMap = new HashMap<>();
		Map<Character, Integer> depCntMap = new HashMap<>();
		for (String s : words) {
			for (char c : s.toCharArray()) {
				depCntMap.put(c, 0);
			}
		}

		for (int i = 1; i < words.length; i++) {
			String prev = words[i - 1];
			String cur = words[i];
			int minlen = Math.min(prev.length(), cur.length());
			for (int j = 0; j < minlen; j++) {

				char p = prev.charAt(j);
				char c = cur.charAt(j);
				if (p != c) {
					if (!depMap.containsKey(p)) {
						depMap.put(p, new HashSet<>());
					}
					if (depMap.get(p).add(c)) {
						depCntMap.put(c, depCntMap.get(c) + 1);
					}
					break;
				}
			}
		}

		Queue<Character> queue = new LinkedList<>();
		for (char c : depCntMap.keySet()) {
			if (depCntMap.get(c) == 0) {
				queue.offer(c);
				Set<Character> dep = depMap.get(c);
				if(dep == null){
					continue;
				}
				for (char d : dep) {
					depCntMap.put(d, depCntMap.get(d) - 1);
					if(depCntMap.get(d) == 0){
						queue.offer(d);
					}
				}
			}
		}
		
		StringBuilder res = new StringBuilder();

		while(!queue.isEmpty()){
			char c = queue.poll();
			res.append(c);
		}
		
		if(res.toString().length() != depCntMap.size()){
			return "";
		}
		return res.toString();
	}

}
