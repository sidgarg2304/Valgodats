package com.vishal.interviews.top100linkedquestions.medium;

public class WordSearch {

	public static void main(String[] args) {

	}

	public boolean exist(char[][] board, String word) {
		boolean[][] visited = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (word.charAt(0) == board[i][j]) {
					if (dfs(board, i, j, 0, word, visited)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	boolean dfs(char[][] board, int i, int j, int p, String word, boolean[][] visited) {
		if (p == word.length()) {
			return true;
		}

		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || word.charAt(p) != board[i][j]
				|| visited[i][j]) {
			return false;
		}

		visited[i][j] = true;
		boolean found = dfs(board, i - 1, j, p + 1, word, visited) || dfs(board, i + 1, j, p + 1, word, visited)
				|| dfs(board, i, j - 1, p + 1, word, visited) || dfs(board, i, j + 1, p + 1, word, visited);
		visited[i][j] = false;
		return found;
	}

}
