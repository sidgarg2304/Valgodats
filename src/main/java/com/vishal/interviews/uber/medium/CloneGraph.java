package com.vishal.interviews.uber.medium;

import java.util.*;

public class CloneGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Node cloneGraph(Node node) {

		if(node == null) {
			return null;
		}
		Node cloneRoot = new Node(node.val, new ArrayList<>());
		Map<Node, Node> map = new HashMap<>();
		map.put(node, cloneRoot);

		Queue<Node> queue = new LinkedList<>();
		queue.offer(node);

		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			Node cloneNode = map.get(cur);

			for (Node ne : cur.neighbors) {
				Node cloneNe = map.get(ne);
				if (cloneNe == null) {
					cloneNe = new Node(ne.val, new ArrayList<>());
					queue.offer(ne);
					map.put(ne, cloneNe);
				}
				cloneNode.neighbors.add(cloneNe);
			}
		}
		return cloneRoot;
	}

	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
		}

		public Node(int _val, List<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

}
