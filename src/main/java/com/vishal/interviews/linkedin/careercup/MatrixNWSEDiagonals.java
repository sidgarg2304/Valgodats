package com.vishal.interviews.linkedin.careercup;

import java.util.*;

/**
 * Print an NxM matrix with nw-se diagonals starting at bottom left corner. Ex:


1  2  3  4
5  6  7  8
9 10 11 12
The output should be:


9
5 10
1 6 11
2 7 12
3 8
4
 *
 */
public class MatrixNWSEDiagonals {

	public static void main(String[] args) {

		int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

		System.out.println(matrixNWSEDiagonals(matrix));
	}

	static List<List<Integer>> matrixNWSEDiagonals(int[][] matrix) {
		List<List<Integer>> res = new ArrayList<>();

		if (matrix == null || matrix.length == 0) {
			return res;
		}
		int rowSt = matrix.length - 1;
		int colSt = 0;		

		// diag is i+1, j+1

		while (rowSt >= 0 && colSt < matrix[0].length) {

			int i = rowSt;
			int j = colSt;
			
			List<Integer> curRes = new ArrayList<>();

			while (i >= 0 && j >= 0 && i < matrix.length && j < matrix[0].length) {
				curRes.add(matrix[i][j]);
				i += 1;
				j += 1;
			}

			if (rowSt > 0) {
				rowSt--;
			} else {
				rowSt = 0;
				colSt++;
			}
			
			res.add(curRes);
		}

		return res;
	}

}
