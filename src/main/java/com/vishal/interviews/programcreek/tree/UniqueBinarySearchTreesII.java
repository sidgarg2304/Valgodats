package com.vishal.interviews.programcreek.tree;

import java.util.*;

import com.vishal.interviews.util.TreeNode;

public class UniqueBinarySearchTreesII {

	public static void main(String[] args) {

	}

	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> res = new ArrayList<>();

		if (n == 0) {
			return res;
		}

		return generateTrees(1, n);
	}

	public List<TreeNode> generateTrees(int m, int n) {

		List<TreeNode> res = new ArrayList<>();

		if (m > n) {
			res.add(null);
			return res;
		}

		for (int i = m; i <= n; i++) {
			List<TreeNode> lRes = generateTrees(m, i - 1);
			List<TreeNode> rRes = generateTrees(i + 1, n);

			for (TreeNode l : lRes) {
				for (TreeNode r : rRes) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					res.add(root);
				}
			}
		}

		return res;
	}

}
