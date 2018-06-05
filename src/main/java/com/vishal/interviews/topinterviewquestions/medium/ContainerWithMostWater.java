package com.vishal.interviews.topinterviewquestions.medium;

public class ContainerWithMostWater {

	public static void main(String[] args) {

	}

	public int maxArea(int[] heights) {
		int i = 0;
		int j = heights.length - 1;

		int maxArea = 0;

		while (i < j) {
			int w = j - i;
			int h = Math.min(heights[i], heights[j]);
			int area = w * h;
			maxArea = Math.max(area, maxArea);
			if (heights[i] < heights[j]) {
				i++;
			} else {
				j--;
			}
		}
		return maxArea;
	}
}
