package com.vishal.interviews.facebook.hard;

import java.util.PriorityQueue;

public class FindMedianfromDataStream {

	public static void main(String[] args) {

	}

	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;

	/** initialize your data structure here. */
	public FindMedianfromDataStream() {
		minHeap = new PriorityQueue<Integer>();
		maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
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
	public void addNum(int num) {

		if (maxHeap.isEmpty() && minHeap.isEmpty()) {
			maxHeap.offer(num);
			return;
		}

		if (num < findMedian()) {
			maxHeap.offer(num);
		} else {
			minHeap.offer(num);
		}

		if (maxHeap.size() < minHeap.size()) {
			maxHeap.offer(minHeap.poll());
		}
		
		if(maxHeap.size() - minHeap.size() > 1) {
			minHeap.offer(maxHeap.poll());
		}
	}

	public double findMedian() {

		if (maxHeap.isEmpty() && minHeap.isEmpty()) {
			return -1;
		}
		if (maxHeap.size() > minHeap.size()) {
			return maxHeap.peek();
		}

		return (maxHeap.peek() + minHeap.peek()) / 2.0;
	}

}
