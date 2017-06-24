package com.vishal.interviews.programcreek.matrix;

public class Searcha2DMatrix {

	public static void main(String[] args) {

	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		int i = 0;
		int j = matrix.length * matrix[0].length - 1;

		while (i <= j) {
			int m = i + (j - i) / 2;
			int x = m / (matrix[0].length);
			int y = m % (matrix[0].length);

			if (matrix[x][y] == target) {
				return true;
			} else if (target < matrix[x][y]) {
				j = m - 1;
			} else {
				i = m + 1;
			}
		}
		return false;
	}
}
