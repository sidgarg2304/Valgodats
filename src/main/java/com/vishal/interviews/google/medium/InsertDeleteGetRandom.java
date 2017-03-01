package com.vishal.interviews.google.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 380. Insert Delete GetRandom O(1)
 * 
 * Design a data structure that supports all following operations in average
 * O(1) time.
 * 
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present. getRandom: Returns
 * a random element from current set of elements. Each element must have the
 * same probability of being returned.
 * 
 * Example:
 * 
 * // Init an empty set.
 * 
 * RandomizedSet randomSet = new RandomizedSet();
 * 
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * 
 * randomSet.insert(1);
 * 
 * // Returns false as 2 does not exist in the set.
 * 
 * randomSet.remove(2);
 * 
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 * 
 * // getRandom should return either 1 or 2 randomly.
 * 
 * randomSet.getRandom();
 * 
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 * 
 * // 2 was already in the set, so return false.
 * 
 * randomSet.insert(2);
 * 
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 * 
 */
public class InsertDeleteGetRandom {

	public static void main(String[] args) {

	}

}

class RandomizedSetEasyHashMap {
   
   private HashMap<Integer, Integer> keyMap = null;
   private HashMap<Integer, Integer> valueMap = null;
   int count;

   /** Initialize your data structure here. */
   public RandomizedSetEasyHashMap() {
       keyMap = new HashMap<Integer, Integer>();
       valueMap = new HashMap<Integer, Integer>();
   }
   
   /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
   public boolean insert(int val) {
       if(keyMap.containsKey(val)) {
           return false;
       } else {
           keyMap.put(val, count);
           valueMap.put(count, val);
           count = keyMap.size();
           return true;
       }
   }
   
   /** Removes a value from the set. Returns true if the set contained the specified element. */
   public boolean remove(int val) {
       if(!keyMap.containsKey(val)) {
           return false;
       } else {
           int valueKey = keyMap.get(val);
           keyMap.remove(val);
           if(valueKey != valueMap.size() - 1) {
               valueMap.put(valueKey, valueMap.get(valueMap.size() - 1));
               keyMap.put(valueMap.get(valueMap.size() - 1), valueKey);
               valueMap.remove(valueMap.size() - 1);
           } else {
               valueMap.remove(valueKey);
           }
           count = keyMap.size();
           return true;
       }
   }
   
   /** Get a random element from the set. */
   public int getRandom() {
       Random random = new Random();
       int n = random.nextInt(keyMap.size());
       return valueMap.get(n);
   }
}

/**
 * Java solution using a HashMap and an ArrayList along with a follow-up. (131
 * ms)
 * 
 * I got a similar question for my phone interview. The difference is that the
 * duplicated number is allowed. So, think that is a follow-up of this question.
 * How do you modify your code to allow duplicated number?
 *
 */
class RandomizedSetUsingHashMap {
	List<Integer> nums;
	Map<Integer, Integer> locs;
	java.util.Random rand = new java.util.Random();

	/** Initialize your data structure here. */
	public RandomizedSetUsingHashMap() {
		nums = new ArrayList<Integer>();
		locs = new HashMap<Integer, Integer>();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {
		boolean contain = locs.containsKey(val);
		if (contain)
			return false;
		locs.put(val, nums.size());
		nums.add(val);
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove(int val) {
		boolean contain = locs.containsKey(val);
		if (!contain)
			return false;
		int loc = locs.get(val);
		if (loc < nums.size() - 1) { // not the last one than swap the last one
											  // with this val
			int lastone = nums.get(nums.size() - 1);
			nums.set(loc, lastone);
			locs.put(lastone, loc);
		}
		locs.remove(val);
		nums.remove(nums.size() - 1);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return nums.get(rand.nextInt(nums.size()));
	}
}
