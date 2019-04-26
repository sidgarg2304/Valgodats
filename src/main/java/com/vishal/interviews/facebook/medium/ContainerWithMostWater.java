package com.vishal.interviews.facebook.medium;

public class ContainerWithMostWater {

	public static void main(String[] args) {

	}

	public int maxArea(int[] height) {

		int maxArea = 0;

		int i = 0;
		int j = height.length - 1;

		while (i < j) {
			int l = j - i;
			int w = Math.min(height[i], height[j]);
			maxArea = Math.max(maxArea, l * w);
			if (height[i] < height[j]) {
				i++;
			} else {
				j--;
			}

		}
		return maxArea;
	}

}
