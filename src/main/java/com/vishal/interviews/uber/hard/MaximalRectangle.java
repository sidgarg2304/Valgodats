package com.vishal.interviews.uber.hard;

import java.util.*;

public class MaximalRectangle {

	public static void main(String[] args) {

	}

	public int maximalRectangle(char[][] matrix) {

		if (matrix == null || matrix.length == 0) {
			return 0;
		}

		int[] heights = new int[matrix[0].length];
		int res = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '0') {
					heights[j] = 0;
				} else {
					heights[j] += 1;
				}
			}
			res = Math.max(res, largestAreaInHistogram(heights));
		}
		return res;
	}

	int largestAreaInHistogram(int[] heights) {

		int res = 0;
		Stack<Integer> stack = new Stack<>();

		int i = 0;
		while (i < heights.length) {
			if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				int h = stack.pop();
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				res = Math.max(res, h * w);
			}
		}
		
		while(!stack.isEmpty()) {
			int h = stack.pop();
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			res = Math.max(res, h * w);
		}
		
		return res;

	}

}
