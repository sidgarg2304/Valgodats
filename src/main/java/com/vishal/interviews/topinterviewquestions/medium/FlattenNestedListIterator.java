package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

import com.vishal.interviews.util.NestedInteger;

public class FlattenNestedListIterator {

	public static void main(String[] args) {

	}

	Stack<NestedInteger> stack;

	public FlattenNestedListIterator(List<NestedInteger> nestedList) {

		for (int i = nestedList.size() - 1; i >= 0; i--) {
			stack.push(nestedList.get(i));
		}

	}

	int next() {
		return stack.pop().getInteger();
	}

	boolean hasNext() {
		while (!stack.isEmpty() && !stack.peek().isInteger()) {
			NestedInteger c = stack.pop();
			List<NestedInteger> children = c.getList();
			for (int i = children.size() - 1; i >= 0; i--) {
				stack.push(children.get(i));
			}
		}

		return !stack.isEmpty() && stack.peek().isInteger();
	}

}
