package com.vishal.interviews.facebook.medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SerializeandDeserializeBST {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {

		StringBuilder sb = new StringBuilder();

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			sb.append(cur.val + ",");

			if (cur.right != null) {
				stack.push(cur.right);
			}

			if (cur.left != null) {
				stack.push(cur.left);
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {

		if (data == null || data.isEmpty() || data.equals("#")) {
			return null;
		}

		String[] arr = data.split(",");

		return preorder(arr, 0, arr.length - 1);
	}

	TreeNode preorder(String[] arr, int st, int en) {
		if (st > en) {
			return null;
		}

		TreeNode root = new TreeNode(Integer.parseInt(arr[st]));		

		int rightNodePos = -1;
		int leftEndPos = -1;
		for (int i = st + 1; i <= en; i++) {
			if (Integer.parseInt(arr[i]) > Integer.parseInt(arr[st])) {
				rightNodePos = i;
				break;
			} else {
				leftEndPos = i;
			}
		}

		if (leftEndPos != -1) {
			root.left = preorder(arr, st + 1, leftEndPos);
		}
		if (rightNodePos != -1) {
			root.right = preorder(arr, rightNodePos, en);
		}
		return root;

	}
}
