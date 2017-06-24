package com.vishal.interviews.programcreek.matrix;

public class GameofLife {

	public static void main(String[] args) {

	}

	public void gameOfLife(int[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0)
			return;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int liveNeighbors = getLiveNeighbors(board, i, j);
				if ((board[i][j] & 1) == 1) {
					if (liveNeighbors >= 2 && liveNeighbors <= 3) {
						board[i][j] = 3;
					}
				} else {
					if (liveNeighbors == 3) {
						board[i][j] = 2;
					}
				}
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] >>= 1;
			}
		}
	}

	int getLiveNeighbors(int[][] board, int r, int c) {

		int res = 0;

		for (int i = Math.max(0, r - 1); i <= Math.min(r + 1, board.length - 1); i++) {
			for (int j = Math.max(c - 1, 0); j <= Math.min(c + 1, board[0].length - 1); j++) {
				if ((board[i][j] & 1) == 1) {
					res++;
				}
			}
		}
		return res;
	}

}
