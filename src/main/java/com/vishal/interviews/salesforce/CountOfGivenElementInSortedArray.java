package com.vishal.interviews.salesforce;

public class CountOfGivenElementInSortedArray {

	public static void main(String[] args) {

		System.out.println(getCount(new int[] { 1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5 }, 1));
	}

	static int getCount(int[] nums, int k) {
		int i = 0;
		int j = nums.length - 1;
		int res = 0;
		while (i <= j) {
			int m = (i + j) / 2;
			if (nums[m] == k) {
				res = 1;
				int l = m - 1;
				int r = m + 1;
				while (l >= 0 && nums[l] == k) {
					l--;
					res++;
				}
				while (r < nums.length && nums[r] == k) {
					r++;
					res++;
				}
				break;
			} else if (k < nums[m]) {
				j = m - 1;
			} else {
				i = m + 1;
			}
		}
		return res;
	}

}
