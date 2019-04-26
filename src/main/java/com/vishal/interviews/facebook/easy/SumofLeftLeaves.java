package com.vishal.interviews.facebook.easy;

import java.util.*;
/**
 * 404. Sum of Left Leaves
 * 
 * Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 *
 */
public class SumofLeftLeaves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int sumOfLeftLeaves(TreeNode root) {
      
      if(root == null){
          return 0;
      }

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int res = 0;
		while (!queue.isEmpty()) {
			TreeNode c = queue.poll();
			if (c.left != null) {
				if (c.left.left == null && c.left.right == null) {
					res += c.left.val;
				}else {
					queue.offer(c.left);
				}
			}

			if (c.right != null) {
				queue.offer(c.right);
			}
		}

		return res;		
	}

	int sumOfLeftLeaves(TreeNode root, boolean leftChild) {
	    
	    if(root == null){
	        return 0;
	    }

		if (root.left == null && root.right == null) {
			if (leftChild) {
				return root.val;
			}
			return 0;
		}
		return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);

	}

}
