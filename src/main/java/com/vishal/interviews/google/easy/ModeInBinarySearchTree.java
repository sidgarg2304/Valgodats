package com.vishal.interviews.google.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 501
 * 
 * 
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the
 * most frequently occurred element) in the given BST.
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than or equal
 * to the node's key. The right subtree of a node contains only nodes with keys
 * greater than or equal to the node's key. Both the left and right subtrees
 * must also be binary search trees. For example: Given BST [1,null,2,2], 1 \ 2
 * / 2 return [2].
 * 
 * Note: If a tree has more than one mode, you can return them in any order.
 * 
 * Follow up: Could you do that without using any extra space? (Assume that the
 * implicit stack space incurred due to recursion does not count).
 * 
 * @author vkotha
 *
 */
public class ModeInBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/**
 * Solution1
 * 
 * @author vkotha
 *
 */
class Solution1 {

	public int[] findMode(TreeNode root) {
		inorder(root);
		modes = new int[modeCount];
		modeCount = 0;
		currCount = 0;
		inorder(root);
		return modes;
	}

	private int currVal;
	private int currCount = 0;
	private int maxCount = 0;
	private int modeCount = 0;

	private int[] modes;

	private void handleValue(int val) {
		if (val != currVal) {
			currVal = val;
			currCount = 0;
		}
		currCount++;
		if (currCount > maxCount) {
			maxCount = currCount;
			modeCount = 1;
		} else if (currCount == maxCount) {
			if (modes != null)
				modes[modeCount] = currVal;
			modeCount++;
		}
	}

	private void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		handleValue(root.val);
		inorder(root.right);
	}
}

/**
 * Solution2
 */
class Solution2 {
	private int currVal;
	private int currCount = 0;
	private int maxCount = 0;
	private int modeCount = 0;
	private int[] modes;

	private void inorderSolution2(TreeNode root) {
		TreeNode node = root;
		modes = new int[modeCount];
		while (node != null) {
			if (node.left == null) {
				handleValue(node.val);
				node = node.right;
			} else {
				TreeNode prev = node.left;
				while (prev.right != null && prev.right != node)
					prev = prev.right;
				if (prev.right == null) {
					prev.right = node;
					node = node.left;
				} else {
					prev.right = null;
					handleValue(node.val);
					node = node.right;
				}
			}
		}
	}

	private void handleValue(int val) {
		if (val != currVal) {
			currVal = val;
			currCount = 0;
		}
		currCount++;
		if (currCount > maxCount) {
			maxCount = currCount;
			modeCount = 1;
		} else if (currCount == maxCount) {
			if (modes != null)
				modes[modeCount] = currVal;
			modeCount++;
		}
	}
}

/**
 * Solution3
 * 
 * @author vkotha
 *
 */
class Solution3 {
	Integer prev = null;
	int count = 1;
	int max = 0;

	public int[] findMode(TreeNode root) {
		if (root == null)
			return new int[0];

		List<Integer> list = new ArrayList<>();
		traverse(root, list);

		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); ++i)
			res[i] = list.get(i);
		return res;
	}

	private void traverse(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		traverse(root.left, list);
		if (prev != null) {
			if (root.val == prev)
				count++;
			else
				count = 1;
		}
		if (count > max) {
			max = count;
			list.clear();
			list.add(root.val);
		} else if (count == max) {
			list.add(root.val);
		}
		prev = root.val;
		traverse(root.right, list);
	}
}

/**
 * Solution4
 * 
 * @author vkotha
 *
 */
class Solution4 {
	Map<Integer, Integer> map;
	int max = 0;

	public int[] findMode(TreeNode root) {
		if (root == null)
			return new int[0];
		this.map = new HashMap<>();

		inorder(root);

		List<Integer> list = new LinkedList<>();
		for (int key : map.keySet()) {
			if (map.get(key) == max)
				list.add(key);
		}

		int[] res = new int[list.size()];
		for (int i = 0; i < res.length; i++)
			res[i] = list.get(i);
		return res;
	}

	private void inorder(TreeNode node) {
		if (node.left != null)
			inorder(node.left);
		map.put(node.val, map.getOrDefault(node.val, 0) + 1);
		max = Math.max(max, map.get(node.val));
		if (node.right != null)
			inorder(node.right);
	}
}