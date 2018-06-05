package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

public class EvaluateReversePolishNotation {

	public static void main(String[] args) {

	}

	public int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < tokens.length; i++) {
			String c = tokens[i];

			if (c.equals("+")) {
				stack.push(stack.pop() + stack.pop());
			} else if (c.equals("-")) {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(a - b);
			} else if (c.equals("*")) {
				stack.push(stack.pop() * stack.pop());
			} else if (c.equals("/")) {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(a / b);
			} else {
				stack.push(Integer.parseInt(c));
			}

		}
		
		return stack.pop();
	}

}
