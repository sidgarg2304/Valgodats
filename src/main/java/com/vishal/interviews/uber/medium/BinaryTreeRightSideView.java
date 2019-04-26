package com.vishal.interviews.uber.medium;

import com.vishal.interviews.util.TreeNode;

import java.util.*;

public class BinaryTreeRightSideView {

	public static void main(String[] args) {

	}

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();

		if(root == null) {
			return res;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				TreeNode cur = queue.poll();
				if(s == size - 1) {
					res.add(cur.val);
				}
				
				if(cur.left != null) {
					queue.offer(cur.left);
				}
				
				if(cur.right != null) {
					queue.offer(cur.right);
				}
			}
		}
		
		return res;
	}

}
