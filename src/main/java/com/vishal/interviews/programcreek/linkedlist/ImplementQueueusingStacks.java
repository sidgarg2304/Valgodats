package com.vishal.interviews.programcreek.linkedlist;

import java.util.*;

public class ImplementQueueusingStacks {

	public static void main(String[] args) {

	}

	Stack<Integer> stack;
	Stack<Integer> temp;

	ImplementQueueusingStacks() {
		stack = new Stack<>();
		temp = new Stack<>();
	}

	void push(int x) {
		if (stack.isEmpty()) {
			stack.push(x);
		} else {
			while (!stack.isEmpty()) {
				temp.push(stack.pop());
			}

			stack.push(x);

			while (!temp.isEmpty()) {
				stack.push(temp.pop());
			}
		}
	}

	int pop() {
		return stack.pop();
	}

	int peek() {
		return stack.peek();
	}

	boolean isEmpty(){
		return stack.isEmpty();
	}

}
