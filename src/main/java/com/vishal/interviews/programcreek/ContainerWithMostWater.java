package com.vishal.interviews.programcreek;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container and n is at least 2.
 *
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {

	}

	public int maxArea(int[] heights) {

		if (heights == null || heights.length == 0) {
			return 0;
		}
		int i = 0;
		int j = heights.length - 1;

		int res = 0;
		while (i < j) {
			int l = heights[i];
			int h = heights[i];

			if (l < h) {
				res = Math.max(res, (j - i) * l);
				i++;
			} else {
				res = Math.max(res, (j - i) * h);
				j--;
			}
		}

		return res;
	}

}
