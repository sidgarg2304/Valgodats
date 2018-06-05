package com.vishal.interviews.top100linkedquestions.hard;

import java.util.*;

public class MaximalRectangle {

	public static void main(String[] args) {

	}

	public int maximalRectangle(char[][] matrix) {

		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int max = 0;

		int[] dp = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '0') {
					dp[j] = 0;
				} else {
					dp[j] += 1;
				}
			}
			max = Math.max(max, maxAreaOfHistogram(dp));
		}
		return max;
	}

	int maxAreaOfHistogram(int[] heights) {
		if (heights == null || heights.length == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<>();

		int max = 0;
		int i = 0;
		while (i < heights.length) {
			if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				int h = heights[stack.pop()];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(max, h * w);
			}
		}

		while (!stack.isEmpty()) {
			int h = heights[stack.pop()];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(max, h * w);
		}
		return max;
	}

}
