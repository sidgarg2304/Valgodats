package com.vishal.interviews.programcreek.hashmap;

import java.util.*;

public class ShortestWordDistanceII {

	public static void main(String[] args) {

	}

	Map<String, List<Integer>> map;

	public ShortestWordDistanceII(String[] words) {

		map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			String w = words[i];
			if (!map.containsKey(w)) {
				map.put(w, new ArrayList<>());
			}
			map.get(w).add(i);
		}
	}

	public int shortest(String word1, String word2) {
		int i = 0;
		int j = 0;

		int res = Integer.MAX_VALUE;
		while (i < map.get(word1).size() && j < map.get(word2).size()) {
			int index1 = map.get(word1).get(i);
			int index2 = map.get(word2).get(j);

			res = Math.min(res, Math.abs(index2 - index1));

			if (index1 < index2) {
				i++;
			} else {
				j++;
			}
		}

		return res;
	}

}
