package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

import com.vishal.interviews.util.TreeLinkNode;

public class PopulatingNextRightPointersinEachNode {

	public static void main(String[] args) {

	}

	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}

		Queue<TreeLinkNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			TreeLinkNode curLevel = null;
			for (int i = 0; i < size; i++) {
				TreeLinkNode cur = queue.poll();
				if (curLevel != null) {
					curLevel.next = cur;
				}
				
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
				
				curLevel = cur;
			}

		}
	}

}
