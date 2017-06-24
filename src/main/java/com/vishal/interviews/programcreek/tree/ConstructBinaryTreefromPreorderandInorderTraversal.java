package com.vishal.interviews.programcreek.tree;

import com.vishal.interviews.util.TreeNode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

	public static void main(String[] args) {

	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {

		if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
			return null;
		}

		return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	public TreeNode buildTree(int[] preorder, int preSt, int preEn, int[] inorder, int inSt, int inEn) {

		if (preSt > preEn || inSt > inEn) {
			return null;
		}

		TreeNode root = new TreeNode(preorder[preSt]);

		int inOrderRootPos = 0;

		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == root.val) {
				inOrderRootPos = i;
				break;
			}
		}

		root.left = buildTree(preorder, preSt + 1, preSt + inOrderRootPos - inSt, inorder, inSt, inOrderRootPos - 1);
		root.right = buildTree(preorder, preSt + inOrderRootPos - inSt + 1, preEn, inorder, inOrderRootPos + 1, inEn);

		return root;

	}

}
