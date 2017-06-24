package com.vishal.interviews.leetcodereremaining.medium;

import java.util.*;

public class ShuffleanArray {

	public static void main(String[] args) {

	}

	int[] original;

	public ShuffleanArray(int[] nums) {
		original = nums;
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return original;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {

		Random rand = new Random();
		int[] res = new int[original.length];

		for (int i = 0; i < original.length; i++) {
			int pos = rand.nextInt(i + 1);
			res[i] = res[pos];
			res[pos] = original[i];
		}
		
		return res;
	}

}
