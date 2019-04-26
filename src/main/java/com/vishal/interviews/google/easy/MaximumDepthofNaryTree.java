package com.vishal.interviews.google.easy;

import java.util.*;

public class MaximumDepthofNaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxDepth(Node root) {

		if (root == null) {
			return 0;
		}

		if (root.children.isEmpty()) {
			return 1;
		}

		int maxDepth = 1;
		for (Node c : root.children) {
			maxDepth = Math.max(maxDepth, 1 + maxDepth(c));
		}
		return maxDepth;
	}

	class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}

}
