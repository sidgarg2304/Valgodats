package com.vishal.interviews.leetcodereremaining.hard;

import java.util.*;

/**
 * 51. N-Queens
 * 
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 *
 */
public class NQueens {

	public static void main(String[] args) {

	}

	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();

		boolean[] cols = new boolean[n];
		boolean[] diag1 = new boolean[2 * n];
		boolean[] diag2 = new boolean[2 * n];

		backtracking(0, cols, diag1, diag2, n, new ArrayList<>(), res);

		return res;
	}

	public void backtracking(int row, boolean[] cols, boolean[] diag1, boolean[] diag2, int n, List<String> temp,
			List<List<String>> res) {
		if (row == n) {
			res.add(new ArrayList<>(temp));
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

			char[] curRow = new char[n];
			Arrays.fill(curRow, '.');
			curRow[col] = 'Q';
			temp.add(String.valueOf(curRow));
			backtracking(row + 1, cols, diag1, diag2, n, temp, res);

			temp.remove(temp.size()-1);
			cols[col] = false;
			diag1[d1] = false;
			diag2[d2] = false;
		}
	}

}
