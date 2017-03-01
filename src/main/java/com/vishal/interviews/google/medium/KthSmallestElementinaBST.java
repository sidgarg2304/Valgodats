package com.vishal.interviews.google.medium;

import java.util.Stack;

/**
 * 230. Kth Smallest Element in a BST
 * 
 * Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it.
 * 
 * Note:
 * 
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
 * Follow up:
 * 
 * What if the BST is modified (insert/delete operations) often and you need to
 * find the kth smallest frequently? How would you optimize the kthSmallest
 * routine?
 * 
 * Hint:
 * 
 * 1. Try to utilize the property of a BST.
 * 
 * 2. What if you could modify the BST node's structure?
 * 
 * 3. The optimal runtime complexity is O(height of BST).
 */
public class KthSmallestElementinaBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Binary Search (dfs): most preferable
	 * 
	 * @param root
	 * @param k
	 * @return
	 */
	public int kthSmallestDFSPreferred(TreeNode root, int k) {
		int count = countNodes(root.left);
		if (k <= count) {
			return kthSmallestDFSPreferred(root.left, k);
		} else if (k > count + 1) {
			return kthSmallestDFSPreferred(root.right, k - 1 - count); // 1 is
																						  // counted
																						  // as
			// current node
		}

		return root.val;
	}

	public int countNodes(TreeNode n) {
		if (n == null)
			return 0;

		return 1 + countNodes(n.left) + countNodes(n.right);
	}

	// better keep these two variables in a wrapper class
	private static int number = 0;
	private static int count = 0;

	public int kthSmallestDFSInorderRecursive(TreeNode root, int k) {
		count = k;
		helper(root);
		return number;
	}

	public void helper(TreeNode n) {
		if (n.left != null)
			helper(n.left);
		count--;
		if (count == 0) {
			number = n.val;
			return;
		}
		if (n.right != null)
			helper(n.right);
	}

	public int kthSmallestDFSInorderIterative(TreeNode root, int k) {
		Stack<TreeNode> st = new Stack<>();

		while (root != null) {
			st.push(root);
			root = root.left;
		}

		while (k != 0) {
			TreeNode n = st.pop();
			k--;
			if (k == 0)
				return n.val;
			TreeNode right = n.right;
			while (right != null) {
				st.push(right);
				right = right.left;
			}
		}

		return -1; // never hit if k is valid
	}

	static int count1 = 0;
	int result = Integer.MIN_VALUE;

	public int kthSmallestInorderRecursive(TreeNode root, int k) {
		traverse(root, k);
		return result;
	}

	public void traverse(TreeNode root, int k) {
		if (root == null)
			return;
		traverse(root.left, k);
		count1++;
		if (count1 == k)
			result = root.val;
		traverse(root.right, k);
	}

	public int kthSmallestInorderIterative(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		int count = 0;

		while (!stack.isEmpty() || p != null) {
			if (p != null) {
				stack.push(p); // Just like recursion
				p = p.left;

			} else {
				TreeNode node = stack.pop();
				if (++count == k)
					return node.val;
				p = node.right;
			}
		}

		return Integer.MIN_VALUE;
	}

}

/**
 * What if you could modify the BST node's structure?
 * 
 * If we could add a count field in the BST node class, it will take O(n) time
 * when we calculate the count value for the whole tree, but after that, it will
 * take O(logn) time when insert/delete a node or calculate the kth smallest
 * element.
 * 
 *
 */
class kthSmallestWithModifyingBSTNodestructure {
	public int kthSmallest(TreeNode root, int k) {
		TreeNodeWithCount rootWithCount = buildTreeWithCount(root);
		return kthSmallest(rootWithCount, k);
	}

	private TreeNodeWithCount buildTreeWithCount(TreeNode root) {
		if (root == null)
			return null;
		TreeNodeWithCount rootWithCount = new TreeNodeWithCount(root.val);
		rootWithCount.left = buildTreeWithCount(root.left);
		rootWithCount.right = buildTreeWithCount(root.right);
		if (rootWithCount.left != null)
			rootWithCount.count += rootWithCount.left.count;
		if (rootWithCount.right != null)
			rootWithCount.count += rootWithCount.right.count;
		return rootWithCount;
	}

	private int kthSmallest(TreeNodeWithCount rootWithCount, int k) {
		if (k <= 0 || k > rootWithCount.count)
			return -1;
		if (rootWithCount.left != null) {
			if (rootWithCount.left.count >= k)
				return kthSmallest(rootWithCount.left, k);
			if (rootWithCount.left.count == k - 1)
				return rootWithCount.val;
			return kthSmallest(rootWithCount.right, k - 1 - rootWithCount.left.count);
		} else {
			if (k == 1)
				return rootWithCount.val;
			return kthSmallest(rootWithCount.right, k - 1);
		}
	}

	class TreeNodeWithCount {
		int val;
		int count;
		TreeNodeWithCount left;
		TreeNodeWithCount right;

		TreeNodeWithCount(int x) {
			val = x;
			count = 1;
		};
	}
}
