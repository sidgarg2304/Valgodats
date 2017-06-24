package com.vishal.interviews.programcreek.tree;

import java.util.*;

import com.vishal.interviews.util.TreeNode;

public class InvertBinaryTree {

	public static void main(String[] args) {

	}

	public TreeNode invertTree(TreeNode root) {

		if(root == null){
			return root;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			TreeNode l = cur.left;
			TreeNode r = cur.right;

			cur.right = l;
			cur.left = r;

			if (l != null) {
				queue.offer(l);
			}

			if (r != null) {
				queue.offer(r);
			}

		}
		return root;
	}

}
