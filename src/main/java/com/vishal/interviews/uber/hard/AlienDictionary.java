package com.vishal.interviews.uber.hard;

import java.util.*;

public class AlienDictionary {

	public static void main(String[] args) {

	}

	public String alienOrder(String[] words) {

		Map<Character, Set<Character>> depMap = new HashMap<>();
		Map<Character, Integer> depCntMap = new HashMap<>();
		for (String w : words) {
			for (char c : w.toCharArray()) {
				depCntMap.put(c, 0);
			}
		}

		for (int i = 1; i < words.length; i++) {
			String p = words[i - 1];
			String c = words[i];

			for (int j = 0; j < Math.min(p.length(), c.length()); j++) {
				char a = p.charAt(j);
				char b = c.charAt(j);

				if (a == b) {
					continue;
				}

				if (!depMap.containsKey(a)) {
					depMap.put(a, new HashSet<>());
				}

				if (depMap.get(a).add(b)) {
					depCntMap.put(b, depCntMap.get(b) + 1);
				}

				break;
			}
		}

		Queue<Character> queue = new LinkedList<>();
		for (char c : depCntMap.keySet()) {
			if (depCntMap.get(c) == 0) {
				queue.offer(c);
			}
		}

		StringBuilder sb = new StringBuilder();

		while (!queue.isEmpty()) {
			char c = queue.poll();
			sb.append(c);

			Set<Character> depCharsSet = depMap.get(c);
			if (depCharsSet == null) {
				continue;
			}

			for (char n : depCharsSet) {
				depCntMap.put(n, depCntMap.get(n) - 1);
				if (depCntMap.get(n) == 0) {
					queue.offer(n);
				}
			}
		}

		if (sb.length() == depCntMap.size()) {
			return sb.toString();
		}
		return "";
	}

}
