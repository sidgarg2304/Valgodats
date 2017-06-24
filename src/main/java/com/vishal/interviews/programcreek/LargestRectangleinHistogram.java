package com.vishal.interviews.programcreek;

import java.util.*;

/**
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example, given height = [2,1,5,6,2,3], return 10.
 *
 */
public class LargestRectangleinHistogram {

	public static void main(String[] args) {

	}

	public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<>();

		int res = 0;
		int i = 0;
		while (i < height.length) {
			if (stack.isEmpty() || height[i] > height[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				int h = height[stack.pop()];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				res = Math.max(res, h * w);
			}
		}
		
		while(!stack.isEmpty()){
			int h = height[stack.pop()];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			res = Math.max(res, h * w);
		}

		return res;
	}
}
