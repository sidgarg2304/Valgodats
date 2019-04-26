package com.vishal.interviews.uber.medium;

import java.util.*;

public class RandomPickwithWeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int tot = 0;
	TreeMap<Integer, Integer> map;

	Random rand;

	RandomPickwithWeight(int[] weights) {
		map = new TreeMap<>();
		for (int i = 0; i < weights.length; i++) {
			tot += weights[i];
			map.put(tot, i);
		}
		rand = new Random();
	}

	int pickIndex() {
		int randKey = map.ceilingKey(rand.nextInt(tot) + 1);
		return map.get(randKey);
	}

}
