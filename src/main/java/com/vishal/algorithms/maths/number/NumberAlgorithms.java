package com.vishal.algorithms.maths.number;

import java.util.Arrays;
import java.util.Comparator;

public class NumberAlgorithms {

	public static void main(String[] args) {
		longNumber(new int[] { 3, 30, 34, 5, 9 });

	}

	static void longNumber(int[] nums) {
		String[] strs = new String[nums.length];

		for (int i = 0; i < strs.length; i++) {
			strs[i] = String.valueOf(nums[i]);
		}

		Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				// To make sure it is sorting in decending, we do b+a with a+b
				return (b + a).compareTo(a + b);
			}
		});

		System.out.println(Arrays.toString(strs));

		StringBuilder res = new StringBuilder();
		for (String str : strs) {
			res.append(str);
		}

		while (res.toString().charAt(0) == 0 && res.length() > 1) {
			res.deleteCharAt(0);
		}

		System.out.println(
				"Longest number that can be formed by " + Arrays.toString(nums) + " is " + Integer.valueOf(res.toString()));
	}

}
