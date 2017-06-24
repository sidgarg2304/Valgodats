package com.vishal.interviews.programcreek;

import java.util.Arrays;

public class Candy {

	public static void main(String[] args) {

	}

	public int candy(int[] ratings) {

		if (ratings == null || ratings.length == 0) {
			return 0;
		}

		int[] candies = new int[ratings.length];
		Arrays.fill(candies, 1);

		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candies[i] = Math.max(candies[i], candies[i - 1] + 1);
			}
		}

		int res = candies[candies.length - 1];
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				candies[i] = Math.max(candies[i], candies[i + 1] + 1);
			}
			res += candies[i];
		}

		return res;
	}

}
