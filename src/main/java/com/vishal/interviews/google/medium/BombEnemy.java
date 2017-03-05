package com.vishal.interviews.google.medium;

/**
 * 361. Bomb Enemy
 * 
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0'
 * (the number zero), return the maximum enemies you can kill using one bomb.
 * The bomb kills all the enemies in the same row and column from the planted
 * point until it hits the wall since the wall is too strong to be destroyed.
 * Note that you can only put the bomb at an empty cell.
 * 
 * Example:
 * 
 * For the given grid
 * 
 * 0 E 0 0
 * 
 * E 0 W E
 * 
 * 0 E 0 0
 * 
 * return 3. (Placing a bomb at (1,1) kills 3 enemies)
 */
public class BombEnemy {

	public static void main(String[] args) {
	}

	/**
	 * Simple DP solution in Java
	 * 
	 * only need to store one killed enemies value for a row and an array of each
	 * column;
	 * 
	 * if current grid value is W, this means previous stored value becomes
	 * invalid, you need to recalculate.
	 * 
	 * @param grid
	 * @return
	 */
	public int maxKilledEnemies(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int max = 0;
		int row = 0;
		int[] col = new int[grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 'W')
					continue;
				if (j == 0 || grid[i][j - 1] == 'W') {
					row = killedEnemiesRow(grid, i, j);
				}
				if (i == 0 || grid[i - 1][j] == 'W') {
					col[j] = killedEnemiesCol(grid, i, j);
				}
				if (grid[i][j] == '0') {
					max = (row + col[j] > max) ? row + col[j] : max;
				}
			}

		}

		return max;
	}

	// calculate killed enemies for row i from column j
	private int killedEnemiesRow(char[][] grid, int i, int j) {
		int num = 0;
		while (j <= grid[0].length - 1 && grid[i][j] != 'W') {
			if (grid[i][j] == 'E')
				num++;
			j++;
		}
		return num;
	}

	// calculate killed enemies for column j from row i
	private int killedEnemiesCol(char[][] grid, int i, int j) {
		int num = 0;
		while (i <= grid.length - 1 && grid[i][j] != 'W') {
			if (grid[i][j] == 'E')
				num++;
			i++;
		}
		return num;
	}
	
	/**
	 * O(mn)
	 * @param grid
	 * @return
	 */
	public int maxKilledEnemiesSimple(char[][] grid) {
	    int rowNum = grid.length;
	    if (rowNum == 0) return 0;
	    int colNum = grid[0].length;

	    int[][] fromBottom = new int[rowNum][colNum];
	    int[][] fromRight = new int[rowNum][colNum];

	    for (int i = rowNum - 1; i >= 0; i--) {
	        for (int j = colNum - 1; j >= 0; j--) {
	            int enemy = grid[i][j] == 'E' ? 1 : 0;
	            if (grid[i][j] != 'W') {
	                fromBottom[i][j] = (i == rowNum - 1) ? enemy : fromBottom[i+1][j] + enemy;
	                fromRight[i][j] = (j == colNum - 1) ? enemy : fromRight[i][j+1] + enemy;
	            }
	            else {
	                fromBottom[i][j] = 0;
	                fromRight[i][j] = 0;
	            }
	        }
	    }

	    int[] fromTop = new int[colNum];
	    int[] fromLeft = new int[rowNum];
	    int max = 0;

	    for (int i = 0; i < rowNum; i++) {
	        for (int j = 0; j < colNum; j++) {
	            if (grid[i][j] != '0') {
	                fromTop[j] = grid[i][j] == 'W' ? 0 : fromTop[j] + 1;
	                fromLeft[i] = grid[i][j] == 'W' ? 0 : fromLeft[i] + 1;
	            }
	            else {
	                int num = fromTop[j] + fromLeft[i] + fromBottom[i][j] + fromRight[i][j];
	                max = Math.max(num, max);
	            }
	        }
	    }
	    return max;
	}
}

/**
 * Java straightforward solution DP O(mn) time and space
 * 
 * The code might be a little bit long and there should exist more elegant one.
 * However the idea of this very straightforward. We do simply two traversals.
 * One from upper left to bottom right, for each spot we compute enemies to its
 * left and up including itself. The other traversal is from bottom right to
 * upper left, we compute enemies to its right and down and in the same time we
 * add them up all to find the maxKill. Any suggestion to make it more concise?
 * 
 */
class BombEnemyStraight {
	public int maxKilledEnemies(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int m = grid.length, n = grid[0].length;
		Spot[][] spots = new Spot[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				spots[i][j] = new Spot();
				if (grid[i][j] == 'W') {
					continue;
				}
				spots[i][j].up = (i == 0 ? 0 : spots[i - 1][j].up) + (grid[i][j] == 'E' ? 1 : 0);
				spots[i][j].left = (j == 0 ? 0 : spots[i][j - 1].left) + (grid[i][j] == 'E' ? 1 : 0);
			}
		}

		int maxKill = 0;
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (grid[i][j] == 'W') {
					continue;
				}
				spots[i][j].bottom = (i == m - 1 ? 0 : spots[i + 1][j].bottom) + (grid[i][j] == 'E' ? 1 : 0);
				spots[i][j].right = (j == n - 1 ? 0 : spots[i][j + 1].right) + (grid[i][j] == 'E' ? 1 : 0);

				if (grid[i][j] == '0') {
					maxKill = Math.max(maxKill, spots[i][j].up + spots[i][j].left + spots[i][j].bottom + spots[i][j].right);
				}
			}
		}
		return maxKill;
	}
}

class Spot {
	int up; // enemies to its up including itself
	int left; // enemies to its left including itself
	int bottom;
	int right;
}
