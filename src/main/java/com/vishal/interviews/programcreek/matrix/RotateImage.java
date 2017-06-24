package com.vishal.interviews.programcreek.matrix;

public class RotateImage {

	public static void main(String[] args) {

	}

	public void rotate(int[][] matrix) {

		if (matrix == null || matrix.length == 0) {
			return;
		}
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {

			for (int j = 0; j < Math.ceil(((double) n) / 2.0); j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = temp;
			}
		}
	}

}
