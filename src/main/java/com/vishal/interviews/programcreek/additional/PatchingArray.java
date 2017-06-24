package com.vishal.interviews.programcreek.additional;

public class PatchingArray {

	public static void main(String[] args) {

	}

	// 1 3
	// 1 2 3 -> 1 2 3 4 5 6
	// 1 2 4 - > 1 2 3 4 5 6 7
	public static int minPatches(int[] nums, int n) {

		int sum = 1;
		int cnt = 0;
		int i = 0;
		while (sum <= n) {
			if (i < nums.length && nums[i] <= sum) {
				sum += nums[i++];
			} else {
				cnt++;
				sum += sum;
			}
		}

		return cnt;
	}

}
