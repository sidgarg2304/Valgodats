package com.vishal.interviews.topinterviewquestions.easy;

import java.util.*;

public class MinStack {

	public static void main(String[] args) {

	}

	Stack<Integer> stack;
	int min;

	MinStack() {
		stack = new Stack<>();
		min = Integer.MAX_VALUE;
	}

	void push(int x) {

		if (x <= min) {
			stack.push(min);
			min = x;
		}
		stack.push(x);

	}

	int pop() {
		int r = stack.pop();
		if(r <= min){
			min = stack.pop();
		}
		return r;
	}

	int getMin() {
		return min;
	}
	
	int top(){
		return stack.peek();
	}
}
