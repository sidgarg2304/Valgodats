package com.vishal.interviews.facebook.hard;

import java.util.*;

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

		for (int i = 0; i < 9; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	}

	public static void solveSudoku(char[][] board) {

		if (board == null || board.length == 0) {
			return;
		}

		Set<String> seen = new HashSet<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.') {
					continue;
				}
				char number = board[i][j];
				if (!seen.add(number + " seen in row " + i) || !seen.add(number + " seen in col " + j)
						|| !seen.add(number + " seen in box " + i / 3 + "," + j / 3)) {
					return;			
				}
			}
		}
		backTrack(board, seen);
	}

	static boolean backTrack(char[][] board, Set<String> seen) {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {							
					continue;
				}

				for (char c = '1'; c <= '9'; c++) {
					if (!seen.contains(c + " seen in row " + i) && !seen.contains(c + " seen in col " + j)
							&& !seen.contains(c + " seen in box " + i / 3 + "," + j / 3)) {
						seen.add(c + " seen in row " + i);
						seen.add(c + " seen in col " + j);
						seen.add(c + " seen in box " + i / 3 + "," + j / 3);
						board[i][j] = c;
						if (backTrack(board, seen)) {
							return true;
						}
						board[i][j] = '.';
						seen.remove(c + " seen in row " + i);
						seen.remove(c + " seen in col " + j);
						seen.remove(c + " seen in box " + i / 3 + "," + j / 3);
					}
				}
                return false;
			}
		}
		return true;
	}

}
