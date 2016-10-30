package com.vishal.algorithms.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	private Map<Integer, Integer> pairMap;

	public TwoSum() {
		pairMap = new HashMap<>();
	}

	public void add(int number) {
		if (pairMap.containsKey(number)) {
			pairMap.put(number, pairMap.get(number) + 1);
		} else {
			pairMap.put(number, 1);
		}
	}

	public boolean pairExists(int sum) {

		for (int k : pairMap.keySet()) {
			int pairVal = sum - k;

			if (pairMap.containsKey(k)) {
				if (k == pairVal && pairMap.get(k) < 2) {
					continue;
				}
				return true;
			}
		}
		return false;
	}

}
