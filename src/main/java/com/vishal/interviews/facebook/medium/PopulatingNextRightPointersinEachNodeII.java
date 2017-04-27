package com.vishal.interviews.facebook.medium;

import java.util.*;
import com.vishal.interviews.util.TreeLinkNode;

/**
 * 117. Populating Next Right Pointers in Each Node II
 * 
 * 
 * Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 *
 */
public class PopulatingNextRightPointersinEachNodeII {

	public static void main(String[] args) {

		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);

		connect(root);
	}

	public static void connect(TreeLinkNode root) {
		
		if(root == null){
         return;
     }
		
		Queue<TreeLinkNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			TreeLinkNode level = null;
			for (int i = 0; i < size; i++) {
				TreeLinkNode cur = queue.poll();
				System.out.println(cur.val);
				if (i == 0) {
					level = cur;
				} else {
					level.next = cur;
				}
				level = level.next;

				if (cur.left != null) {
					queue.offer(cur.left);
				}

				if (cur.right != null) {
					queue.offer(cur.right);
				}

			}
		}

	}

}
