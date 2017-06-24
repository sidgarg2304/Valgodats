package com.vishal.interviews.programcreek.linkedlist;

import java.util.*;

public class ImplementStackusingQueues {

	public static void main(String[] args) {

	}

	Queue<Integer> queue1;
	Queue<Integer> queue2;

	ImplementStackusingQueues() {
		queue1 = new LinkedList<>();
		queue2 = new LinkedList<>();
	}

	void push(int val) {

		if (isEmpty()) {
			queue1.offer(val);
			return;
		}

		if (queue1.isEmpty()) {
			queue1.offer(val);
			while (!queue2.isEmpty()) {
				queue1.offer(queue2.poll());
			}
		} else if (queue2.isEmpty()) {
			queue2.offer(val);
			while (!queue1.isEmpty()) {
				queue2.offer(queue1.poll());
			}
		}
	}

	int peek() {
		if (queue1.size() > 0) {
			return queue1.peek();
		} else if (queue2.size() > 0) {
			return queue2.peek();
		}

		return 0;

	}

	void pop() {
		if (queue1.size() > 0) {
			queue1.poll();
		} else if (queue2.size() > 0) {
			queue2.poll();
		}
	}

	boolean isEmpty() {
		return queue1.isEmpty() && queue2.isEmpty();
	}
}
