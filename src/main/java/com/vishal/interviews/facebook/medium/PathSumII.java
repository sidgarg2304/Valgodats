package com.vishal.interviews.facebook.medium;

import java.util.ArrayList;
import java.util.List;


public class PathSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();

		if(root == null) {
			return res;
		}
		
		dfs(root, 0, sum, new ArrayList<>(), res);
		return res;
	}

	void dfs(TreeNode root, int target, int sum, List<Integer> temp, List<List<Integer>> res) {

		if (root == null) {
			return;
		}

		target += root.val;

		if (root.left == null && root.right == null) {
			if (target == sum) {
				res.add(new ArrayList<>(temp));
			}
			return;
		}

		temp.add(root.val);
		dfs(root.left, target, sum, temp, res);
		dfs(root.right, target, sum, temp, res);
		temp.remove(temp.size() - 1);
	}

}
