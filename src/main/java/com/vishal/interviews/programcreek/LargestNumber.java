package com.vishal.interviews.programcreek;

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

		StringBuilder sb = new StringBuilder();
		for (String s : strs) {
			sb.append(s);
		}

		while (sb.length() > 1 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}

}
