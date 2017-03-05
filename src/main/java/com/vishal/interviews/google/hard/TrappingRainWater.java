package com.vishal.interviews.google.hard;

import java.util.Stack;

/**
 * 42. Trapping Rain Water
 * 
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example,
 * 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In
 * this case, 6 units of rain water (blue section) are being trapped. Thanks
 * Marcos for contributing this image!
 */
public class TrappingRainWater {

	public static void main(String[] args) {

	}

	/**
	 * Keep track of the maximum height from both forward directions backward
	 * directions, call them leftmax and rightmax.
	 * 
	 * @param A
	 * @return
	 */
	public int trapShort(int[] A) {
		int a = 0;
		int b = A.length - 1;
		int max = 0;
		int leftmax = 0;
		int rightmax = 0;
		while (a <= b) {
			leftmax = Math.max(leftmax, A[a]);
			rightmax = Math.max(rightmax, A[b]);
			if (leftmax < rightmax) {
				max += (leftmax - A[a]); // leftmax is smaller than rightmax, so the
												 // (leftmax-A[a]) water can be stored
				a++;
			} else {
				max += (rightmax - A[b]);
				b--;
			}
		}
		return max;
	}

	/**
	 * A stack based solution for reference, inspired by Histogram
	 * 
	 * Indeed this question can be solved in one pass and O(1) space, but it's
	 * probably hard to come up with in a short interview. If you have read the
	 * stack O(n) solution for Largest Rectangle in Histogram, you will find this
	 * solution is very very similar.
	 * 
	 * The main idea is : if we want to find out how much water on a bar(bot), we
	 * need to find out the left larger bar's index (il), and right larger bar's
	 * index(ir), so that the water is (min(A[il],A[ir])-A[bot])*(ir-il-1), use
	 * min since only the lower boundary can hold water, and we also need to
	 * handle the edge case that there is no il.
	 * 
	 * To implement this we use a stack that store the indices with decreasing
	 * bar height, once we find a bar who's height is larger, then let the top of
	 * the stack be bot, the cur bar is ir, and the previous bar is il.
	 * 
	 * @param A
	 * @return
	 */
	public int trapStackBased(int[] A) {
		if (A == null)
			return 0;
		Stack<Integer> s = new Stack<Integer>();
		int i = 0, maxWater = 0, maxBotWater = 0;
		while (i < A.length) {
			if (s.isEmpty() || A[i] <= A[s.peek()]) {
				s.push(i++);
			} else {
				int bot = s.pop();
				maxBotWater = s.isEmpty() ? // empty means no il
						0 : (Math.min(A[s.peek()], A[i]) - A[bot]) * (i - s.peek() - 1);
				maxWater += maxBotWater;
			}
		}
		return maxWater;
	}

	/**
	 * Sharing my Java code: O(n) time, O(1) space
	 * 
	 * Traverse one pass with two pointers, from two sides to the middle.
	 * 
	 * 
	 * @param A
	 * @return
	 */
	public int trapConstSpace(int[] A) {
		if (A.length < 3)
			return 0;

		int ans = 0;
		int l = 0, r = A.length - 1;

		// find the left and right edge which can hold water
		while (l < r && A[l] <= A[l + 1])
			l++;
		while (l < r && A[r] <= A[r - 1])
			r--;

		while (l < r) {
			int left = A[l];
			int right = A[r];
			if (left <= right) {
				// add volum until an edge larger than the left edge
				while (l < r && left >= A[++l]) {
					ans += left - A[l];
				}
			} else {
				// add volum until an edge larger than the right volum
				while (l < r && A[--r] <= right) {
					ans += right - A[r];
				}
			}
		}
		return ans;
	}
}
