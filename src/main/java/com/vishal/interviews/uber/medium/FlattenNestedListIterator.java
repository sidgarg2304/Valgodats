package com.vishal.interviews.uber.medium;

import java.util.*;

import com.vishal.interviews.util.NestedInteger;

public class FlattenNestedListIterator {

	public static void main(String[] args) {

	}

	Stack<NestedInteger> stack;

	public FlattenNestedListIterator(List<NestedInteger> nestedList) {

		stack = new Stack<>();

		for (int i = nestedList.size() - 1; i >= 0; i--) {
			stack.push(nestedList.get(i));
		}
	}
	
	public Integer next() {
		return stack.pop().getInteger();
	}
	
	public boolean hasNext() {

		while(!stack.isEmpty() && !stack.peek().isInteger()) {
			NestedInteger cur = stack.pop();
			for (int i = cur.getList().size() - 1; i >= 0; i--) {
				stack.push(cur.getList().get(i));
			}
		}
		
		return !stack.isEmpty() && stack.peek().isInteger();
	}

}
