package com.vishal.interviews.facebook.medium;

import java.util.Arrays;

public class LargestNumber {

	public static void main(String[] args) {

	}

	public String largestNumber(int[] nums) {

		if(nums == null || nums.length == 0) {
			return "";
		}
		
		String[] numsStrs = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			numsStrs[i] = String.valueOf(nums[i]);
		}

		Arrays.sort(numsStrs, (a, b) -> (b + a).compareTo(a + b));
		StringBuilder sb = new StringBuilder();

		for (String s : numsStrs) {
			sb.append(s);
		}

		while (sb.length() > 1 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}

}
