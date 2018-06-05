package com.vishal.interviews.leetcodereremaining.hard;

/**
 * 
 * 52. N-Queens II Follow up for N-Queens problem.
 * 
 * Now, instead outputting board configurations, return the total number of
 * distinct solutions.
 */
public class NQueensII {

	public static void main(String[] args) {

	}

	int count = 0;

	public int totalNQueens(int n) {
		boolean[] cols = new boolean[n];
		boolean[] diag1 = new boolean[2 * n];
		boolean[] diag2 = new boolean[2 * n];

		backtracking(0, cols, diag1, diag2, n);

		return count;
	}

	public void backtracking(int row, boolean[] cols, boolean[] diag1, boolean[] diag2, int n) {
		if (row == n) {
			count++;
			return;
		}

		for (int col = 0; col < n; col++) {
			int d1 = row - col + n;
			int d2 = row + col;

			if (cols[col] || diag1[d1] || diag2[d2]) {
				continue;
			}
			cols[col] = true;
			diag1[d1] = true;
			diag2[d2] = true;

			backtracking(row + 1, cols, diag1, diag2, n);

			cols[col] = false;
			diag1[d1] = false;
			diag2[d2] = false;
		}
	}
}
