package com.vishal.interviews.topinterviewquestions.easy;

public class MajorityElement {

	public static void main(String[] args) {

	}

	public int majorityElement(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int res = nums[0];
		int cnt = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == res) {
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
