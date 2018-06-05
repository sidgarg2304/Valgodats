package com.vishal.interviews.facebook.careercup;

/**
 * Given a 2D character array of size NxN. Find if there is a path from the cell
 * 'R' to the cell 'T'. You can go left, right, up, down from a cell and you
 * cannot pass through any cell marked with 'X'.
 * 
 * Example input: X__R_X X_XXX_ ______ _XX_XX XT__X_
 * 
 * Output: true
 */
public class HasPathFromCellRtoCellT {

	public static void main(String[] args) {

	}

	static boolean hasPath(char[][] matrix) {

		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 'R') {
					if (dfs(matrix, i, j, visited)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	static boolean dfs(char[][] matrix, int i, int j, boolean[][] visited) {

		if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] == 'X' || visited[i][j]) {
			return false;
		}

		if (matrix[i][j] == 'T') {
			return true;
		}

		visited[i][j] = true;

		boolean canReach = dfs(matrix, i + 1, j, visited) || dfs(matrix, i - 1, j, visited)
				|| dfs(matrix, i, j - 1, visited) || dfs(matrix, i, j + 1, visited);

		visited[i][j] = false;

		return canReach;
	}

}
