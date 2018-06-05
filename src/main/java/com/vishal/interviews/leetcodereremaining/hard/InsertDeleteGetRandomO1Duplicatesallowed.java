package com.vishal.interviews.leetcodereremaining.hard;

import java.util.*;
/**
 * 381. Insert Delete GetRandom O(1) - Duplicates allowed
 * 
 * Design a data structure that supports all following operations in average O(1) time.

Note: Duplicate elements are allowed.
insert(val): Inserts an item val to the collection.
remove(val): Removes an item val from the collection if present.
getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
Example:

// Init an empty collection.
RandomizedCollection collection = new RandomizedCollection();

// Inserts 1 to the collection. Returns true as the collection did not contain 1.
collection.insert(1);

// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
collection.insert(1);

// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
collection.insert(2);

// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
collection.getRandom();

// Removes 1 from the collection, returns true. Collection now contains [1,2].
collection.remove(1);

// getRandom should return 1 and 2 both equally likely.
collection.getRandom();
 *
 */
public class InsertDeleteGetRandomO1Duplicatesallowed {

	public static void main(String[] args) {

	}

	List<Integer> posList;
	Map<Integer, Set<Integer>> valuesMap;
	Random rand;

	public InsertDeleteGetRandomO1Duplicatesallowed() {
		posList = new ArrayList<>();
		valuesMap = new HashMap<>();
		rand = new Random();
	}

	/**
	 * Inserts a value to the collection. Returns true if the collection did not
	 * already contain the specified element.
	 */
	public boolean insert(int val) {
		boolean contained = valuesMap.containsKey(val);

		if (!contained) {
			valuesMap.put(val, new LinkedHashSet<>());
		}

		valuesMap.get(val).add(posList.size());
		posList.add(val);

		return !contained;
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
		if (posToRemove < posList.size() - 1) {
			int lastValue = posList.get(posList.size()-1);
			posList.set(posToRemove, lastValue);
			
			valuesMap.get(lastValue).remove(posList.size()-1);
			valuesMap.get(lastValue).add(posToRemove);
		}		
		posList.remove(posList.size()-1);
		
		if(valuesMap.get(val).isEmpty()){
			valuesMap.remove(val);
		}
		
		return true;
	}

	/** Get a random element from the collection. */
	public int getRandom() {
		return posList.get(rand.nextInt(posList.size()));
	}

}
