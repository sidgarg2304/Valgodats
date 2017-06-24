package com.vishal.interviews.programcreek.matrix;

public class TicTacToe {

	public static void main(String[] args) {
	}

	int[] rowCnt;
	int[] colCnt;
	int diagCnt;
	int antiDiagCnt;
	int n;

	public TicTacToe(int n) {
		rowCnt = new int[n];
		colCnt = new int[n];
		this.n = n;

	}

	public int move(int row, int col, int player) {
		int val = player == 1 ? 1 : -1;

		rowCnt[row] += val;
		colCnt[col] += val;

		if (row == col) {
			diagCnt += val;
		}

		if (row == n - col-1) {
			antiDiagCnt += val;
		}

		if (Math.abs(rowCnt[row]) == n || Math.abs(colCnt[col]) == n || Math.abs(diagCnt) == n
				|| Math.abs(antiDiagCnt) == n) {
			return player;
		}

		return 0;
	}
}
