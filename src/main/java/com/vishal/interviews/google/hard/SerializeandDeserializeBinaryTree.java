package com.vishal.interviews.google.hard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 297. Serialize and Deserialize Binary Tree
 * 
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeandDeserializeBinaryTree {

	public static void main(String[] args) {

	}

}

/**
 * Easy to understand Java Solution
The idea is simple: print the tree in pre-order traversal and use "X" to denote null node and split node with ",". We can use a StringBuilder for building the string on the fly. For deserializing, we use a Queue to store the pre-order traversal and since we have "X" as null node, we know exactly how to where to end building subtress.
 */
class Codec {
	private static final String spliter = ",";
	private static final String NN = "X";

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		buildString(root, sb);
		return sb.toString();
	}

	private void buildString(TreeNode node, StringBuilder sb) {
		if (node == null) {
			sb.append(NN).append(spliter);
		} else {
			sb.append(node.val).append(spliter);
			buildString(node.left, sb);
			buildString(node.right, sb);
		}
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		Deque<String> nodes = new LinkedList<>();
		nodes.addAll(Arrays.asList(data.split(spliter)));
		return buildTree(nodes);
	}

	private TreeNode buildTree(Deque<String> nodes) {
		String val = nodes.remove();
		if (val.equals(NN))
			return null;
		else {
			TreeNode node = new TreeNode(Integer.valueOf(val));
			node.left = buildTree(nodes);
			node.right = buildTree(nodes);
			return node;
		}
	}
}

/**
 * Short and straight forward BFS Java code with a queue
Here I use typical BFS method to handle a binary tree. I use string n to represent null values. The string of the binary tree in the example will be "1 2 3 n n 4 5 n n n n ".

When deserialize the string, I assign left and right child for each not-null node, and add the not-null children to the queue, waiting to be handled later.
 */
class CodecBFS {
	public String serialize(TreeNode root) {
		if (root == null)
			return "";
		Queue<TreeNode> q = new LinkedList<>();
		StringBuilder res = new StringBuilder();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (node == null) {
				res.append("n ");
				continue;
			}
			res.append(node.val + " ");
			q.add(node.left);
			q.add(node.right);
		}
		return res.toString();
	}

	public TreeNode deserialize(String data) {
		if (data == "")
			return null;
		Queue<TreeNode> q = new LinkedList<>();
		String[] values = data.split(" ");
		TreeNode root = new TreeNode(Integer.parseInt(values[0]));
		q.add(root);
		for (int i = 1; i < values.length; i++) {
			TreeNode parent = q.poll();
			if (!values[i].equals("n")) {
				TreeNode left = new TreeNode(Integer.parseInt(values[i]));
				parent.left = left;
				q.add(left);
			}
			if (!values[++i].equals("n")) {
				TreeNode right = new TreeNode(Integer.parseInt(values[i]));
				parent.right = right;
				q.add(right);
			}
		}
		return root;
	}
}

class CodecDFSInterative {

   // Encodes a tree to a single string.
   public String serialize(TreeNode root) {
       StringBuilder sb=new StringBuilder();
       TreeNode x=root;
       Deque<TreeNode> stack=new LinkedList<>();
       while (x!=null || !stack.isEmpty()) {
           if (x!=null) {
               sb.append(String.valueOf(x.val));
               sb.append(' ');
               stack.push(x);
               x=x.left;
           }
           else {
               sb.append("null ");
               x=stack.pop();
               x=x.right;
           }
       }
       return sb.toString();
   }

   // Decodes your encoded data to tree.
   public TreeNode deserialize(String data) {
       if (data.length()==0) return null;
       String[] node=data.split(" ");
       int n=node.length;
       Deque<TreeNode> stack=new LinkedList<>();
       TreeNode root=new TreeNode(Integer.valueOf(node[0]));
       TreeNode x=root;
       stack.push(x);
       
       int i=1;
       while (i<n) {
           while (i<n && !node[i].equals("null")) {
               x.left=new TreeNode(Integer.valueOf(node[i++]));
               x=x.left;
               stack.push(x);
           }
           while (i<n && node[i].equals("null")) {
               x=stack.pop();
               i++;
           }
           if (i<n) {
               x.right=new TreeNode(Integer.valueOf(node[i++]));
               x=x.right;
               stack.push(x);
           }
       }
       return root;
   }
}

class CodecDFSRecursive {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		dfs(root, sb);
		return sb.toString();
	}

	private void dfs(TreeNode x, StringBuilder sb) {
		if (x == null) {
			sb.append("null ");
			return;
		}
		sb.append(String.valueOf(x.val));
		sb.append(' ');
		dfs(x.left, sb);
		dfs(x.right, sb);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] node = data.split(" ");
		int[] d = new int[1];
		return dfs(node, d);
	}

	private TreeNode dfs(String[] node, int[] d) {
		if (node[d[0]].equals("null")) {
			d[0]++;
			return null;
		}
		TreeNode x = new TreeNode(Integer.valueOf(node[d[0]]));
		d[0]++;
		x.left = dfs(node, d);
		x.right = dfs(node, d);
		return x;
	}
}

class CodecBFSRecursive {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null)
			return "";
		Queue<TreeNode> qu = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		qu.offer(root);
		sb.append(String.valueOf(root.val));
		sb.append(' ');
		while (!qu.isEmpty()) {
			TreeNode x = qu.poll();
			if (x.left == null)
				sb.append("null ");
			else {
				qu.offer(x.left);
				sb.append(String.valueOf(x.left.val));
				sb.append(' ');
			}
			if (x.right == null)
				sb.append("null ");
			else {
				qu.offer(x.right);
				sb.append(String.valueOf(x.right.val));
				sb.append(' ');
			}
		}
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data.length() == 0)
			return null;
		String[] node = data.split(" ");
		Queue<TreeNode> qu = new LinkedList<>();
		TreeNode root = new TreeNode(Integer.valueOf(node[0]));
		qu.offer(root);
		int i = 1;
		while (!qu.isEmpty()) {
			Queue<TreeNode> nextQu = new LinkedList<>();
			while (!qu.isEmpty()) {
				TreeNode x = qu.poll();
				if (node[i].equals("null"))
					x.left = null;
				else {
					x.left = new TreeNode(Integer.valueOf(node[i]));
					nextQu.offer(x.left);
				}
				i++;
				if (node[i].equals("null"))
					x.right = null;
				else {
					x.right = new TreeNode(Integer.valueOf(node[i]));
					nextQu.offer(x.right);
				}
				i++;
			}
			qu = nextQu;
		}
		return root;
	}
}
