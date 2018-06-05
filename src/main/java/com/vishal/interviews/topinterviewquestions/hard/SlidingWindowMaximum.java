package com.vishal.interviews.topinterviewquestions.hard;

import java.util.*;

public class SlidingWindowMaximum {

	public static void main(String[] args) {

	}

	public int[] maxSlidingWindow(int[] nums, int k) {

		if (nums == null || nums.length <= k - 1) {
			return null;
		}
		int[] res = new int[nums.length - k + 1];

		int r = 0;
		LinkedList<Integer> queue = new LinkedList<>();

		for (int i = 0; i < nums.length; i++) {
			
			
			while(!queue.isEmpty() && queue.peekFirst() == i-k){
				queue.removeFirst();
			}
			
			while(!queue.isEmpty() && nums[queue.getLast()] < nums[i]){
				queue.removeLast();
			}
			
			queue.addLast(i);
			
			if (i >= k - 1) {
				res[r++] = queue.getFirst();
			}
		}
		
		return res;
	}

}
