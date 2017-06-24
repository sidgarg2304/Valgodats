package com.vishal.interviews.linkedin.careercup;

import java.util.*;

/**
 * Might not be perfect solution. But just added for reference as to how we might need
 * to approach this problem
 *
 */
public class BlockingQueue {

	Queue<Integer> queue;
	int capacity;

	BlockingQueue(int capacity) {
		queue = new LinkedList<>();
		capacity = this.capacity;
	}

	synchronized void offer(int val) throws InterruptedException {
		queue.offer(val);
		notifyAll();
	}

	synchronized int poll() {
		while (queue.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
				return -1;
			}
		}

		return queue.poll();
	}
}
