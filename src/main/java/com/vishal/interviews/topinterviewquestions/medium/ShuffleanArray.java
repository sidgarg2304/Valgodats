package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

public class ShuffleanArray {

	public static void main(String[] args) {
		Random rand = new Random();
		System.out.println(rand.nextInt(3));
	}

	int[] original;

	ShuffleanArray(int[] nums) {
		original = nums;
	}

	int[] reset() {
		return original;
	}

	int[] shuffle() {
		Random rand = new Random();
		int[] res = new int[original.length];
		for (int i = 0; i < res.length; i++) {
			int pos = rand.nextInt(i + 1);
			res[i] = res[pos];
			res[pos] = original[i];
		}

		return res;
	}

}
