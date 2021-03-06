package com.vishal.interviews.topinterviewquestions.medium;

public class Searcha2DMatrixII {

	public static void main(String[] args) {

	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}

		int i = matrix.length - 1;
		int j = 0;

		while (i >= 0 && j < matrix[0].length) {
			if (matrix[i][j] == target) {
				return true;
			} else if (target < matrix[i][j]) {
				i--;
			} else {
				j++;
			}
		}
		return false;
	}
}
