package com.vishal.interviews.programcreek.tree;

import java.util.*;

import com.vishal.interviews.util.ListNode;
import com.vishal.interviews.util.TreeNode;

public class LevelOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();

		if (root == null) {
			return res;
		}

		Queue<TreeNode> queue = new LinkedList<>();

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				temp.add(cur.val);

				if (cur.left != null) {
					queue.offer(cur.left);
				}

				if (cur.right != null) {
					queue.offer(cur.right);
				}
			}
			res.add(temp);
		}
		return res;
	}

}
