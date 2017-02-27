package com.vishal.algorithms.slidingwindow;

import java.util.Arrays;
import java.util.LinkedList;

public class SlidingWindowAlgorithms {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 4, 2, 5, 3, 7, 9 }, 3)));
	}

	/**
	 * find max of every 3 elements when they come in sequence
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return new int[0];

		int[] result = new int[nums.length - k + 1];

		LinkedList<Integer> deque = new LinkedList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!deque.isEmpty() && deque.size() > k - 1)
				deque.poll();

			/**
			 * Remove all numbers smaller than queues first element  
			 */
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.removeLast();
			}

			deque.offer(i);

			if (i >= k - 1)
				result[i + 1 - k] = nums[deque.peek()];
		}

		return result;
	}

}
