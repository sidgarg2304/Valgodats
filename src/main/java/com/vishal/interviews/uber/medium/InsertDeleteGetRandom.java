package com.vishal.interviews.uber.medium;

import java.util.*;

public class InsertDeleteGetRandom {

	public static void main(String[] args) {

	}

	Map<Integer, Integer> valueMap;
	Map<Integer, Integer> posMap;
	Random rand;

	/** Initialize your data structure here. */
	public InsertDeleteGetRandom() {
		valueMap = new HashMap<>();
		posMap = new HashMap<>();
		rand = new Random();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {
		if (valueMap.containsKey(val)) {
			return false;
		}

		valueMap.put(val, posMap.size());
		posMap.put(posMap.size(), val);

		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove(int val) {
		if (!valueMap.containsKey(val)) {
			return false;
		}

		int posToRemove = valueMap.get(val);
		if (posToRemove != posMap.size() - 1) {
			int lastVal = posMap.get(posMap.size() - 1);
			posMap.put(posToRemove, lastVal);
			valueMap.put(lastVal, posToRemove);
		}
		
		posMap.remove(posMap.size()-1);
		valueMap.remove(val);
		
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		int pos = rand.nextInt(posMap.size());
		return posMap.get(pos);
	}

}
