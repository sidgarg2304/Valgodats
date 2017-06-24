package com.vishal.interviews.programcreek.tree;

import java.util.*;

import com.vishal.interviews.util.TreeNode;

public class BinaryTreePaths {

	public static void main(String[] args) {

	}

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();

		dfs(root, "" + root.val, res);

		return res;
	}

	void dfs(TreeNode root, String cur, List<String> res) {

		if (root.left == null && root.right == null) {
			res.add(cur);
			return;
		}
		
		if(root.left != null){
			dfs(root.left, cur + "->" + root.left.val, res);
		}
		
		if(root.right != null){
			dfs(root.right, cur + "->" + root.right.val, res);
		}
	}

}
