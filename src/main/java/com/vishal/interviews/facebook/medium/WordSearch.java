package com.vishal.interviews.facebook.medium;

/**
 * 79. Word Search
 * 
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 *
 */
public class WordSearch {

	public static void main(String[] args) {

	}

	public static boolean exist(char[][] board, String word) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {

					boolean[][] visited = new boolean[board.length][board[0].length];
					if (dfs(word, board, 0, i, j, visited)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	static boolean dfs(String word, char[][] board, int p, int i, int j, boolean[][] visited) {

		if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || visited[i][j]) {
			return false;
		}


		if (word.charAt(p) != board[i][j]) {
			return false;
		}

		if (p == word.length() - 1) {
			return true;
		}

		visited[i][j] = true;

		if (dfs(word, board, p + 1, i + 1, j, visited) || dfs(word, board, p + 1, i - 1, j, visited)
				|| dfs(word, board, p + 1, i, j + 1, visited) || dfs(word, board, p + 1, i, j - 1, visited)) {
			return true;
		}

		visited[i][j] = false;
		return false;

	}

}
