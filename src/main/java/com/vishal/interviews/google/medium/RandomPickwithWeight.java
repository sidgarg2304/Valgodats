package com.vishal.interviews.google.medium;

import java.util.Random;
import java.util.TreeMap;

public class RandomPickwithWeight {

	public static void main(String[] args) {

	}

	int[] weights;
	Random rand;
	TreeMap<Integer, Integer> map = new TreeMap<>();
	int tot = 0;

	RandomPickwithWeight(int[] weights) {
		this.weights = weights;
		for (int i = 0; i < weights.length; i++) {
			tot += weights[i];
			map.put(tot, i);
		}
	}

	// {1, 3}
	// total is 4, rand values can be generated are 0, 1, 2, 3
	// 0 should map to 1 as weight is 1 and 1 element
	// 1,2,3 should map to 3 as weight is 3 and 3 elements
	
	// ceilingKey(0) can give 1 and 0 as it is greater than equal to.
	//hence we should add +1 so we get ceilingKey(1) which will give only 1
	
	// ceilingKey(1) can also give 1 or 3 but we should get only 3. hence +1 will make sure we get 3
	int pickIndex() {
		int randKey = map.ceilingKey(rand.nextInt(tot) + 1);
		return map.get(randKey);
	}

}
