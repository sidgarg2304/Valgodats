package com.vishal.interviews.google.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.BiPredicate;

/**
 * 490. The Maze
 * 
 * There is a ball in a maze with empty spaces and walls. The ball can go
 * through empty spaces by rolling up, down, left or right, but it won't stop
 * rolling until hitting a wall. When the ball stops, it could choose the next
 * direction.
 * 
 * Given the ball's start position, the destination and the maze, determine
 * whether the ball could stop at the destination.
 * 
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means
 * the empty space. You may assume that the borders of the maze are all walls.
 * The start and destination coordinates are represented by row and column
 * indexes.
 * 
 * Example 1
 * 
 * Input 1: a maze represented by a 2D array
 * 
 * 0 0 1 0 0
 * 
 * 0 0 0 0 0
 * 
 * 0 0 0 1 0
 * 
 * 1 1 0 1 1
 * 
 * 0 0 0 0 0
 * 
 * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 * 
 * Input 3: destination coordinate (rowDest, colDest) = (4, 4)
 * 
 * Output: true
 * 
 * Explanation: One possible way is : left -> down -> left -> down -> right ->
 * down -> right.
 * 
 * 
 * Example 2
 * 
 * Input 1: a maze represented by a 2D array
 * 
 * 0 0 1 0 0
 * 
 * 0 0 0 0 0
 * 
 * 0 0 0 1 0
 * 
 * 1 1 0 1 1
 * 
 * 0 0 0 0 0
 * 
 * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 * 
 * Input 3: destination coordinate (rowDest, colDest) = (3, 2)
 * 
 * Output: false
 * 
 * Explanation: There is no way for the ball to stop at the destination.
 * 
 * 
 * Note:
 * 
 * 1. There is only one ball and one destination in the maze.
 * 
 * 2. Both the ball and the destination exist on an empty space, and they will
 * not be at the same position initially.
 * 
 * 3. The given maze does not contain border (like the red rectangle in the
 * example pictures), but you could assume the border of the maze are all walls.
 * 
 * 4. The maze contains at least 2 empty spaces, and both the width and height
 * of the maze won't exceed 100.
 */
public class TheMaze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/**
 * Easy-understanding Java bfs solution. Solution of The Maze II:
 * https://discuss.leetcode.com/topic/77472/similar-to-the-maze-easy-
 * understanding-java-bfs-solution
 * 
 * Solution of The Maze III:
 * https://discuss.leetcode.com/topic/77474/similar-to-the-maze-ii-easy-
 * understanding-java-bfs-solution
 * 
 *
 */
class SolutionUsingBFS {
	class Point {
		int x, y;

		public Point(int _x, int _y) {
			x = _x;
			y = _y;
		}
	}

	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		int m = maze.length, n = maze[0].length;
		if (start[0] == destination[0] && start[1] == destination[1])
			return true;
		int[][] dir = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		boolean[][] visited = new boolean[m][n];
		LinkedList<Point> list = new LinkedList<>();
		visited[start[0]][start[1]] = true;
		list.offer(new Point(start[0], start[1]));
		while (!list.isEmpty()) {
			Point p = list.poll();
			int x = p.x, y = p.y;
			for (int i = 0; i < 4; i++) {
				int xx = x, yy = y;
				while (xx >= 0 && xx < m && yy >= 0 && yy < n && maze[xx][yy] == 0) {
					xx += dir[i][0];
					yy += dir[i][1];
				}
				xx -= dir[i][0];
				yy -= dir[i][1];
				if (visited[xx][yy])
					continue;
				visited[xx][yy] = true;
				if (xx == destination[0] && yy == destination[1])
					return true;
				list.offer(new Point(xx, yy));
			}
		}
		return false;

	}
}

/**
 * Simple Java DFS with comments
 * 
 * Search in the four possible directions when coming to a stopping point (i.e.
 * a new starting point).
 * 
 * Keep track of places that you already started at in case you roll back to
 * that point.
 *
 */
class SolutionDFS {
	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		boolean[][] startedHere = new boolean[maze.length][maze[0].length]; // mark
																								  // visited
																								  // starting
																								  // points
		return dfs(maze, startedHere, start, destination);
	}

	private boolean dfs(int[][] maze, boolean[][] startedHere, int[] start, int[] destination) {
		if (startedHere[start[0]][start[1]])
			return false;
		if (Arrays.equals(start, destination))
			return true;

		startedHere[start[0]][start[1]] = true; // in case we roll back to a point
															 // we already started at

		BiPredicate<Integer, Integer> roll = (rowInc, colInc) -> {
			int row = start[0], col = start[1]; // init new start row and col
			while (canRoll(maze, row + rowInc, col + colInc)) {
				row += rowInc;
				col += colInc;
			}
			return dfs(maze, startedHere, new int[] { row, col }, destination); // pass
																									  // in
																									  // new
																									  // start
																									  // to
																									  // dfs
		};

		if (roll.test(1, 0))
			return true; // roll up
		if (roll.test(0, 1))
			return true; // roll right
		if (roll.test(-1, 0))
			return true; // roll down
		if (roll.test(0, -1))
			return true; // roll left

		return false; // return false if no paths led to destination
	}

	private boolean canRoll(int[][] maze, int row, int col) {
		if (row >= maze.length || row < 0 || col >= maze[0].length || col < 0)
			return false; // stop at borders
		return maze[row][col] != 1; // stop at walls (1 -> wall)
	}
}
