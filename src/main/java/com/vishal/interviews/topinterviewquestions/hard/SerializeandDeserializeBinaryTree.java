package com.vishal.interviews.topinterviewquestions.hard;

import java.util.*;

import com.vishal.interviews.util.TreeNode;

public class SerializeandDeserializeBinaryTree {

	public static void main(String[] args) {

	}

	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		if (root == null) {
			return sb.toString();
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if (null == cur) {
				sb.append("#,");
				continue;
			}

			sb.append(cur.val);
			sb.append(",");

			queue.offer(cur.left);
			queue.offer(cur.right);

		}

		sb.deleteCharAt(sb.length() - 1);

		return sb.toString();
	}

	public TreeNode deserialize(String data) {
		if (data == null || data.length() == 0) {
			return null;
		}

		String[] strs = data.split(",");
		TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
		int st = 1;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();

			String left = strs[st++];
			String right = strs[st++];

			if (!left.equals("#")) {
				cur.left = new TreeNode(Integer.parseInt(left));
				queue.offer(cur.left);
			}

			if (!right.equals("#")) {
				cur.right = new TreeNode(Integer.parseInt(right));
				queue.offer(cur.right);
			}
		}

		return root;
	}

}
