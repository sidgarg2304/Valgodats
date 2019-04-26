package com.vishal.interviews.facebook.medium;

public class DesignTicTacToe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int[] x;
	int[] y;
	int n;
	int diagCnt;
	int antiDiagCnt;

	public DesignTicTacToe(int n) {
		x = new int[n];
		y = new int[n];
		this.n = n;
	}

	public int move(int row, int col, int player) {

		int val = player == 0 ? -1 : 1;

		x[row] += val;
		y[col] += val;

		if (row == col) {
			diagCnt += val;
		}
		
		if(row == n - col - 1){
			antiDiagCnt += val;
		}

		if (Math.abs(x[row]) == n || Math.abs(y[col]) == n || Math.abs(diagCnt) == n || Math.abs(antiDiagCnt) == n) {
			return player;
		}

		return 0;
	}

}
