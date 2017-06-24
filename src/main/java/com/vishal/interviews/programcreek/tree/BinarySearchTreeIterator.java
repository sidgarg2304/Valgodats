package com.vishal.interviews.programcreek.tree;

import java.util.*;

import com.vishal.interviews.util.TreeNode;

public class BinarySearchTreeIterator {

	Stack<TreeNode> stack;

	public static void main(String[] args) {

	}

	BinarySearchTreeIterator(TreeNode root) {
		stack = new Stack<>();
		TreeNode p = root;
		while (p != null) {
			stack.push(p);
			p = p.left;
		}
	}
	
	int next(){
		TreeNode r = stack.pop();
		
		if(r.right != null){
			TreeNode p = r.right;
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
		}
		
		return r.val;
	}

	boolean isEmpty() {
		return stack.isEmpty();
	}

}
