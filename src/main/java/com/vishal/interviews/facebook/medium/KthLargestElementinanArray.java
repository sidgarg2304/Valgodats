package com.vishal.interviews.facebook.medium;

import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array
 * 
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * For example, Given [3,2,1,5,6,4] and k = 2, return 5.
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 * 
 */
public class KthLargestElementinanArray {

	public static void main(String[] args) {

	}

	public static int findKthLargest(int[] nums, int k) {

		if (nums == null || nums.length == 0) {
			return -1;
		}

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i = 0; i < nums.length; i++) {
			minHeap.offer(nums[i]);

			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}
		return minHeap.peek();
	}

}
