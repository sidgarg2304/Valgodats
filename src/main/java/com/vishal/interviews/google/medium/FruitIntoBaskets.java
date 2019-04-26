package com.vishal.interviews.google.medium;

import java.util.*;

public class FruitIntoBaskets {

	public static void main(String[] args) {

	}

	public int totalFruit(int[] tree) {

		if (tree == null || tree.length == 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();

		int st = 0;
		int res = 1;
		for (int i = 0; i < tree.length; i++) {
			map.put(tree[i], map.getOrDefault(tree[i], 0) + 1);

			while (map.size() > 2) {
				map.put(tree[st], map.get(tree[st]) - 1);

				if (map.get(tree[st]) == 0) {
					map.remove(tree[st]);
				}
				st++;
			}

			res = Math.max(res, i - st + 1);
		}
		return res;
	}

}
