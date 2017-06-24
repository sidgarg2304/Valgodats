package com.vishal.interviews.programcreek.matrix;

import java.util.*;

public class ValidSudoku {

	public static void main(String[] args) {

	}

	public boolean isValidSudoku(char[][] board) {

		if (board == null || board.length == 0) {
			return false;
		}
		Set<String> seen = new HashSet<>();

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					continue;
				}

				char number = board[i][j];
				if (!seen.add(number + " seen in row " + i) || !seen.add(number + " seen in col " + j)
						|| !seen.add(number + " seen in box " + i / 3 + "-" + j / 3)) {
					return false;
				}
			}
		}

		return true;
	}

}
