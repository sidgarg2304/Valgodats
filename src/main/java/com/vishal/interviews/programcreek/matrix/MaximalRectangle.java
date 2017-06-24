package com.vishal.interviews.programcreek.matrix;

import java.util.*;

public class MaximalRectangle {

	public static void main(String[] args) {

	}

	public int maximalRectangle(char[][] matrix) {

		if (matrix == null || matrix.length == 0) {
			return 0;
		}

		int maxArea = Integer.MIN_VALUE;
		int[] heights = new int[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] - '0' == 0) {
					heights[j] = 0;
				} else {
					heights[j] += matrix[i][j] - '0';
				}
			}
			maxArea = Math.max(maxArea, largestAreaInHistogram(heights));
		}

		return maxArea;
	}

	public int largestAreaInHistogram(int[] heights) {
		Stack<Integer> stack = new Stack<>();

		int maxArea = Integer.MIN_VALUE;
		int i = 0;
		while (i < heights.length) {
			if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
				stack.push(i);
			} else {
				int p = stack.pop();
				int h = heights[p];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;

				maxArea = Math.max(maxArea, (h * w));
			}
		}

		while (stack.isEmpty()) {
			int p = stack.pop();
			int h = heights[p];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;

			maxArea = Math.max(maxArea, (h * w));
		}

		return maxArea;
	}
}
