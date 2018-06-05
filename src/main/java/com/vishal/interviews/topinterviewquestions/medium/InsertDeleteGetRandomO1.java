package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

public class InsertDeleteGetRandomO1 {

	public static void main(String[] args) {

	}

	Random rand;

	Map<Integer, Integer> posMap;
	Map<Integer, Integer> valuesMap;

	public InsertDeleteGetRandomO1() {
		rand = new Random();
		posMap = new HashMap<>();
		valuesMap = new HashMap<>();
	}

	boolean insert(int val) {
		if (valuesMap.containsKey(val)) {
			return false;
		}
		valuesMap.put(val, valuesMap.size() - 1);
		posMap.put(posMap.size() - 1, val);
		return true;
	}

	int getRandom() {
		int p = rand.nextInt(posMap.size());
		return posMap.get(p);
	}

	boolean delete(int val) {
		if (!valuesMap.containsKey(val)) {
			return false;
		}
		int posToBeDeleted = valuesMap.get(val);
		if (posToBeDeleted != posMap.size() - 1) {			
			valuesMap.put(posMap.get(posMap.size()-1), posToBeDeleted);
			posMap.put(posToBeDeleted, posMap.get(posMap.size()-1));
		}
		valuesMap.remove(val);
		posMap.remove(posMap.size()-1);

		return true;
	}
}
