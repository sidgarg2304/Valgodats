package com.vishal.algorithms.stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class StackAlgorithms {

	public static void main(String[] args) {

		// maxAreaOfHistogram(new int[] { 2, 1, 5, 6, 2, 3 });

		simplifyUnixPath("/home//foo/");
		testNumofFishesAlive();
	}

	public static void testNumofFishesAlive() {

		int[] fishHeights = { 4, 3, 2, 1, 5 };
		int[] fishDirection = { 0, 1, 0, 0, 0 };

		System.out.println("num of fishes alive " + numofFishesAlive(fishHeights, fishDirection));		

		fishDirection = new int[] { 1, 0, 1, 1, 1 };

		System.out.println("num of fishes alive " + numofFishesAlive(fishHeights, fishDirection));		
		fishHeights = new int[] { 4, 2, 3, 6, 1, 5 };
		fishDirection = new int[] { 1, 1, 1, 0, 0, 0 };

		System.out.println("num of fishes alive " + numofFishesAlive(fishHeights, fishDirection));		

	}

	/**
	 * | | | | | | | | | | | | | 0 1 2 3 4 5
	 * 
	 * @param heights
	 */
	public static void maxAreaOfHistogram(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int maxArea = Integer.MIN_VALUE;
		while (i < heights.length) {
			if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				int p = stack.pop();
				int h = heights[p];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				maxArea = Math.max(maxArea, (h * w));
			}
		}
		while (!stack.isEmpty()) {
			int p = stack.pop();
			int h = heights[p];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			maxArea = Math.max(maxArea, (h * w));
		}
		System.out.println("maxAreaOfHistogram " + Arrays.toString(heights) + " is " + maxArea);
	}

	/**
	 * Whenever you hit a valid directory, add it to the stack whenever you hit a
	 * ../, remove from the stack
	 * 
	 * @param path
	 */
	public static void simplifyUnixPath(String path) {

		while (path.length() > 0 && path.charAt(path.length() - 1) == '/') {
			path = path.substring(0, path.length() - 1);
		}

		Stack<String> stack = new Stack<>();
		int start = 0;
		for (int i = 1; i < path.length(); i++) {
			if (path.charAt(i) == '/') {
				String dir = path.substring(start, i);

				if (dir.equals("/.") || dir.equals("/")) {
					// do nothing
				} else if (dir.equals("/..")) {
					if (!stack.isEmpty()) {
						stack.pop();
					}
				} else {
					stack.push(dir);
				}

				start = i;
			} else if (i == path.length() - 1 && !path.substring(start).equals("/..")) {
				stack.push(path.substring(start));
			}
		}

		// reverse the stack for printing
		Stack<String> resultStack = new Stack<String>();
		while (!stack.isEmpty()) {
			resultStack.push(stack.pop());
		}

		StringBuilder res = new StringBuilder();
		while (!resultStack.isEmpty()) {
			res.append(resultStack.pop());
		}

		System.out.println(res.toString());
	}

	public static int numofFishesAlive(int[] fishHeights, int[] fishDirection) {

		Stack<Integer> upStreamFishHeights = new Stack<>();

		Stack<Integer> downStreamFishHeights = new Stack<>();
		for (int i = 0; i < fishHeights.length; i++) {

			if (fishDirection[i] == 1) {
				upStreamFishHeights.push(fishHeights[i]);
			} else {
				while (!upStreamFishHeights.isEmpty()) {
					if (upStreamFishHeights.peek() < fishHeights[i]) {
						upStreamFishHeights.pop();
					} else {
						break;
					}
				}
				// only if there are no more upstreams left, downstream would have
				// survived
				if (upStreamFishHeights.isEmpty()) {
					downStreamFishHeights.push(fishDirection[i]);
				}
			}
		}		
		return upStreamFishHeights.size() + downStreamFishHeights.size();

	}
	
	
}
