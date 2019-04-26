package com.vishal.interviews.facebook.medium;

import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] searchRange(int[] nums, int target) {
      int[] res = new int[2];
      Arrays.fill(res, -1);

		if (nums == null || nums.length == 0) {
			return res;
		}
		int i = 0;
		int j = nums.length - 1;
		while (i <= j) {
			int m = i + (j - i) / 2;
			if (nums[m] == target) {
				int l = m;
				while (l >= i && nums[l] == target) {
					l--;
				}
				res[0] = l + 1;
				int r = m;
				while (r <= j && nums[r] == target) {
					r++;
				}
				res[1] = r - 1;
				break;
			} else if (target < nums[m]) {
				j = m - 1;
			} else {
				i = m + 1;
			}
		}
		return res;
  }

}
