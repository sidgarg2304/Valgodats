package com.vishal.interviews.facebook.easy;

import java.util.*;

public class FindAllNumbersDisappearedinanArray {

	public static void main(String[] args) {

	}

	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> res = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			int pos = Math.abs(nums[i]) - 1;
			if (nums[pos] > 0) {
				nums[pos] *= -1;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				res.add(i + 1);
			}
		}
		return res;
	}

}
