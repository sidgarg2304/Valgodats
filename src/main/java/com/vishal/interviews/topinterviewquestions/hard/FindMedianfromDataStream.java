package com.vishal.interviews.topinterviewquestions.hard;

import java.util.*;

public class FindMedianfromDataStream {

	public static void main(String[] args) {

	}

	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;

	public FindMedianfromDataStream() {
		minHeap = new PriorityQueue<>();
		maxHeap = new PriorityQueue<>();
	}

	public void addNum(int val) {

		minHeap.offer(val);
		maxHeap.offer(minHeap.poll());

		if (maxHeap.size() > minHeap.size()) {
			minHeap.offer(maxHeap.poll());
		}
	}

	public double findMedian() {
		if (minHeap.size() > maxHeap.size()) {
			return minHeap.peek();
		} else {
			return (double) (minHeap.peek() + maxHeap.peek()) / 2;
		}
	}

}
