package com.vishal.interviews.programcreek.tree;

import java.util.*;

public class VerifyPreorderSerializationofaBinaryTree {

	public static void main(String[] args) {

	}

	public boolean isValidSerialization(String preorder) {
		String[] arr = preorder.split(",");
		Stack<String> stack = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			String cur = arr[i];

			while (cur.equals("#") && !stack.isEmpty() && stack.peek().equals("#")) {
				stack.pop();
				if (stack.isEmpty()) {
					return false;
				}
				stack.pop();				
			}
			stack.push(cur);
		}

		if (stack.size() == 1 && stack.peek().equals("#")) {
			return true;
		}

		return false;
	}

}
