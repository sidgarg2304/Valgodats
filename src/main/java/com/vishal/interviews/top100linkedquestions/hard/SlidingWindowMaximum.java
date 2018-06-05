package com.vishal.interviews.top100linkedquestions.hard;

import java.util.*;

public class SlidingWindowMaximum {

	public static void main(String[] args) {

	}

	public int[] maxSlidingWindow(int[] nums, int k) {

		if (nums == null || nums.length == 0) {
			return new int[] {};
		}
		int[] res = new int[nums.length - k + 1];

		LinkedList<Integer> queue = new LinkedList<>();
		int r = 0;
		for (int i = 0; i < nums.length; i++) {

			while (!queue.isEmpty() && queue.getFirst() == i - k) {
				queue.removeFirst();
			}
			
			while(!queue.isEmpty() && nums[queue.getLast()] < nums[i]){
				queue.removeLast();
			}
			
			queue.addLast(i);

			if (i >= k - 1) {
				res[r++] = nums[queue.peek()];
			}
		}
		
		return res;
	}

}
