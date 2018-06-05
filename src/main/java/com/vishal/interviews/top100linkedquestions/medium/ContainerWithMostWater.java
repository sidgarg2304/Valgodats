package com.vishal.interviews.top100linkedquestions.medium;

public class ContainerWithMostWater {

	public static void main(String[] args) {

	}

	public int maxArea(int[] heights) {

		if (heights == null || heights.length == 0) {
			return 0;
		}

		int i = 0;
		int j = heights.length - 1;
		int max = 0;
		while (i < j) {
			int w = j - i;
			int l = Math.min(heights[i], heights[j]);
			max = Math.max(max, l * w);
			if (heights[i] < heights[j]) {
				i++;
			} else {
				j--;
			}
		}

		return max;
	}
}
