package com.vishal.interviews.facebook.hard;

import java.util.*;

public class SerializeandDeserializeNaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
// Encodes a tree to a single string.
	public String serialize(Node root) {
        if(root == null) {
            return "";
        }
		String s = serializeHelper(root);
		return s.substring(0, s.length() - 1);
	}

	String serializeHelper(Node root) {
		if (root == null)
			return "";
		StringBuilder sb = new StringBuilder();
		sb.append(root.val);
		sb.append(",");
		sb.append(root.children.size());
		sb.append(",");
		for (Node c : root.children) {
			sb.append(serializeHelper(c));
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
		for (String s : arr) {
			queue.offer(s);
		}

		return deserializeHelper(queue);
	}

	Node deserializeHelper(Queue<String> q) {

		if (q.isEmpty()) {
			return null;
		}

		Node root = new Node();
        root.val = Integer.parseInt(q.poll());
		int size = Integer.parseInt(q.poll());
		
		root.children = new ArrayList<>();
		for(int i = 0; i< size; i++) {
			root.children.add(deserializeHelper(q));
		}
		return root;
	}
	
	class Node {
		int val;
		List<Node> children;

		Node(int val, List<Node> c) {
			this.val = val;
			this.children = c;
		}

		Node() {
			
		}
	}

}
