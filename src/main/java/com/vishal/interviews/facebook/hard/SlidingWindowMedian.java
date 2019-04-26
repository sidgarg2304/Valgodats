package com.vishal.interviews.facebook.hard;

import java.util.PriorityQueue;

public class SlidingWindowMedian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * maxHeap contains left part of the median elements
	 * minHeap contains right part of the median elements
	 * Assume we have 1 2 3 4 5
	 * 	maxHeap contains -> 1 2 3
	 * 	minHeap contains -> 4 5
	 * 	So the median is 3
	 * 
	 * Now, if we get a value less than median, it means it has to go to the left part of the elements
	 * Similarly, if we get a value more than median, it means it has to go to the right part of the elements
	 * 
	 *  Now we have to adjust sizes of the heaps as we decided to maintain maxheap with 1 greater element than minheap.
	 * 
	 * @param num
	 */
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b.compareTo(a));

	public double[] medianSlidingWindow(int[] nums, int k) {

		double[] res = new double[nums.length - k + 1];

		for (int i = 0; i <= nums.length; i++) {
			if (i >= k) {
				res[i - k] = getMedian();
				remove(nums[i - k]);
			}

			if (i < nums.length) {
				add(nums[i]);
			}
		}
		return res;
	}

	void add(int val) {

		if(val <= getMedian()) {
			maxHeap.offer(val);
		} else {
			minHeap.offer(val);
		}
		
		updateHeaps();
	}

	void remove(int val) {
		if(val <= getMedian()) {
			maxHeap.remove(val);
		} else {
			minHeap.remove(val);
		}
		
		updateHeaps();
	}

	void updateHeaps() {
		if (minHeap.size() > maxHeap.size()) {
			maxHeap.offer(minHeap.poll());
		}

		if (maxHeap.size() - minHeap.size() > 1) {
			minHeap.offer(maxHeap.poll());
		}
	}

	double getMedian() {

		if (minHeap.size() == 0 && maxHeap.size() == 0) {
			return 0;
		}

		if (minHeap.size() == maxHeap.size()) {
			return ((double)maxHeap.peek() + (double)minHeap.peek()) / 2.0;
		}

		return maxHeap.peek();
	}
}
