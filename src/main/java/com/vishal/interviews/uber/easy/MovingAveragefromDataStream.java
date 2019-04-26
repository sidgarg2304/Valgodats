package com.vishal.interviews.uber.easy;

import java.util.*;

public class MovingAveragefromDataStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Queue<Integer> queue;
	int maxSize;
	double sum;

	/** Initialize your data structure here. */
	public MovingAveragefromDataStream(int size) {
		queue = new LinkedList<>();
		maxSize = size;
	}

	public double next(int val) {
		queue.offer(val);
		sum += val;
		while (queue.size() > maxSize) {
			sum -= queue.poll();
		}
		return sum / queue.size();
	}

}
