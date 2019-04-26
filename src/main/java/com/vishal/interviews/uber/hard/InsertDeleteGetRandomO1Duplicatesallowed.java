package com.vishal.interviews.uber.hard;

import java.util.*;

public class InsertDeleteGetRandomO1Duplicatesallowed {

	public static void main(String[] args) {

	}

	Map<Integer, Set<Integer>> valMap;
	Map<Integer, Integer> posMap;
	Random rand;

	InsertDeleteGetRandomO1Duplicatesallowed() {
		valMap = new HashMap<>();
		posMap = new HashMap<>();
		rand = new Random();
	}

	public boolean insert(int val) {
		boolean ret = false;
		if (!valMap.containsKey(val)) {
			valMap.put(val, new HashSet<>());
			ret = true;
		}

		valMap.get(val).add(posMap.size());
		posMap.put(posMap.size(), val);

		return ret;
	}

	public boolean remove(int val) {
		if (!valMap.containsKey(val)) {
			return false;
		}
		
		int posToRemove = valMap.get(val).iterator().next();
		if(posToRemove != posMap.size() - 1) {
			int lastVal = posMap.get(posMap.size()-1);
			posMap.put(posToRemove, lastVal);
			valMap.get(lastVal).remove(posMap.size()-1);
			valMap.get(lastVal).add(posToRemove);
		}
		posMap.remove(posMap.size()-1);
		
		if(valMap.get(val).isEmpty()) {
			valMap.remove(val);
		}
		return true;
		
	}

	/** Get a random element from the collection. */
	public int getRandom() {
		int randPos = rand.nextInt(posMap.size());
		return posMap.get(randPos);
	}

}
