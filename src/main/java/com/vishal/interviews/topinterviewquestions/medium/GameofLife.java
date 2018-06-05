package com.vishal.interviews.topinterviewquestions.medium;

public class GameofLife {

	public static void main(String[] args) {

	}

	public void gameOfLife(int[][] board) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int liveNeighborsCnt = findLiveNeighborsCnt(board, i, j);
				if ((board[i][j] & 1) == 1) {
					if (liveNeighborsCnt == 2 || liveNeighborsCnt == 3) {
						board[i][j] = 3;
					}
				} else {
					if (board[i][j] == 3) {
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

	int findLiveNeighborsCnt(int[][] board, int r, int c) {

		int m = board.length - 1;
		int n = board[0].length - 1;
		int res = 0;

		for (int i = Math.max(0, r - 1); i <= Math.min(r + 1, m); i++) {
			for (int j = Math.max(c - 1, 0); j <= Math.min(c + 1, n); j++) {
				res += board[i][j] & 1;
			}
		}

		res -= board[r][c] & 1;
		return res;
	}

}
