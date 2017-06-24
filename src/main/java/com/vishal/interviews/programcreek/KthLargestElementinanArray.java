package com.vishal.interviews.programcreek;

import java.util.*;

public class KthLargestElementinanArray {

	public static void main(String[] args) {

	}

	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i : nums) {
			minHeap.offer(i);
			while (minHeap.size() > k) {
				minHeap.poll();
			}
		}

		return minHeap.peek();
	}

}
