package com.vishal.interviews.facebook.easy;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAveragefromDataStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Queue<Integer> queue;
	int maxSize;
	double sum;
	public MovingAveragefromDataStream(int size) {
		queue = new LinkedList<>();
		maxSize = size;
		sum = 0.0f;
	}
	public double next(int val) {
		sum += val;
		queue.offer(val);
		while(queue.size() > maxSize) {
			sum -= queue.poll();
		}
		return sum / queue.size();
	}

}
