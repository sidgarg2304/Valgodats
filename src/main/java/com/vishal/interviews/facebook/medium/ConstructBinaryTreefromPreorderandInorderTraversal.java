package com.vishal.interviews.facebook.medium;


public class ConstructBinaryTreefromPreorderandInorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {

		return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	public TreeNode buildTree(int[] preorder, int preSt, int preEn, int[] inorder, int inSt, int inEn) {

		if(preSt > preEn){
			return null;
		}
		int rootVal = preorder[preSt];
		TreeNode root = new TreeNode(rootVal);

		int inOrderRootPos = -1;
		for (int i = inSt; i <= inEn; i++) {
			if (inorder[i] == rootVal) {
				inOrderRootPos = i;
			}
		}

		int leftNumberOfNodes = inOrderRootPos - inSt;
		
		root.left = buildTree(preorder, preSt + 1, preSt + leftNumberOfNodes, inorder, inSt, inOrderRootPos - 1);
		root.right = buildTree(preorder, preSt + leftNumberOfNodes + 1, preEn, inorder, inOrderRootPos + 1, inEn);
		
		return root;
	}

}
