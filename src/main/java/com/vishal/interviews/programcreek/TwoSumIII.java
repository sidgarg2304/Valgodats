package com.vishal.interviews.programcreek;

import java.util.*;

public class TwoSumIII {

	public static void main(String[] args) {

	}

	Map<Integer, Integer> map;

	TwoSumIII() {
		map = new HashMap<>();
	}

	void add(int val) {

		map.put(val, map.getOrDefault(val, 0) + 1);
	}

	boolean find(int val) {

		for (int k : map.keySet()) {
			int next = val - k;
			if (map.containsKey(next) && (next != k || map.get(next) > 1)) {
				return true;

			}
		}
		return false;
	}

}
