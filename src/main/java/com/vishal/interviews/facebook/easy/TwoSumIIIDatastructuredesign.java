package com.vishal.interviews.facebook.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIIIDatastructuredesign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Map<Integer, Integer> map;

	/** Initialize your data structure here. */
	public TwoSumIIIDatastructuredesign() {
		map = new HashMap<>();
	}

	/** Add the number to an internal data structure.. */
	public void add(int number) {
		map.put(number, map.getOrDefault(number, 0) + 1);
	}

	/**
	 * Find if there exists any pair of numbers which sum is equal to the value.
	 */
	public boolean find(int value) {
		for (int key : map.keySet()) {
			int target = value - key;
			if (map.containsKey(target) && (target != key || map.get(target) >= 2)) {
				return true;
			}
		}
		return false;
	}

}
