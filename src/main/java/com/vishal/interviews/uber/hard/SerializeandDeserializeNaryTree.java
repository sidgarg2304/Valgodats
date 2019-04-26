package com.vishal.interviews.uber.hard;

import java.util.*;

public class SerializeandDeserializeNaryTree {

	public static void main(String[] args) {

	}

	// Encodes a tree to a single string.
	public String serialize(Node root) {
		String res = serializehelper(root);
		return res.substring(0, res.length() - 1);

	}

	String serializehelper(Node root) {
		if (root == null) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		sb.append(root.val);
		sb.append(",");
		sb.append(root.children.size());
		sb.append(",");
		for (Node c : root.children) {
			sb.append(serialize(c));
		}
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public Node deserialize(String data) {
		if (data == null || data.isEmpty()) {
			return null;
		}
		
		String[] arr = data.split(",");
		Queue<String> queue = new LinkedList<>();
		for(String a: arr) {
			queue.offer(a);
		}
		return deserialize(queue);
	}
	
	Node deserialize(Queue<String> q) {
		
		if(q.isEmpty()) {
			return null;
		}
		
		Node root = new Node();
		root.val = Integer.parseInt(q.poll());
		int size = Integer.parseInt(q.peek());
		root.children = new ArrayList<>();
		for(int s = 0; s< size; s++) {
			root.children.add(deserialize(q));
		}
		
		return root;
	}

}

class Node {
	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
}
