package com.vishal.interviews.topinterviewquestions.medium;

public class WordSearch {

	public static void main(String[] args) {

	}

	public boolean exist(char[][] board, String word) {

		boolean[][] visited = new boolean[board.length][board[0].length];
		char f = word.charAt(0);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == f) {
					boolean found = dfs(board, word, i, j, 0, visited);
					if (found) {
						return true;
					}
				}
			}
		}
		return false;
	}

	boolean dfs(char[][] board, String word, int i, int j, int p, boolean[][] visited) {
		if (p == word.length()) {
			return true;
		}

		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(p)) {
			return false;
		}

		visited[i][j] = true;

		boolean found = dfs(board, word, i - 1, j, p + 1, visited) || dfs(board, word, i + 1, j, p + 1, visited)
				|| dfs(board, word, i, j - 1, p + 1, visited) || dfs(board, word, i, j + 1, p + 1, visited);
		visited[i][j] = false;

		return found;
	}

}
