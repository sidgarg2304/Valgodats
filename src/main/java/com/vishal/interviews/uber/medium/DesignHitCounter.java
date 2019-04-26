package com.vishal.interviews.uber.medium;

import java.util.*;
public class DesignHitCounter {

	public static void main(String[] args) {

	}

	Queue<Integer> queue;

	/** Initialize your data structure here. */
	public DesignHitCounter() {

	}

	/**
	 * Record a hit.
	 * 
	 * @param timestamp
	 *           - The current timestamp (in seconds granularity).
	 */
	public void hit(int timestamp) {
		queue.offer(timestamp);
	}

	/**
	 * Return the number of hits in the past 5 minutes.
	 * 
	 * @param timestamp
	 *           - The current timestamp (in seconds granularity).
	 */
	public int getHits(int timestamp) {
		while(!queue.isEmpty() && timestamp - queue.peek() >= 300) {
			queue.poll();
		}
		return queue.size();
	}

}
