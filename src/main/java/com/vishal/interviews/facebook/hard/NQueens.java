package com.vishal.interviews.facebook.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
		
		if(n <= 0) {
			return res;
		}

		boolean[] cols = new boolean[n];
		boolean[] diag = new boolean[2 * n];
		boolean[] antiDiag = new boolean[2 * n];
		
		dfs(n, 0, cols, diag, antiDiag, new ArrayList<>(), res);
		
		return res;
	}

	void dfs(int n, int row, boolean[] cols, boolean[] diag, boolean[] antiDiag, List<String> temp,
			List<List<String>> res) {

		if (row == n) {
			res.add(new ArrayList<>(temp));
			return;
		}

		for (int col = 0; col < n; col++) {

			int d1 = row + col;
			int d2 = row - col + n;
			if (cols[col] || diag[d1] || antiDiag[d2]) {
				continue;
			}

			cols[col] = true;
			diag[d1] = true;
			antiDiag[d2] = true;

			char[] curRow = new char[n];
			Arrays.fill(curRow, '.');
			curRow[col] = 'Q';

			temp.add(String.valueOf(curRow));
			dfs(n, row + 1, cols, diag, antiDiag, temp, res);
			temp.remove(temp.size() - 1);

			cols[col] = false;
			diag[d1] = false;
			antiDiag[d2] = false;
		}
	}
}
