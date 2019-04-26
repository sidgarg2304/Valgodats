package com.vishal.interviews.facebook.hard;

import java.util.LinkedList;
import java.util.Queue;

import com.vishal.interviews.util.TreeNode;


public class SerializeandDeserializeBinaryTree {

	public static void main(String[] args) {

	}
	
	public String serialize(TreeNode root) {

		if (root == null) {
			return "";
		}
		StringBuilder res = new StringBuilder();

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode c = queue.poll();
			if (c == null) {
				res.append("#,");
				continue;
			}
			res.append(c.val + ",");
			queue.offer(c.left);
			queue.offer(c.right);
		}

		res.deleteCharAt(res.length() - 1);

		return res.toString();
	}

	public TreeNode deSerialize(String s) {

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
			String right = arr[i++];
			if (!"#".equals(left)) {
				cur.left = new TreeNode(Integer.parseInt(left));
				queue.offer(cur.left);
			}

			if (!"#".equals(left)) {
				cur.right = new TreeNode(Integer.parseInt(right));
				queue.offer(cur.right);
			}
		}

		return root;

	}

}
