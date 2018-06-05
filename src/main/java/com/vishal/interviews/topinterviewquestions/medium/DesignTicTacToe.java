package com.vishal.interviews.topinterviewquestions.medium;

public class DesignTicTacToe {

	public static void main(String[] args) {

	}

	int n;
	int diag;
	int antiDiag;
	int[] rows;
	int[] cols;

	public DesignTicTacToe(int c, int r, int n) {
		this.n = n;
		rows = new int[r];
		cols = new int[c];
	}

	boolean move(int player, int r, int c) {
		int val = player == 1 ? 1 : -1;
		rows[r] += val;
		cols[c] += val;

		if (r == c) {
			diag += val;
		}
		if (r == n - c - 1) {
			antiDiag += val;
		}

		if (Math.abs(rows[r]) == n || Math.abs(cols[c]) == n || Math.abs(diag) == n || Math.abs(antiDiag) == n) {
			return true;
		}
		return false;
	}

}
