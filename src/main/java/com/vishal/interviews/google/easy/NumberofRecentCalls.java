package com.vishal.interviews.google.easy;

import java.util.LinkedList;
import java.util.Queue;

public class NumberofRecentCalls {

	public static void main(String[] args) {

	}

	Queue<Integer> queue;

	public NumberofRecentCalls() {
		queue = new LinkedList<>();
	}

	public int ping(int t) {
		queue.offer(t);
		while(t - queue.peek() > 3000) {
			queue.poll();
		}
		return queue.size();
	}

}
