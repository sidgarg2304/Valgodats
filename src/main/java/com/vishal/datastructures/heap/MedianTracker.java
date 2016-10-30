package com.vishal.datastructures.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianTracker {

	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;

	public MedianTracker() {
		minHeap = new PriorityQueue<Integer>();
		maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
	}

	public void addRandomValue(int randomValue) {
		if (minHeap.size() == maxHeap.size()) {
			if (minHeap.peek() != null && minHeap.peek().compareTo(randomValue) == -1) {
				maxHeap.offer(minHeap.poll());
				minHeap.offer(randomValue);
			} else {
				maxHeap.offer(randomValue);
			}
		} else {
			if (maxHeap.peek().compareTo(randomValue) == 1) {
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(randomValue);
			} else {
				minHeap.offer(randomValue);
			}
		}
	}

	public double getMedian() {
		if (minHeap.size() == maxHeap.size()) {
			return (double) ((minHeap.peek() + minHeap.peek()) / 2);
		} else {
			return maxHeap.peek();
		}
	}

}
