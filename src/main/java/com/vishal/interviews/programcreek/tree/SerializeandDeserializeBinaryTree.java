package com.vishal.interviews.programcreek.tree;

import java.util.*;

import com.vishal.interviews.util.TreeNode;

public class SerializeandDeserializeBinaryTree {

	public static void main(String[] args) {

	}

	String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if (cur == null) {
				sb.append("#,");
				continue;
			}

			sb.append(cur.val + ",");

			queue.offer(cur.left);
			queue.offer(cur.right);

		}

		sb.deleteCharAt(sb.length() - 1);

		return sb.toString();

	}

	TreeNode deSerialize(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}
		String[] arr = s.split(",");

		TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		int i = 1;
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();

			String left = arr[i++];

			if (!"#".equals(left)) {
				cur.left = new TreeNode(Integer.parseInt(left));
				queue.offer(cur.left);
			}

			String right = arr[i++];
			if (!"#".equals(right)) {
				cur.right = new TreeNode(Integer.parseInt(right));
				queue.offer(cur.right);
			}

		}

		return root;

	}

}
