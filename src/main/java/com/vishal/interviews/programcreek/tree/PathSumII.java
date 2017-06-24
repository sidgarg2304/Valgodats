package com.vishal.interviews.programcreek.tree;

import java.util.*;

import com.vishal.interviews.util.TreeNode;

public class PathSumII {

	public static void main(String[] args) {

	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();

		if (root == null) {
			return res;
		}
		
		List<Integer> temp = new ArrayList<>();
		temp.add(root.val);
		dfs(root, sum - root.val, temp, res);

		return res;
	}

	void dfs(TreeNode root, int sum, List<Integer> temp, List<List<Integer>> res) {

		if (root.left == null && root.right == null) {
			if (sum == 0) {
				res.add(new ArrayList<>(temp));
			}
		}

		if (root.left != null) {
			temp.add(root.left.val);
			dfs(root.left, sum - root.left.val, temp, res);
			temp.remove(temp.size() - 1);
		}

		if (root.right != null) {
			temp.add(root.right.val);
			dfs(root.right, sum - root.right.val, temp, res);
			temp.remove(temp.size() - 1);
		}

	}

	public List<List<Integer>> pathSumBFS(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();

		if (root == null) {
			return res;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		Queue<Integer> sums = new LinkedList<>();
		Queue<List<Integer>> paths = new LinkedList<>();

		queue.offer(root);
		sums.offer(root.val);
		List<Integer> path = new ArrayList<>();
		path.add(root.val);
		paths.offer(path);

		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			int curSum = sums.poll();
			List<Integer> curPath = paths.poll();

			if (cur.left == null && cur.right == null) {
				if (curSum == sum) {
					res.add(new ArrayList<>(curPath));
				}
			}

			if (cur.left != null) {
				queue.offer(cur.left);
				sums.offer(cur.left.val + curSum);
				List<Integer> path1 = new ArrayList<>();
				path1.addAll(curPath);
				path1.add(cur.left.val);
				paths.offer(path1);
			}

			if (cur.right != null) {
				queue.offer(cur.right);
				sums.offer(cur.right.val + curSum);

				List<Integer> path1 = new ArrayList<>();
				path1.addAll(curPath);
				path1.add(cur.left.val);
				paths.offer(path1);
			}

		}

		return res;

	}

}
