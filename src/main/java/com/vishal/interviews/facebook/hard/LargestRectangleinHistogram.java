package com.vishal.interviews.facebook.hard;

import java.util.Stack;

public class LargestRectangleinHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int largestRectangleArea(int[] heights) {

		if (heights == null || heights.length == 0) {
			return 0;
		}
		int res = 0;
		Stack<Integer> stack = new Stack<>();

		int i = 0;
		while (i < heights.length) {
			if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				int h = heights[stack.pop()];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				res = Math.max(res, h * w);
			}
		}

		while (!stack.isEmpty()) {
			int h = heights[stack.pop()];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			res = Math.max(res, h * w);
		}
		return res;
	}

}
