package com.vishal.interviews.topinterviewquestions.hard;

public class RangeSumQuery2DMutable {

	public static void main(String[] args) {

	}

	int[][] matrix;
	int[][] colSums;

	RangeSumQuery2DMutable(int[][] matrix) {
		this.matrix = matrix;
		colSums = new int[matrix.length + 1][matrix[0].length + 1];

		for (int i = 1; i < colSums.length; i++) {
			for (int j = 0; j < colSums[0].length; j++) {
				colSums[i][j] += colSums[i - 1][j] + matrix[i - 1][j];
			}
		}
	}

	public void update(int row, int col, int val) {
		for (int i = row + 1; i < colSums.length; i++) {
			colSums[i][col] = colSums[i][col] - matrix[row][col] + val;
		}
		matrix[row][col] = val;
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int res = 0;

		for (int j = col1; j <= col2; j++) {
			res += colSums[row2 + 1][j] - colSums[row1][j];
		}
		return res;
	}

}
