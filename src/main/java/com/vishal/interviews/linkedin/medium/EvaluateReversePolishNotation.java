package com.vishal.interviews.linkedin.medium;

import java.util.*;

/**
 * 150. Evaluate Reverse Polish Notation
 *
 *Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateReversePolishNotation {

	public static void main(String[] args) {

	}
	
	static int reversePolishNotation(String[] tokens) {
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < tokens.length; i++) {
			String cur = tokens[i];

			if (cur.equals("+")) {
				stack.push(stack.pop() + stack.pop());
			} else if (cur.equals("-")) {
				stack.push(stack.pop() - stack.pop());
			}
			if (cur.equals("*")) {
				stack.push(stack.pop() * stack.pop());
			}
			if (cur.equals("+")) {
				stack.push(stack.pop() / stack.pop());
			} else {
				stack.push(Integer.valueOf(cur));
			}
		}
		return stack.pop();
	}

}
