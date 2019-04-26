package com.vishal.interviews.facebook.medium;

public class RangeSumQuery2DImmutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int[][] prefixSum;

	public RangeSumQuery2DImmutable(int[][] matrix) {

		if (matrix == null || matrix.length == 0) {
			return;
		}
		prefixSum = new int[matrix.length + 1][matrix[0].length + 1];

		for (int i = 1; i < prefixSum.length; i++) {
			for (int j = 1; j < prefixSum[0].length; j++) {
				prefixSum[i][j] = matrix[i - 1][j - 1] + prefixSum[i - 1][j] + prefixSum[i][j - 1]
						- prefixSum[i - 1][j - 1];
			}
		}

	}

	public int sumRegion(int row1, int col1, int row2, int col2) {

		return prefixSum[row2 + 1][col2 + 1] - prefixSum[row1][col2 + 1] - prefixSum[row2 + 1][col1]
				+ prefixSum[row1][col1];
	}

}
