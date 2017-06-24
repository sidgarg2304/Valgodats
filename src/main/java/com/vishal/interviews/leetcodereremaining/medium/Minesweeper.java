package com.vishal.interviews.leetcodereremaining.medium;

/**
 * 529. Minesweeper
 * 
 * Let's play the minesweeper game (Wikipedia, online game)!

You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to this revealed square, and finally 'X' represents a revealed mine.

Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the board after revealing this position according to the following rules:

If a mine ('M') is revealed, then the game is over - change it to 'X'.
If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
Return the board when no more squares will be revealed.
Example 1:
Input: 

[['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'M', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E']]

Click : [3,0]

Output: 

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]


Example 2:
Input: 

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

Click : [1,2]

Output: 

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'X', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]


 *
 */
public class Minesweeper {

	public static void main(String[] args) {

	}

	public char[][] updateBoard(char[][] board, int[] click) {
		int x = click[0];
		int y = click[1];

		if (board[x][y] == 'M') {
			board[x][y] = 'X';
			return board;
		}
		dfs(board, x, y);
		return board;
	}

	void dfs(char[][] board, int i, int j) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'E') {
			return;
		}

		int num = getNumOfMines(board, i, j);
		if (num == 0) {
			board[i][j] = 'B';
			for (int x = -1; x <= 1; x++) {
				for (int y = -1; y <= 1; y++) {
					dfs(board, i + x, j + y);
				}
			}
		} else {
			board[i][j] = (char) ('0' + num);
		}
	}

	int getNumOfMines(char[][] board, int i, int j) {
		int res = 0;

		for (int x = Math.max(0, i - 1); x <= Math.min(i + 1, board.length - 1); x++) {
			for (int y = Math.max(0, j - 1); y <= Math.min(j + 1, board[0].length - 1); y++) {
				if(board[x][y] == 'M' || board[x][y] == 'X'){
					res++;
				}
			}
		}

		return res;
	}

}
