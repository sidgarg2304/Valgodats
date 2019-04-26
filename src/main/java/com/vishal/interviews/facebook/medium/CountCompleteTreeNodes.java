package com.vishal.interviews.facebook.medium;

public class CountCompleteTreeNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countNodes(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.left);

		if (leftHeight == rightHeight) {
			return (1 << leftHeight) + countNodes(root.right);
		}
		return (1 << rightHeight) + countNodes(root.left);
	}

	int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}

	public int countNodesSimple(TreeNode root) {

		if (root == null) {
			return 0;
		}

		return 1 + countNodesSimple(root.left) + countNodesSimple(root.right);
	}

}
