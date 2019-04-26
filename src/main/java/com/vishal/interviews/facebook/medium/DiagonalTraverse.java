package com.vishal.interviews.facebook.medium;

public class DiagonalTraverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] findDiagonalOrder(int[][] matrix) {

		if (matrix == null || matrix.length == 0) {
			return new int[] {};
		}

		int[][] dirs = new int[][] { { -1, 1 }, { 1, -1 } };
		int diag = 0;

		int[] res = new int[matrix.length * matrix[0].length];

		int r = 0;
		int i = 0;
		int j = 0;
		while (r < res.length) {
			res[r++] = matrix[i][j];
			i += dirs[diag][0];
			j += dirs[diag][1];

			if (i > matrix.length - 1) {
				i = matrix.length - 1;
				j += 2;
				diag ^= 1;
			}

			if (j > matrix[0].length - 1) {
				j = matrix[0].length - 1;
				i += 2;
				diag ^= 1;
			}

			if (i < 0) {
				diag ^= 1;
				i = 0;
			}

			if (j < 0) {
				diag ^= 1;
				j = 0;
			}

		}
		return res;

	}

}
