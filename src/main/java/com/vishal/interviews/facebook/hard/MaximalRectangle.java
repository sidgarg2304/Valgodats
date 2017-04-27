package com.vishal.interviews.facebook.hard;

import java.util.*;

/**
 * 85. Maximal Rectangle
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6.
 *
 */
public class MaximalRectangle {

	public static void main(String[] args) {

//		System.out.println(maxAreaOfHistogram(new int[] { 2, 1, 5, 6, 2, 3 }));

		char[][] matrix = new char[4][5];
		matrix[0] = new char[] { '1', '0', '1', '0', '0' };
		matrix[1] = new char[] { '1', '0', '1', '1', '1' };
		matrix[2] = new char[] { '1', '1', '1', '1', '1' };
		matrix[3] = new char[] { '1', '0', '0', '1', '0' };

		char[][] matrix1 = new char[2][2];
		matrix1[1] = new char[] { '1', '0' };
		matrix1[0] = new char[] { '0', '1' };
		System.out.println(maximalRectangle(matrix));
	}

	public static int maximalRectangle(char[][] matrix) {
		
		if(matrix == null || matrix.length == 0){
			return 0;
		}

		int[] dp = new int[matrix[0].length];

		int res = Integer.MIN_VALUE;

		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix[0].length; j++) {
				int curVal = matrix[i][j] -'0';
				if (curVal == 1) {
					dp[j] += curVal;
				} else {
					dp[j] = 0;
				}				
			}			
			res = Math.max(res, maxAreaOfHistogram(dp));
		}

		return res;

	}

	static int maxAreaOfHistogram(int[] heights) {

		Stack<Integer> stack = new Stack<>();

		int max = Integer.MIN_VALUE;

		int i = 0;
		while (i < heights.length) {
			if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				int p = stack.pop();
				int h = heights[p];
				int w = stack.isEmpty() ? i : (i - stack.peek() - 1);
				max = Math.max(max, h * w);
			}
		}

		while (!stack.isEmpty()) {
			int p = stack.pop();
			int h = heights[p];
			int w = stack.isEmpty() ? i : (i - stack.peek() - 1);
			max = Math.max(max, h * w);
		}

		return max;

	}

}
