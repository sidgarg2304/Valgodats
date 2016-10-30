package com.vishal.algorithms.matrix;

public class MatrixPrefixSumAlgorithms {

	public static void main(String[] args) {
		int[][] matrix = new int[4][4];
		matrix[0] = new int[] { 1, 2, 3, 4 };
		matrix[1] = new int[] { 3, 1, 2, 4 };
		matrix[2] = new int[] { 1, 2, 3, 2 };
		matrix[3] = new int[] { 4, 3, 1, 2 };

		MatrixBasicAlgorithms.printMatrix(matrix);

		int[][] prefixSumMatrix = constructPrefixSumMatrix(matrix);
		MatrixBasicAlgorithms.printMatrix(prefixSumMatrix);

		System.out.println(sumOfARegion(prefixSumMatrix, 1, 0, 2, 0));

	}

	public static int[][] constructPrefixSumMatrix(int[][] m) {

		int[][] prefixSumMatrix = new int[m.length][m[0].length];

		for (int i = 0; i < m.length; i++) {
			int rowSum = 0;
			for (int j = 0; j < m[0].length; j++) {
				rowSum += m[i][j];
				if (i == 0) {
					prefixSumMatrix[i][j] = rowSum;
				} else {
					prefixSumMatrix[i][j] = rowSum + prefixSumMatrix[i - 1][j];
				}
			}
		}
		return prefixSumMatrix;
	}

	public static int sumOfARegion(int[][] prefixSumMatrix, int row1, int col1, int row2, int col2) {

		int result = prefixSumMatrix[row2][col2];

		if (row1 != 0 && col1 != 0) {
			result -= prefixSumMatrix[row1 - 1][col2];
			result -= prefixSumMatrix[row2][col1 - 1];
			result += prefixSumMatrix[row1 - 1][col1 - 1];
		} else if (row1 != 0) {
			result -= prefixSumMatrix[row1 - 1][col2];
		} else if (col1 != 0) {
			result -= prefixSumMatrix[row2][col1 - 1];
		}			

		return result;

	}

}
