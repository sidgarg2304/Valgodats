package com.vishal.interviews.facebook.medium;

import java.util.*;

import com.vishal.interviews.util.NestedInteger;

/**
 * 341. Flatten Nested List Iterator
 * 
 * Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

Example 2:
Given the list [1,[4,[6]]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 *
 */
public class FlattenNestedListIterator implements Iterator<Integer> {

	public static void main(String[] args) {

	}
	
	Stack<NestedInteger> stack;
   public FlattenNestedListIterator(List<NestedInteger> nestedList) {
       stack = new Stack<>();
       for(int i = nestedList.size()-1; i>=0; i--){
			stack.push(nestedList.get(i));
		}
   }

   
   public Integer next() {
       return stack.pop().getInteger();
   }

   
   public boolean hasNext() {
       while(!stack.isEmpty() && !stack.peek().isInteger()){
			NestedInteger cur = stack.pop();
			for(int i = cur.getList().size()-1; i>=0; i--){
				stack.push(cur.getList().get(i));
			}
		}
		
		return !stack.isEmpty() && stack.peek().isInteger();
   }

}
