package com.vishal.interviews.linkedin.medium;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static List<List<Integer>> zigZagLevel(TreeNode root) {

		List<List<Integer>> res = new ArrayList<>();

		Stack<TreeNode> curStack = new Stack<>();
		Stack<TreeNode> nextStack = new Stack<>();

		curStack.push(root);
		boolean right = true;

		List<Integer> layerRes = new ArrayList<>();
		while (curStack.isEmpty()) {
			TreeNode c = curStack.pop();
			layerRes.add(c.val);

			if (right) {
				nextStack.push(c.left);
				nextStack.push(c.right);
			} else {
				nextStack.push(c.right);
				nextStack.push(c.left);
			}

			if(curStack.isEmpty()){
				res.add(layerRes);
				layerRes = new ArrayList<>();
				curStack = nextStack;
				nextStack = new Stack<>();
				right = !right;
			}
		}

		return res;

	}

}
