package com.vishal.interviews.facebook.medium;

import java.util.*;

/**
 * 380. Insert Delete GetRandom O(1)
 * 
 * Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();
 *
 */
public class InsertDeleteGetRandomO1 {

	public static void main(String[] args) {

		
	}

	Map<Integer, Integer> valueMap;
	Map<Integer, Integer> posMap;
	Random rand;
	int size;

	InsertDeleteGetRandomO1() {
		valueMap = new HashMap<>();
		posMap = new HashMap<>();
		rand = new Random();
		size = 0;
	}

	public boolean insert(int val) {
		if (valueMap.containsKey(val)) {
			return false;
		}

		valueMap.put(val, size);
		posMap.put(size, val);
		size++;
		return true;
	}
	
	public boolean remove(int val) {
		if (!valueMap.containsKey(val)) {
			return false;
		}
		
		int posToRemove = valueMap.get(val);
		if(posToRemove == size -1){
			valueMap.remove(val);
			posMap.remove(posToRemove);	
		}else{
			posMap.put(posToRemove, posMap.get(size-1));
			valueMap.put(posMap.get(size-1), posToRemove);
			
			valueMap.remove(val);
			posMap.remove(size-1);
			
		}
		size--;
		return true;
   }

	public int getRandom() {
		int randPos = rand.nextInt(size);
		return posMap.get(randPos);
	}

}
