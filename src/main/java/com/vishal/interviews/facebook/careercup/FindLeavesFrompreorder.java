package com.vishal.interviews.facebook.careercup;

import java.util.*;

/**
 * given preorder traversal [5,3,2,4,8,7,9] of a BST, how do we identify the
 * leaf nodes without building the tree ?
 * 
 * @Anonymous Please try other use cases like, only single leaf node
 *
 * 
 */
public class FindLeavesFrompreorder {

	public static void main(String[] args) {

		System.out.println(findLeaves(new int[] { 5, 3, 2, 4, 8, 7, 9 }));
	}

	// 5 3
	static List<Integer> findLeaves(int[] preorder) {
		Stack<Integer> stack = new Stack<>();

		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < preorder.length; i++) {
			if (stack.isEmpty() || preorder[i] < stack.peek()) {
				stack.push(preorder[i]);
			} else {
				res.add(stack.peek());
				while (!stack.isEmpty() && preorder[i] > stack.peek()) {
					stack.pop();
				}
				stack.push(preorder[i]);
			}
		}

		if (stack.size() > 0) {
			res.add(stack.pop());
		}

		return res;
	}

}
