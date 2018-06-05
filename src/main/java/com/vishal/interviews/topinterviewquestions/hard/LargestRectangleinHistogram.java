package com.vishal.interviews.topinterviewquestions.hard;

import java.util.*;

public class LargestRectangleinHistogram {

	public static void main(String[] args) {

	}

	public int largestRectangleArea(int[] heights) {

		if (heights == null || heights.length == 0) {
			return 0;
		}
		
		Stack<Integer> stack = new Stack<>();
		int res = Integer.MIN_VALUE;

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
