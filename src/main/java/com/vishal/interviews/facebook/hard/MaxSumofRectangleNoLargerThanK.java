package com.vishal.interviews.facebook.hard;

import java.util.TreeSet;

public class MaxSumofRectangleNoLargerThanK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxSumSubmatrix(int[][] matrix, int k) {

		int maxSum = Integer.MIN_VALUE;

		for (int l = 0; l < matrix.length; l++) {
			int[] temp = new int[matrix[0].length];
			for (int i = l; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					temp[j] += matrix[i][j];
				}
				int curRes = maxSubArraySum(temp, k);
				if (curRes <= k && curRes > maxSum) {
					maxSum = curRes;
				}
			}
		}
		return maxSum;
	}

	int maxSubArraySum(int[] nums, int k) {

		int max = Integer.MIN_VALUE;

		TreeSet<Integer> set = new TreeSet<>();
		int sum = 0;
		set.add(0);
		for (int i : nums) {
			sum += i;
			Integer gap = set.ceiling(sum - k);
			if (gap != null) {
				max = Math.max(max, sum - gap);
			}
			set.add(sum);
		}
		return max;
	}
}
