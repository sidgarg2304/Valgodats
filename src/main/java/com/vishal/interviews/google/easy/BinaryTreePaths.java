package com.vishal.interviews.google.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 257. Binary Tree Paths
 * 
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * For example, given the following binary tree:
 * 
 * 1
 * 
 * / \
 * 
 * 2 3
 * 
 * \ 5
 * 
 * All root-to-leaf paths are:
 * 
 * ["1->2->5", "1->3"]
 */
public class BinaryTreePaths {

	public static void main(String[] args) {

	}

	/**
	 * Accepted Java simple solution in 8 lines
	 * 
	 * @param root
	 * @return
	 */
	public List<String> binaryTreePathsAccepted(TreeNode root) {
		List<String> answer = new ArrayList<String>();
		if (root != null)
			searchBT(root, "", answer);
		return answer;
	}

	private void searchBT(TreeNode root, String path, List<String> answer) {
		if (root.left == null && root.right == null)
			answer.add(path + root.val);
		if (root.left != null)
			searchBT(root.left, path + root.val + "->", answer);
		if (root.right != null)
			searchBT(root.right, path + root.val + "->", answer);
	}

	/**
	 * Clean Java solution (Accepted) without any helper recursive function
	 * 
	 * Lot of recursive solutions on this forum involves creating a helper
	 * recursive function with added parameters. The added parameter which
	 * usually is of the type List<String> , carries the supplementary path
	 * information. However, the approach below doesn't use such a helper
	 * function.
	 * 
	 * @param root
	 * @return
	 */
	public List<String> binaryTreePathsWithoutHelperRecursive(TreeNode root) {

		List<String> paths = new LinkedList<>();

		if (root == null)
			return paths;

		if (root.left == null && root.right == null) {
			paths.add(root.val + "");
			return paths;
		}

		for (String path : binaryTreePathsWithoutHelperRecursive(root.left)) {
			paths.add(root.val + "->" + path);
		}

		for (String path : binaryTreePathsWithoutHelperRecursive(root.right)) {
			paths.add(root.val + "->" + path);
		}

		return paths;

	}

}
