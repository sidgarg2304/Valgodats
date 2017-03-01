package com.vishal.interviews.google.easy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 346
 * Given a stream of integers and a window size, calculate the moving average of
 * all integers in the sliding window.
 * 
 * For example, MovingAverage m = new MovingAverage(3); m.next(1) = 1 m.next(10)
 * = (1 + 10) / 2 m.next(3) = (1 + 10 + 3) / 3 m.next(5) = (10 + 3 + 5) / 3
 * 
 * @author vkotha
 *
 */
public class MovingAverageDataStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class MovingAverageO1Solution {
	private int[] window;
	private int n, insert;
	private long sum;

	/** Initialize your data structure here. */
	public MovingAverageO1Solution(int size) {
		window = new int[size];
		insert = 0;
		sum = 0;
	}

	public double next(int val) {
		if (n < window.length)
			n++;
		sum -= window[insert];
		sum += val;
		window[insert] = val;
		insert = (insert + 1) % window.length;

		return (double) sum / n;
	}
}

class MovingAverageEasy {
	private double previousSum = 0.0;
	private int maxSize;
	private Queue<Integer> currentWindow;

	public MovingAverageEasy(int size) {
		currentWindow = new LinkedList<Integer>();
		maxSize = size;
	}

	public double next(int val) {
		if (currentWindow.size() == maxSize) {
			previousSum -= currentWindow.remove();
		}

		previousSum += val;
		currentWindow.add(val);
		return previousSum / currentWindow.size();
	}
}

class MovingAverageUsingDeQueue {

	Deque<Integer> dq;
	int size;
	int sum;

	public MovingAverageUsingDeQueue(int size) {
		dq = new LinkedList<>();
		this.size = size;
		this.sum = 0;
	}

	public double next(int val) {
		if (dq.size() < size) {
			sum += val;
			dq.addLast(val);
			return (double) (sum / dq.size());
		} else {
			int temp = dq.pollFirst();
			sum -= temp;
			dq.addLast(val);
			sum += val;
			return (double) (sum / size);
		}
	}

}
