package com.vishal.interviews.programcreek;

import java.util.*;

public class MovingAveragefromDataStream {

	public static void main(String[] args) {

	}

	Queue<Integer> queue;
	int size;
	int sum = 0;

	public MovingAveragefromDataStream(int size) {
		this.queue = new LinkedList<Integer>();
		this.size = size;
	}

	public double next(int val) {
		sum += val;
		queue.offer(val);

		while (queue.size() > size) {
			sum -= queue.poll();
		}

		return (double) sum / (double) queue.size();
	}

}
