package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

public class KthLargestElementinanArray {

	public static void main(String[] args) {

	}

	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length < k) {
			return -1;
		}

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i = 0; i < nums.length; i++) {
			minHeap.offer(nums[i]);
			if(minHeap.size() > k){
				minHeap.poll();
			}
		}
		return minHeap.poll();
	}
}
