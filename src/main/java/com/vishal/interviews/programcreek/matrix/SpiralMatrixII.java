package com.vishal.interviews.programcreek.matrix;

public class SpiralMatrixII {

	public static void main(String[] args) {

	}

	public int[][] generateMatrix(int n) {

		if (n <= 0) {
			return new int[][] {};
		}

		int[][] res = new int[n][n];

		int val = 1;

		int rowStart = 0;
		int rowEnd = n - 1;
		int colStart = 0;
		int colEnd = n - 1;

		while (rowStart <= rowEnd && colStart <= colEnd) {

			if (rowStart <= rowEnd) {
				for (int j = colStart; j <= colEnd; j++) {
					res[rowStart][j] = val++;
				}
			}
			rowStart++;

			if (colStart <= colEnd) {
				for (int i = rowStart; i <= rowEnd; i++) {
					res[i][colEnd] = val++;
				}
			}
			colEnd--;

			for (int j = colEnd; j >= colStart; j--) {
				res[rowEnd][j] = val++;
			}
			rowEnd--;

			for (int i = rowEnd; i >= rowStart; i--) {
				res[i][colStart] = val++;
			}
			colStart++;
		}

		return res;
	}

}
