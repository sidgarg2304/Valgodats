package com.vishal.interviews.programcreek.matrix;

public class WordSearch {

	public static void main(String[] args) {

	}

	public boolean exist(char[][] board, String word) {

		if (board == null || board.length == 0 || word == null || word.length() == 0) {
			return false;
		}

		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {					
					if (dfs(board, i, j, word, 0, visited)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	boolean dfs(char[][] board, int i, int j, String word, int p, boolean[][] visited) {

		if (p == word.length()) {
			return true;
		}
		
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(p)) {
			return false;
		}
		

		visited[i][j] = true;
		boolean found = dfs(board, i - 1, j, word, p + 1, visited) || dfs(board, i + 1, j, word, p + 1, visited)
				|| dfs(board, i, j - 1, word, p + 1, visited) || dfs(board, i, j + 1, word, p + 1, visited);

		visited[i][j] = false;
		
		return found;

	}

}
