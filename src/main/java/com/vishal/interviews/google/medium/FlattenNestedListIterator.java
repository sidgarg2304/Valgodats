package com.vishal.interviews.google.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Given a nested list of integers, implement an iterator to flatten it.
 * 
 * Each element is either an integer, or a list -- whose elements may also be
 * integers or other lists.
 * 
 * Example 1: Given the list [[1,1],2,[1,1]],
 * 
 * By calling next repeatedly until hasNext returns false, the order of elements
 * returned by next should be: [1,1,2,1,1].
 * 
 * Example 2: Given the list [1,[4,[6]]],
 * 
 * 
 */
public class FlattenNestedListIterator {

	public static void main(String[] args) {

	}

}

/**
 * Simple Java solution using a stack with explanation
 * 
 * A question before this is the Nested List Weight Sum, and it requires
 * recursion to solve. As it carries to this problem that we will need recursion
 * to solve it. But since we need to access each NestedInteger at a time, we
 * will use a stack to help.
 * 
 * In the constructor, we push all the nestedList into the stack from back to
 * front, so when we pop the stack, it returns the very first element. Second,
 * in the hasNext() function, we peek the first element in stack currently, and
 * if it is an Integer, we will return true and pop the element. If it is a
 * list, we will further flatten it. This is iterative version of flatting the
 * nested list. Again, we need to iterate from the back to front of the list.
 * 
 * @author vkotha
 *
 */
class NestedIteratorSimple implements Iterator<Integer> {
	Stack<NestedInteger> stack = new Stack<>();

	public NestedIteratorSimple(List<NestedInteger> nestedList) {
		for (int i = nestedList.size() - 1; i >= 0; i--) {
			stack.push(nestedList.get(i));
		}
	}

	@Override
	public Integer next() {
		return stack.pop().getInteger();
	}

	@Override
	public boolean hasNext() {
		while (!stack.isEmpty()) {
			NestedInteger curr = stack.peek();
			if (curr.isInteger()) {
				return true;
			}
			stack.pop();
			for (int i = curr.getList().size() - 1; i >= 0; i--) {
				stack.push(curr.getList().get(i));
			}
		}
		return false;
	}
}

class NestedInteger {
	boolean isInteger() {
		return false;
	}

	List<NestedInteger> getList() {
		return new ArrayList<>();

	}

	Integer getInteger() {
		return null;
	}
}

/**
 * Share my Java neat solution, 8ms
 * 
 * I feel my solution is pretty neat compared to the existing solutions, so I
 * want to share it with you to provide some extra ingredients. Basically, I
 * have similar idea as StafanPochmann's
 * https://leetcode.com/discuss/user/StefanPochmann solution:
 * https://discuss.leetcode.com/topic/41870/real-iterator-in-python-java-c , but
 * I feel to use listIterator seems overkill. So what I do is just to keep an
 * additional field storing the next integer. Please check the code.
 *
 * 
 */
class NestedIteratorEasy implements Iterator<Integer> {
	NestedInteger nextInt;
	Stack<Iterator<NestedInteger>> stack;

	public NestedIteratorEasy(List<NestedInteger> nestedList) {
		stack = new Stack<Iterator<NestedInteger>>();
		stack.push(nestedList.iterator());
	}

	@Override
	public Integer next() {
		return nextInt != null ? nextInt.getInteger() : null; // Just in case
	}

	@Override
	public boolean hasNext() {
		while (!stack.isEmpty()) {
			if (!stack.peek().hasNext())
				stack.pop();
			else if ((nextInt = stack.peek().next()).isInteger())
				return true;
			else
				stack.push(nextInt.getList().iterator());
		}
		return false;
	}
}
