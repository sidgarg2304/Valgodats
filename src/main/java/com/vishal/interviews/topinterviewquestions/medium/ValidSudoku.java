package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

public class ValidSudoku {

	public static void main(String[] args) {

	}

	public boolean isValidSudoku(char[][] board) {

		if (board == null || board.length == 0) {
			return true;
		}

		Set<String> seen = new HashSet<>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				char c = board[i][j];
				if (c == '.') {
					continue;
				}

				if (!seen.add(c + " seen in the row " + i) || !seen.add(c + " seen in the row " + j)
						|| !seen.add(c + " seen in the box " + i)) {
					return false;
				}

			}
		}
		return true;
	}

}
