package com.vishal.interviews.facebook.careercup;

import java.util.*;

/**
 * Given a preorder traversal of a BST, print out the inorder transversal of the
 * BST public void printInorder(int[] nums){}
 *
 */
public class PreorderToInorder {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(preorderToInorder(new int[] { 8, 4, 1, 6, 5, 7, 12, 10 })));
	}

	// preorder - root, left, right
	// inrorder - left, root, right
	static int[] preorderToInorder(int[] nums) {
		int[] inorder = new int[nums.length];

		Stack<Integer> stack = new Stack<>();
		int r = 0;
		for (int p : nums) {

			while (!stack.isEmpty() && p > stack.peek()) {
				inorder[r++] = stack.pop();
			}

			stack.push(p);
		}

		while (!stack.isEmpty()) {
			inorder[r++] = stack.pop();
		}

		return inorder;
	}

}
