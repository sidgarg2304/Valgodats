package com.vishal.interviews.programcreek.matrix;

public class SetMatrixZeroes {

	public static void main(String[] args) {

	}

	public void setZeroes(int[][] matrix) {
		
		if(matrix == null || matrix.length == 0){
			return;
		}
		
		int[] row = new int[matrix.length];
		int[] col = new int[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = 0;
					col[j] = 0;
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (row[i] == 0 && col[j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
	}

}
