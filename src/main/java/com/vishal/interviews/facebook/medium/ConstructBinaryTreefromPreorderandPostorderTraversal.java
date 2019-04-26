package com.vishal.interviews.facebook.medium;

public class ConstructBinaryTreefromPreorderandPostorderTraversal {

	public static void main(String[] args) {

	}

	public TreeNode constructFromPrePost(int[] pre, int[] post) {
		return constructFromPrePost(pre, 0, pre.length - 1, post, 0, post.length - 1);
	}

	TreeNode constructFromPrePost(int[] pre, int preSt, int preEn, int[] post, int postSt, int postEn) {

		if (preSt > preEn) {
			return null;
		}

		int rootVal = pre[preSt];
		TreeNode root = new TreeNode(rootVal);

		if (preSt == preEn) {
			return root;
		}

		int leftRootVal = pre[preSt + 1];
		int postLeftRootPos = -1;
		for (int i = postSt; i < postEn; i++) {
			if (post[i] == leftRootVal) {
				postLeftRootPos = i;
			}
		}

		int numOfLeftTreeElements = postLeftRootPos - postSt + 1;
		root.left = constructFromPrePost(pre, preSt + 1, preSt + numOfLeftTreeElements, post, postSt, postLeftRootPos);
		root.right = constructFromPrePost(pre, preSt + numOfLeftTreeElements + 1, preEn, post, postLeftRootPos + 1,
				postEn - 1);

		return root;
	}

}
