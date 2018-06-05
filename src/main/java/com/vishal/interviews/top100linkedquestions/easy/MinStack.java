package com.vishal.interviews.top100linkedquestions.easy;

import java.util.*;

public class MinStack {

	public static void main(String[] args) {

	}

	Stack<Integer> stack;

	int min = Integer.MAX_VALUE;

	MinStack() {
		stack = new Stack<>();
	}

	void push(int val) {
		if (val <= min) {
			stack.push(min);
			min = val;
		}
		stack.push(val);
	}

	int getMin() {
		return min;
	}

	int peek() {
		return stack.peek();
	}

	int pop() {
		int r = stack.pop();
		if (r <= min) {
			min = stack.pop();
		}
		return r;
	}

}
