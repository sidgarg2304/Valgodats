package com.vishal.interviews.facebook.medium;

/**
 * 285. Inorder Successor in BST
 * 
 * Given a binary search tree and a node in it, find the in-order successor of
 * that node in the BST.
 * 
 * Note: If the given node has no in-order successor in the tree, return null.
 * 
 */
public class InorderSuccessorinBST {

	public static void main(String[] args) {

	}

	/**
	 * Successor
	 * 
	 * @param root
	 * @param p
	 * @return
	 */
	public TreeNode successorRecursive(TreeNode root, TreeNode p) {
		if (root == null)
			return null;

		if (root.val <= p.val) {
			return successorRecursive(root.right, p);
		} else {
			TreeNode left = successorRecursive(root.left, p);
			return (left != null) ? left : root;
		}
	}

	/**
	 * Java/Python solution, O(h) time and O(1) space, iterative
	 * 
	 * The inorder traversal of a BST is the nodes in ascending order. To find a
	 * successor, you just need to find the smallest one that is larger than the
	 * given value since there are no duplicate values in a BST. It just like the
	 * binary search in a sorted list. The time complexity should be O(h) where h
	 * is the depth of the result node. succ is a pointer that keeps the possible
	 * successor. Whenever you go left the current root is the new possible
	 * successor, otherwise the it remains the same.
	 * 
	 * Only in a balanced BST O(h) = O(log n). In the worst case h can be as
	 * large as n.
	 * 
	 * // 29 / 29 test cases passed. // Status: Accepted // Runtime: 5 ms
	 * 
	 * @param root
	 * @param p
	 * @return
	 */
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		TreeNode succ = null;
		while (root != null) {
			if (p.val < root.val) {
				succ = root;
				root = root.left;
			} else
				root = root.right;
		}
		return succ;
	}

	/**
	 * 10 (and 4) lines O(h) Java/C++ 
	 * 
	 * Update: Ugh, turns out I didn't think it
	 * through and the big case distinction is unnecessary. Just search from root
	 * to bottom, trying to find the smallest node larger than p and return the
	 * last one that was larger. D'oh. Props to smileyogurt.966 for doing that
	 * first, I think. I'll just write it in my ternary style for C++:
	 * 
	 * @param root
	 * @param p
	 * @return
	 */
	public TreeNode inorderSuccessorSol2(TreeNode root, TreeNode p) {
		if (p.right != null) {
			p = p.right;
			while (p.left != null)
				p = p.left;
			return p;
		}
		TreeNode candidate = null;
		while (root != p)
			root = (p.val > root.val) ? root.right : (candidate = root).left;
		return candidate;
	}

	/**
	 * Predecessor
	 * 
	 * @param root
	 * @param p
	 * @return
	 */
	public TreeNode predecessor(TreeNode root, TreeNode p) {
		if (root == null)
			return null;

		if (root.val >= p.val) {
			return predecessor(root.left, p);
		} else {
			TreeNode right = predecessor(root.right, p);
			return (right != null) ? right : root;
		}
	}

}
