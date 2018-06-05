package com.vishal.interviews.topinterviewquestions.medium;

import com.vishal.interviews.util.TreeNode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

	public static void main(String[] args) {

	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
			return null;
		}

		return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	TreeNode build(int[] preorder, int preSt, int preEn, int[] inorder, int inSt, int inEn) {

		TreeNode root = new TreeNode(preorder[preSt]);

		int inRootPos = -1;
		for (int i = inSt; i <= inEn; i++) {
			if (inorder[i] == root.val) {
				inRootPos = i;
				break;
			}
		}

		if (inRootPos == -1) {
			return null;
		}

		root.left = build(preorder, preSt + 1, preSt + (inRootPos - inSt), inorder, inSt, inRootPos - 1);
		root.right = build(preorder, preSt + (inRootPos - inSt) + 1, preEn, inorder, inRootPos + 1, inEn);

		return root;
	}
}
