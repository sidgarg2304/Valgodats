package com.vishal.datastructures.graph;

import java.util.*;

public class DisjointSet {

	class Node {
		int rank;
		Node parent;
		int data;
	}

	Map<Integer, Node> map;

	public DisjointSet() {
		map = new HashMap<>();
	}

	public static void main(String[] args) {

	}

	public void makeSet(int val) {
		Node n = new Node();
		n.data = val;
		n.parent = n;
		n.rank = 0;
		map.put(val, n);
	}

	public void union(int val1, int val2) {
		Node p1 = find(map.get(val1));
		Node p2 = find(map.get(val2));

		if (p1.data == p2.data) {
			return;
		}
		if (p1.rank >= p2.rank) {
			p1.rank = (p2.rank == p1.rank) ? p1.rank + 1 : p1.rank;
			p2.parent = p1;

		} else {
			p1.parent = p2;
		}
	}

	public Node find(Node n) {		
		if (n == n.parent) {
			return n;
		}

		n.parent = find(n.parent);
		return n.parent;
	}
}
