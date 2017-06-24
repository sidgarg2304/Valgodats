package com.vishal.interviews.programcreek;

import java.util.*;

public class MinStack {

	public static void main(String[] args) {

	}

	Stack<Integer> stack;

	MinStack() {
		stack = new Stack<>();
	}

	int min = Integer.MAX_VALUE;

	void push(int val) {
		if (val <= min) {
			stack.push(min);
			min = val;
		}
		stack.push(val);
	}

	int min() {
		return min;
	}

	int pop() {
		int res = stack.pop();
		if (res <= min) {
			min = stack.pop();
		}
		return res;
	}
}
