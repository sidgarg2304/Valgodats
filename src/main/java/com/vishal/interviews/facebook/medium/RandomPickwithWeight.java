package com.vishal.interviews.facebook.medium;

import java.util.*;

public class RandomPickwithWeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int[] prefixSums;
	Random rand;

	public RandomPickwithWeight(int[] w) {

		prefixSums = new int[w.length];
		prefixSums[0] = w[0];
		for (int i = 1; i < w.length; i++) {
			prefixSums[i] = prefixSums[i - 1] + w[i];
		}
		rand = new Random();
	}

	public int pickIndex() {
		int randWeight = rand.nextInt(prefixSums[prefixSums.length - 1]);

		int l = 0;
		int r = prefixSums.length - 1;
		while (l <= r) {
			int m = l + (r - l) / 2;
			if (randWeight < prefixSums[m]) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return l;
	}

}
