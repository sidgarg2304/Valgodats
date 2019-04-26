package com.vishal.interviews.uber.medium;

public class WordSearch {

	public static void main(String[] args) {

	}

	public boolean exist(char[][] board, String word) {

		if (word == null || word.isEmpty()) {
			return true;
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					if (dfs(board, word, 0, i, j, new boolean[board.length][board[0].length])) {
						return true;
					}
				}
			}
		}
		return false;
	}

	boolean dfs(char[][] board, String word, int pos, int i, int j, boolean[][] visited) {
		if (pos == word.length()) {
			return true;
		}
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]
				|| board[i][j] != word.charAt(pos)) {
			return false;
		}

		visited[i][j] = true;
		boolean found = dfs(board, word, pos + 1, i + 1, j, visited) || dfs(board, word, pos + 1, i - 1, j, visited)
				|| dfs(board, word, pos + 1, i, j + 1, visited) || dfs(board, word, pos + 1, i, j-1, visited);			
		visited[i][j] = false;
		return found;
	}

}
