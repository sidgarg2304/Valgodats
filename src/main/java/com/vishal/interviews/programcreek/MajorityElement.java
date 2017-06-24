package com.vishal.interviews.programcreek;

public class MajorityElement {

	public static void main(String[] args) {

		System.out.println(majorityElement(new int[] { 1, 2, 2, 3, 2, 2 }));
	}

	public static int majorityElement(int[] nums) {

		if (nums == null || nums.length == 0) {
			return -1;
		}

		int cnt = 1;

		int res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				cnt++;
			} else {
				cnt--;
				if (cnt == 0) {
					res = nums[i];
					cnt = 1;
				}
			}
		}

		return res;
	}

}
