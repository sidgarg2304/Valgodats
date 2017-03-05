package com.vishal.interviews.google.easy;

import java.util.TreeSet;

/**
 * 530. Minimum Absolute Difference in BST
 * 
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
Note: There are at least two nodes in this BST.
 */
public class MinimumAbsoluteDifferenceinBST {

	public static void main(String[] args) {
		
	}

}

/**
 * The most common idea is to first inOrder traverse the tree and compare the
 * delta between each of the adjacent values. It's guaranteed to have the
 * correct answer because it is a BST thus inOrder traversal values are sorted.
 * 
 * Solution 1 - In-Order traverse, time complexity O(N), space complexity O(1).
 * 
 */
class MinimumAbsoluteDifferenceinBSTInOrder {
	int min = Integer.MAX_VALUE;
	Integer prev = null;

	public int getMinimumDifference(TreeNode root) {
		if (root == null)
			return min;

		getMinimumDifference(root.left);

		if (prev != null) {
			min = Math.min(min, root.val - prev);
		}
		prev = root.val;

		getMinimumDifference(root.right);

		return min;
	}

}

/**
 * What if it is not a BST? (Follow up of the problem) The idea is to put values
 * in a TreeSet and then every time we can use O(lgN) time to lookup for the
 * nearest values.
 * 
 * Solution 2 - Pre-Order traverse, time complexity O(NlgN), space complexity
 * O(N).
 *
 */
class MinimumAbsoluteDifferenceinNonBSTInOrderUsingTreeSet {
	TreeSet<Integer> set = new TreeSet<>();
	int min = Integer.MAX_VALUE;

	public int getMinimumDifference(TreeNode root) {
		if (root == null)
			return min;

		if (!set.isEmpty()) {
			if (set.floor(root.val) != null) {
				min = Math.min(min, Math.abs(root.val - set.floor(root.val)));
			}
			if (set.ceiling(root.val) != null) {
				min = Math.min(min, Math.abs(root.val - set.ceiling(root.val)));
			}
		}

		set.add(root.val);

		getMinimumDifference(root.left);
		getMinimumDifference(root.right);

		return min;
	}
}

/**
 * Java O(n) Inorder Traversal Solution
 * 
 * Since this is a BST, the inorder traversal of its nodes results in a sorted
 * list of values. Thus, the minimum absolute difference must occur in any
 * adjacently traversed nodes. I use the global variable "prev" to keep track of
 * each node's inorder predecessor.
 * 
 */
class MinimumAbsoluteDifferenceinBSTInOrderSimple {

	int minDiff = Integer.MAX_VALUE;
	TreeNode prev;

	public int getMinimumDifference(TreeNode root) {
		inorder(root);
		return minDiff;
	}

	public void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		if (prev != null)
			minDiff = Math.min(minDiff, root.val - prev.val);
		prev = root;
		inorder(root.right);
	}

}

/**
 * Java No In-order Traverse Solution, just pass upper bound and lower bound
 * 
 * Make use of the property of BST that value of nodes is bounded by their
 * "previous" and "next" node.
 * 
 */
class MinimumAbsoluteDifferenceinBSTInOrderSol3 {
	int minDiff = Integer.MAX_VALUE;

	public int getMinimumDifference(TreeNode root) {
		helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		return minDiff;
	}

	private void helper(TreeNode curr, int lb, int rb) {
		if (curr == null)
			return;
		if (lb != Integer.MIN_VALUE) {
			minDiff = Math.min(minDiff, curr.val - lb);
		}
		if (rb != Integer.MAX_VALUE) {
			minDiff = Math.min(minDiff, rb - curr.val);
		}
		helper(curr.left, lb, curr.val);
		helper(curr.right, curr.val, rb);
	}
}
