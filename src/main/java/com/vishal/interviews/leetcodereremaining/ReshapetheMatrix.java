package com.vishal.interviews.leetcodereremaining;

public class ReshapetheMatrix {

	public static void main(String[] args) {

	}

	public int[][] matrixReshape(int[][] nums, int r, int c) {

		int m = nums.length;
		int n = nums[0].length;
		if (r * c > m * n) {
			return nums;
		}

		int cnt = 0;
		int[][] res = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				res[i][j] = nums[cnt / n][cnt % n];
				cnt++;
			}
		}

		return res;
	}

}
