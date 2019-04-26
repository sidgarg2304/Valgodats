package com.vishal.interviews.facebook.easy;

import java.util.Stack;

public class MaxStack {

	public static void main(String[] args) {

	}

	Stack<Integer> stack;
	Stack<Integer> maxStack;

	/** initialize your data structure here. */
	public MaxStack() {
		stack = new Stack<>();
		maxStack = new Stack<>();
	}

	public void push(int x) {
		int curMax = maxStack.isEmpty() ? x : maxStack.peek();
		stack.push(x);
		maxStack.push(x > curMax ? x : curMax);
	}

	public int pop() {
		maxStack.pop();
		return stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int peekMax() {
		return maxStack.peek();
	}

	public int popMax() {
		int max = maxStack.peek();
		Stack<Integer> temp = new Stack<>();
		while (!stack.isEmpty() && top() != max) {
			temp.push(pop());
		}
		pop();
		while (!temp.isEmpty()) {
			push(temp.pop());
		}
		return max;
	}

}

