package com.vishal.interviews.top100linkedquestions.hard;

import java.util.*;

import com.vishal.interviews.util.TreeNode;

public class SerializeandDeserializeBinaryTree {

	public static void main(String[] args) {

	}

	public String serialize(TreeNode root) {

		if (root == null) {
			return "#";
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		StringBuilder sb = new StringBuilder();

		while (!queue.isEmpty()) {
			TreeNode c = queue.poll();
			if (c == null) {
				sb.append("#,");
				continue;
			}

			sb.append(c.val + ",");

			queue.offer(c.left);
			queue.offer(c.right);
		}

		sb.deleteCharAt(sb.length() - 1);

		return sb.toString();
	}

	public TreeNode deserialize(String data) {
      if(data == null || data.length() == 0 || data.equals("#")){
			return null;
		}
      String[] arr = data.split(",");
      TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
      int p = 1;
      
      Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
      
		while(!queue.isEmpty()){
			TreeNode c = queue.poll();
			String left = arr[p++];
			String right = arr[p++];
			
			if(!left.equals("#")){
				c.left = new TreeNode(Integer.parseInt(left));
				queue.offer(c.left);
			}
			
			if(!right.equals("#")){
				c.left = new TreeNode(Integer.parseInt(right));
				queue.offer(c.right);
			}
		}
		
		return root;
	}

}
