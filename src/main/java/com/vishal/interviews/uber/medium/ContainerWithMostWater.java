package com.vishal.interviews.uber.medium;

public class ContainerWithMostWater {

	public static void main(String[] args) {

	}

	public int maxArea(int[] height) {

		if(height == null || height.length <= 1) {
			return 0;
		}
		int l = 0;
		int r = height.length - 1;

		int maxArea = 0;
		while (l < r) {
			int curArea = Math.min(height[l], height[r]) * (r - l);
			maxArea = Math.max(maxArea, curArea);
			if (height[l] < height[r]) {
				l++;
			} else {
				r--;
			}
		}
		return maxArea;
	}

}
