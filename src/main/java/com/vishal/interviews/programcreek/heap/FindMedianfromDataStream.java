package com.vishal.interviews.programcreek.heap;

import java.util.*;

public class FindMedianfromDataStream {

	public static void main(String[] args) {

	}

	PriorityQueue<Integer> maxHeap;// lower half
	PriorityQueue<Integer> minHeap;// higher half

	public FindMedianfromDataStream() {
		maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		minHeap = new PriorityQueue<Integer>();
	}

	public void addNum(int num) {

		maxHeap.offer(num);
		minHeap.offer(maxHeap.poll());

		if (maxHeap.size() < minHeap.size()) {
			maxHeap.offer(minHeap.poll());
		}

	}

	double median() {
		if (maxHeap.size() > minHeap.size()) {
			return (double) maxHeap.peek();
		} else {
			return (double) (minHeap.peek() + maxHeap.peek()) / 2.0;
		}
	}

}
