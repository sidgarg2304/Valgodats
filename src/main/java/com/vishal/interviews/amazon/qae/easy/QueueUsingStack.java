package com.vishal.interviews.amazon.qae.easy;

import java.util.*;

public class QueueUsingStack {

	public static void main(String[] args) {

	}

	Stack<Integer> pushStack;
	Stack<Integer> pollStack;

	QueueUsingStack() {
		pushStack = new Stack<>();
		pollStack = new Stack<>();
	}

	void offer(int val) {
		if (pollStack.isEmpty()) {
			pollStack.push(val);
		} else {
			while (!pollStack.isEmpty()) {
				pushStack.push(pollStack.pop());
			}

			pollStack.push(val);

			while (!pushStack.isEmpty()) {
				pollStack.push(pushStack.pop());
			}

		}
	}

	int poll() {
		return pollStack.pop();
	}

	boolean isEmpty() {
		return pollStack.isEmpty();
	}

}
