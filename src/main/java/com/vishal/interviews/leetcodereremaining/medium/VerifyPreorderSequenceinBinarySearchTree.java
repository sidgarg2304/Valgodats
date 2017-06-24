package com.vishal.interviews.leetcodereremaining.medium;

import java.util.*;

public class VerifyPreorderSequenceinBinarySearchTree {

	public static void main(String[] args) {

	}

	public boolean verifyPreorder(int[] preorder) {
		if (preorder == null || preorder.length == 0) {
			return true;
		}

		int low = Integer.MIN_VALUE;

		Stack<Integer> stack = new Stack<>();		
		for (int p : preorder) {
			if (p < low) {
				return false;
			}

			while (!stack.isEmpty() && p > stack.peek()) {
				low = stack.pop();
			}
			stack.push(p);
		}

		return true;
	}

}
