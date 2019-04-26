package com.vishal.interviews.facebook.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class InsertDeleteGetRandomO1Duplicatesallowed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Map<Integer, Integer> posMap;
	Map<Integer, Set<Integer>> valuesMap;
	Random rand;

	InsertDeleteGetRandomO1Duplicatesallowed() {
		valuesMap = new HashMap<>();
		posMap = new HashMap<>();
		rand = new Random();
	}

	public boolean insert(int val) {

		boolean contained = false;
		if (valuesMap.containsKey(val)) {
			contained = true;
		} else {
			valuesMap.put(val, new HashSet<>());
		}

		valuesMap.get(val).add(posMap.size());
		posMap.put(posMap.size(), val);

		return contained;
	}

	/**
	 * Removes a value from the collection. Returns true if the collection
	 * contained the specified element.
	 */
	public boolean remove(int val) {

		if (!valuesMap.containsKey(val)) {
			return false;
		}

		int posToRemove = valuesMap.get(val).iterator().next();
		valuesMap.get(val).remove(posToRemove);
		if (posToRemove < posMap.size() - 1) {
			int lastVal = posMap.get(posMap.size()-1);			
			posMap.put(posToRemove, lastVal);
			valuesMap.get(lastVal).remove(posMap.size()-1);
			valuesMap.get(lastVal).add(posToRemove);
		}
		posMap.remove(posMap.size() - 1);

		if (valuesMap.get(val).isEmpty()) {
			valuesMap.remove(val);
		}
		
		return true;
	}

	/** Get a random element from the collection. */
	public int getRandom() {
		int r = rand.nextInt(posMap.size());
		return posMap.get(r);
	}

}
