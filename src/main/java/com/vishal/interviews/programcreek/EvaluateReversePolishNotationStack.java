package com.vishal.interviews.programcreek;

import java.util.*;

/**
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 ["4", "13", "5", "/", "+"] ->
 * (4 + (13 / 5)) -> 6
 *
 */
public class EvaluateReversePolishNotationStack {

	public static void main(String[] args) {

	}

	public static int evalRPN(String[] tokens) {

		String operators = "+-*/";
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < tokens.length; i++) {
			if (!operators.contains(tokens[i])) {
				stack.push(Integer.parseInt(tokens[i]));
			} else {
				switch (tokens[i]) {
				case "+": {
					stack.push(stack.pop() + stack.pop());
					break;
				}
				case "-": {
					int b = stack.pop();
					int a = stack.pop();
					stack.push(a - b);
					break;
				}
				case "*": {
					stack.push(stack.pop() * stack.pop());
					break;
				}
				case "/": {
					int b = stack.pop();
					int a = stack.pop();
					stack.push(a / b);
					break;
				}
				}
			}
		}

		return stack.pop();
	}

}
