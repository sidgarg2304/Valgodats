package com.vishal.interviews.uber.medium;

import java.util.*;

public class ValidSudoku {

	public static void main(String[] args) {

	}

	public boolean isValidSudoku(char[][] board) {

		if(board == null || board.length == 0) {
			return true;
		}
		
		Set<String> seen = new HashSet<>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == '.') {
					continue;
				}

				if (!seen.add(board[i][j] + " seen in row " + i) || !seen.add(board[i][j] + " seen in col " + j)
						|| !seen.add(board[i][j] + " seen in box " + i / 3 + "," + j / 3)) {
					return false;
				}
			}
		}
		return true;
	}

}
