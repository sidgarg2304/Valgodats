package com.vishal.interviews.top100linkedquestions.hard;

public class TrappingRainWater {

	public static void main(String[] args) {

	}

	public int trap(int[] height) {

		if (height == null || height.length <= 1) {
			return 0;
		}
		int res = 0;

		int[] left = new int[height.length];
		left[0] = height[0];
		for (int i = 1; i < height.length; i++) {
			left[i] = Math.max(left[i - 1], height[i]);
		}

		int[] right = new int[height.length];
		right[right.length - 1] = height[height.length - 1];
		for (int i = height.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], height[i + 1]);
		}
		
		for(int i = 0; i< height.length; i++){
			int min = Math.min(left[i], right[i]);
			res += min - height[i];
		}
		return res;
	}

}
