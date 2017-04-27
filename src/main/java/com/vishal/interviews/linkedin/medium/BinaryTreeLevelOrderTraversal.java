package com.vishal.interviews.linkedin.medium;

import java.util.*;

import com.vishal.interviews.linkedin.util.TreeNode;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]*
 */
public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {

	}
	
	static List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> res = new ArrayList<>();

		if (root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			List<Integer> curRes = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
				
				curRes.add(cur.val);
			}
			res.add(curRes);
		}
		return res;
	}

}

