package com.vishal.interviews.uber.hard;

import java.util.*;

public class FindMedianfromDataStream {

	public static void main(String[] args) {

	}

	PriorityQueue<Integer> minheap;
	PriorityQueue<Integer> maxheap;

	/** initialize your data structure here. */
	public FindMedianfromDataStream() {
		minheap = new PriorityQueue<>();
		maxheap = new PriorityQueue<>((a, b) -> b - a);
	}

	public void addNum(int num) {
		if (maxheap.isEmpty() && minheap.isEmpty()) {
			maxheap.offer(num);
			return;
		}

		double median = findMedian();
		if (num < median) {
			maxheap.offer(num);
		} else {
			minheap.offer(num);
		}
		
		if(minheap.size() > maxheap.size()) {
			maxheap.offer(minheap.poll());
		}
		
		if(maxheap.size() - minheap.size() > 1) {
			minheap.offer(maxheap.poll());
		}
	}

	public double findMedian() {
		if (maxheap.size() > minheap.size()) {
			return (double) maxheap.peek();
		}
		return (double) (maxheap.peek() + minheap.peek()) / 2.0;
	}

}
