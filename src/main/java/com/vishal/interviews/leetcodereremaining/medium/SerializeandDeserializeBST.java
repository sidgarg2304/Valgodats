package com.vishal.interviews.leetcodereremaining.medium;

import java.util.*;
import com.vishal.interviews.util.TreeNode;

public class SerializeandDeserializeBST {

	public static void main(String[] args) {

	}

	public String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			sb.append(cur.val + ",");
			if (cur.right != null) {
				stack.push(cur.right);
			}
			if (cur.left != null) {
				stack.push(cur.left);
			}
		}

		sb.deleteCharAt(sb.length() - 1);

		return sb.toString();
	}

	public TreeNode deserialize(String data) {
		if (data == null || data.length() == 0) {
			return null;
		}

		String[] arr = data.split(",");
		Queue<Integer> q = new LinkedList<>();
		for(String s: arr){
			q.offer(Integer.parseInt(s));
		}
		return constructTree(arr, q);
	}

	public TreeNode constructTree(String[] arr, Queue<Integer> q) {
		
		if(q.isEmpty()){
			return null;
		}
		TreeNode root = new TreeNode(q.poll());
		
		Queue<Integer> left = new LinkedList<>();
		while(!q.isEmpty() && q.peek()< root.val) {
			left.offer(q.poll());
		}
		
		root.left = constructTree(arr, left);
		root.right = constructTree(arr, q);
		
		return root;
	}

}
