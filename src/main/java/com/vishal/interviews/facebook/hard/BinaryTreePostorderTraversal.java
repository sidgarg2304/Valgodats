package com.vishal.interviews.facebook.hard;

import java.util.*;

import com.vishal.interviews.util.TreeNode;

public class BinaryTreePostorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		
		if(root == null) {
			return res;
		}
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.isEmpty()){
			TreeNode cur = stack.pop();
			res.add(0, cur.val);
			
			if(cur.left != null) {
				stack.push(cur.left);
			}
			
			if(cur.right != null) {
				stack.push(cur.right);
			}
		}
		return res;
   }

}
