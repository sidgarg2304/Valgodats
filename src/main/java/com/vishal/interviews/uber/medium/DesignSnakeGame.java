package com.vishal.interviews.uber.medium;

import java.util.*;

public class DesignSnakeGame {

	public static void main(String[] args) {

	}

	LinkedList<Point> snake;
	int f = 0;
	int[][] food;
	int rowLen;
	int colLen;

	public DesignSnakeGame(int width, int height, int[][] food) {
		snake = new LinkedList<>();
		this.food = food;
		rowLen = height;
		colLen = width;

		snake.add(new Point(0, 0));
	}

	/**
	 * Moves the snake.
	 * 
	 * @param direction
	 *           - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
	 * @return The game's score after the move. Return -1 if game over. Game over
	 *         when snake crosses the screen boundary or bites its body.
	 */
	public int move(String direction) {

		int x = snake.getFirst().x;
		int y = snake.getFirst().y;

		if ("R".equals(direction)) {
			y += 1;
		} else if ("L".equals(direction)) {
			y -= 1;
		} else if ("U".equals(direction)) {
			x -= 1;
		} else {
			x += 1;
		}

		if (x < 0 || y < 0 || x >= rowLen || y >= colLen) {
			return -1;
		}

		for (int i = 1; i < snake.size() - 1; i++) {
			if (snake.get(i).x == x && snake.get(i).y == y) {
				return -1;
			}
		}

		if (f < food.length && food[f][0] == x && food[f][1] == y) {
			f++;
		}
		
		snake.addFirst(new Point(x, y));
		
		while(snake.size() > f + 1) {
			snake.removeLast();
		}
		
		return f;
	}

	class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
