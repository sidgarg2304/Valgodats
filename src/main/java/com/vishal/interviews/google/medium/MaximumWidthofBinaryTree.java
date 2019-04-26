package com.vishal.interviews.google.medium;

import java.util.*;

public class MaximumWidthofBinaryTree {

	public static void main(String[] args) {

	}

	public int widthOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(root, 0, 0));

		int curDepth = 0;
		int left = 0;
		int res = 0;
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			if (cur.node != null) {
				queue.offer(new Node(cur.node.left, cur.pos * 2 + 1, cur.depth + 1));
				queue.offer(new Node(cur.node.right, cur.pos * 2 + 2, cur.depth + 1));

				if (cur.depth != curDepth) {
					curDepth = cur.depth;
					left = cur.pos;
				}
				res = Math.max(res, cur.pos - left + 1);
			}
		}

		return res;
	}

	class Node {
		TreeNode node;
		int pos;
		int depth;

		Node(TreeNode node, int pos, int depth) {
			this.depth = depth;
			this.pos = pos;
			this.node = node;
		}
	}

}
