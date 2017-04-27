package com.vishal.interviews.amazon.easy;

import java.util.Stack;

/**
 * 155. Min Stack
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * push(x) -- Push element x onto stack.
 * 
 * pop() -- Removes the element on top of the stack.
 * 
 * top() -- Get the top element.
 * 
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * Example: MinStack minStack = new MinStack();
 * 
 * minStack.push(-2);
 * 
 * minStack.push(0);
 * 
 * minStack.push(-3);
 * 
 * minStack.getMin(); --> Returns -3.
 * 
 * minStack.pop();
 * 
 * minStack.top(); --> Returns 0.
 * 
 * minStack.getMin(); --> Returns -2.
 * 
 * @author vkotha
 *
 */
public class MinStack {

	public static void main(String[] args) {
	}

}

class MinStackUsingOneStack {
	long min;
	Stack<Long> stack;

	public MinStackUsingOneStack() {
		stack = new Stack<>();
	}

	public void push(int x) {
		if (stack.isEmpty()) {
			stack.push(0L);
			min = x;
		} else {
			stack.push(x - min);// Could be negative if min value needs to change
			if (x < min)
				min = x;
		}
	}

	public void pop() {
		if (stack.isEmpty())
			return;

		long pop = stack.pop();

		if (pop < 0)
			min = min - pop;// If negative, increase the min value

	}

	public int top() {
		long top = stack.peek();
		if (top > 0) {
			return (int) (top + min);
		} else {
			return (int) (min);
		}
	}

	public int getMin() {
		return (int) min;
	}
}

class MinStackAcceptedUsingOneStack {
	int min = Integer.MAX_VALUE;
	Stack<Integer> stack = new Stack<Integer>();

	public void push(int x) {
		// only push the old minimum value when the current
		// minimum value changes after pushing the new value x
		if (x <= min) {
			stack.push(min);
			min = x;
		}
		stack.push(x);
	}

	public void pop() {
		// if pop operation could result in the changing of the current minimum
		// value,
		// pop twice and change the current minimum value to the last minimum
		// value.
		if (stack.pop() == min)
			min = stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min;
	}
}

/**
 * Clean 6ms Java solution
 * 
 */
class MinStack6MSSolution {
	private Node head;

	public void push(int x) {
		if (head == null)
			head = new Node(x, x);
		else
			head = new Node(x, Math.min(x, head.min), head);
	}

	public void pop() {
		head = head.next;
	}

	public int top() {
		return head.val;
	}

	public int getMin() {
		return head.min;
	}

	private class Node {
		int val;
		int min;
		Node next;

		private Node(int val, int min) {
			this(val, min, null);
		}

		private Node(int val, int min, Node next) {
			this.val = val;
			this.min = min;
			this.next = next;
		}
	}
}
