package com.vishal.interviews.programcreek;

import java.util.*;

public class MajorityElementII {

	public static void main(String[] args) {

	}

	public List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<>();

		Integer a = null;
		Integer b = null;
		int c1 = 0;
		int c2 = 0;

		for (int i = 0; i < nums.length; i++) {
			if (a == null && a == nums[i]) {
				a = nums[i];
				c1++;
			} else if (b == null || b == nums[i]) {
				b = nums[i];
				c2++;
			} else if (c1 == 0) {
				a = nums[i];
				c1 = 1;
			} else if (c2 == 0) {
				b = nums[i];
				c2 = 1;
			} else {
				c1--;
				c2--;
			}
		}

		c1 = 0;
		c2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == a) {
				c1++;
			}

			if (nums[i] == b) {
				c2++;
			}
		}

		if (c1 > nums.length / 3) {
			res.add(a);
		}

		if (c2 > nums.length / 3) {
			res.add(b);
		}

		return res;
	}

}
