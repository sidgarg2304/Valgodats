package com.vishal.interviews.programcreek.tree;

import com.vishal.interviews.util.TreeNode;

public class ConstructBinaryTreefromInorderandPostorderTraversal {

	public static void main(String[] args) {

	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {

		if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
			return null;
		}

		return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}

	TreeNode buildTree(int[] inorder, int inSt, int inEn, int[] postorder, int posSt, int posEn) {

		TreeNode root = new TreeNode(postorder[posEn]);

		int k = -1;

		for (int i = inSt; i <= inEn; i++) {
			if (inorder[i] == postorder[posEn]) {
				k = i;
				break;
			}
		}

		root.left = buildTree(inorder, inSt, k - 1, postorder, posSt, posSt + k - (inSt + 1));

		root.right = buildTree(inorder, k + 1, inEn, postorder, posSt + k - inSt, posEn - 1);

		return root;
	}
}
