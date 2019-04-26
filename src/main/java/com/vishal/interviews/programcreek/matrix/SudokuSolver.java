package com.vishal.interviews.programcreek.matrix;

import java.util.Arrays;

public class SudokuSolver {

	public static void main(String[] args) {
		char[][] board = new char[9][9];

		// ["5","3",".",".","7",".",".",".","."],
		// ["6",".",".","1","9","5",".",".","."],
		// [".","9","8",".",".",".",".","6","."],
		// ["8",".",".",".","6",".",".",".","3"],
		// ["4",".",".","8",".","3",".",".","1"],
		// ["7",".",".",".","2",".",".",".","6"],
		// [".","6",".",".",".",".","2","8","."],
		// [".",".",".","4","1","9",".",".","5"],
		// [".",".",".",".","8",".",".","7","9"]]

		board[0] = new char[] { '5', '3', '.', '.', '7', '.', '.', '.', '.' };
		board[1] = new char[] { '6', '.', '.', '1', '9', '5', '.', '.', '.' };
		board[2] = new char[] { '.', '9', '8', '.', '.', '.', '.', '6', '.' };
		board[3] = new char[] { '8', '.', '.', '.', '6', '.', '.', '.', '3' };
		board[4] = new char[] { '4', '.', '.', '8', '.', '3', '.', '.', '1' };
		board[5] = new char[] { '7', '.', '.', '.', '2', '.', '.', '.', '6' };
		board[6] = new char[] { '.', '6', '.', '.', '.', '.', '2', '8', '.' };
		board[7] = new char[] { '.', '.', '.', '4', '1', '9', '.', '.', '5' };
		board[8] = new char[] { '.', '.', '.', '.', '8', '.', '.', '7', '9' };
		
		
		solveSudoku(board);
		
		for(int i = 0; i< 9; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	}

	public static void solveSudoku(char[][] board) {
		if (board == null || board.length == 0)
			return;
		backTrack(board);
	}

	static boolean backTrack(char[][] board) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != '.') {
					continue;
				}

				for (char c = '1'; c <= '9'; c++) {
					if (isValid(board, i, j, c)) {
						System.out.println("adding " + c + " in board[" + i + "][" + j + "]");
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

	static boolean isValid(char[][] board, int row, int col, char c) {
		for (int i = 0; i < 9; i++) {
			if (board[row][i] == c) {
				return false;
			}

			if (board[i][col] == c) {
				return false;
			}
			
			int boxX = 3 * (row / 3) + i / 3;
			int boxY = 3 * (col / 3) + i % 3;
			if(board[boxX][boxY] == c){
				return false;
			}
		}
		return true;
	}
}
