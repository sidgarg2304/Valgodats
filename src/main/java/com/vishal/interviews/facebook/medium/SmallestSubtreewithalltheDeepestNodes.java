package com.vishal.interviews.facebook.medium;


public class SmallestSubtreewithalltheDeepestNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		return depth(root).node;
	}

	Result depth(TreeNode root) {
		if (root == null) {
			return new Result(root, 0);
		}

		Result left = depth(root.left);
		Result right = depth(root.right);

		if (left.depth == right.depth) {
			return new Result(root, left.depth + 1);
		} else if (left.depth > right.depth) {
			return new Result(left.node, left.depth + 1);
		} else {
			return new Result(right.node, right.depth + 1);
		}
	}

}

class Result {
	TreeNode node;
	int depth;

	Result(TreeNode node, int depth) {
		this.node = node;
		this.depth = depth;
	}
}