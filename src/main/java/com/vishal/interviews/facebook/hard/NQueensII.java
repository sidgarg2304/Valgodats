package com.vishal.interviews.facebook.hard;

public class NQueensII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int res = 0;

	public int totalNQueens(int n) {

		boolean[] cols = new boolean[n];
		boolean[] diags = new boolean[2 * n];
		boolean[] antiDiags = new boolean[2 * n];

		backTrack(0, n, cols, diags, antiDiags);

		return res;
	}

	void backTrack(int row, int n, boolean[] cols, boolean[] diags, boolean[] antiDiags) {
		if (n == row) {
			res++;
			return;
		}

		for (int col = 0; col < n; col++) {
			int d = row + col;
			int antiD = row - col + n;

			if (cols[col] || diags[d] || antiDiags[antiD]) {
				continue;
			}

			cols[col] = true;
			diags[d] = true;
			antiDiags[antiD] = true;

			backTrack(row + 1, n, cols, diags, antiDiags);

			cols[col] = false;
			diags[d] = false;
			antiDiags[antiD] = false;
		}
	}

}
