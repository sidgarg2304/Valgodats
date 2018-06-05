package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

public class LargestNumber {

	public static void main(String[] args) {

	}

	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return "";
		}

		String[] strs = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strs[i] = String.valueOf(nums[i]);
		}

		Arrays.sort(strs, new Comparator<String>() {
			public int compare(String a, String b) {
				return (b + a).compareTo(a + b);
			}
		});

		StringBuilder res = new StringBuilder();
		for (String s : strs) {
			res.append(s);
		}
		return res.toString();
	}

}
