package com.vishal.interviews.programcreek.matrix;

public class SudokuSolver {

	public static void main(String[] args) {

	}

	public void solveSudoku(char[][] board) {
		if (board == null || board.length == 0)
			return;
		backTrack(board);
	}

	boolean backTrack(char[][] board) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != '.') {
					continue;
				}

				for (char c = '1'; c <= '9'; c++) {
					if (isValid(board, i, j, c)) {
						board[i][j] = c;
						if (backTrack(board)) {
							return true;
						}
						board[i][j] = '.';
					}
				}
				return false;
			}
		}
		return true;
	}

	boolean isValid(char[][] board, int row, int col, char c) {
		for (int i = 0; i < 9; i++) {
			if (board[row][i] != '.' && board[row][i] == c) {
				return false;
			}

			if (board[i][col] != '.' && board[i][col] == c) {
				return false;
			}
			
			int boxX = 3 * (row / 3) + i / 3;
			int boxY = 3 * (col / 3) + i % 3;
			if(board[boxX][boxY] != '.' && board[boxX][boxY] == c){
				return false;
			}
		}
		return true;
	}
}
