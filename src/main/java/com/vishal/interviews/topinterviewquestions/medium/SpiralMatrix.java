package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

public class SpiralMatrix {

	public static void main(String[] args) {

	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();

		if (matrix == null || matrix.length == 0) {
			return res;
		}

		int rowSt = 0;
		int rowEn = matrix.length - 1;
		int colSt = 0;
		int colEn = matrix[0].length - 1;

		while (rowSt <= rowEn && colSt <= colEn) {

			if (rowSt <= rowEn) {
				for (int j = colSt; j <= colEn; j++) {
					res.add(matrix[rowSt][j]);
				}
				rowSt++;
			}

			if (colSt <= colEn) {
				for (int i = rowSt; i <= rowEn; i++) {
					res.add(matrix[i][colEn]);
				}
				colEn--;
			}

			for (int j = colEn; j >= colSt; j--) {
				res.add(matrix[rowEn][j]);
			}
			rowEn--;

			for (int i = rowEn; i >= rowSt; i--) {
				res.add(matrix[i][colSt]);
			}
			colSt++;
		}

		return res;

	}

}
