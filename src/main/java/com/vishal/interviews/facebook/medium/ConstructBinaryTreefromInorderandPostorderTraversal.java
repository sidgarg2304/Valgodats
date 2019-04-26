package com.vishal.interviews.facebook.medium;

public class ConstructBinaryTreefromInorderandPostorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {

      if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
			return null;
		}
      
		return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}

	TreeNode buildTree(int[] inorder, int inSt, int inEn, int[] postorder, int postSt, int postEn) {

		if(inSt > inEn || postSt > postEn){
          return null;
      }
		
		int rootVal = postorder[postEn];
		TreeNode root = new TreeNode(rootVal);

		int rootPosInorder = -1;
		for (int i = inSt; i <= inEn; i++) {
			if (inorder[i] == rootVal) {
				rootPosInorder = i;
				break;
			}
		}
		int leftNodesCount = rootPosInorder - inSt;
		root.left = buildTree(inorder, inSt, rootPosInorder - 1, postorder, postSt, postSt + leftNodesCount - 1);
		root.right = buildTree(inorder, rootPosInorder + 1, inEn, postorder, postSt + leftNodesCount,
				postEn - 1);

		return root;
	}

}
