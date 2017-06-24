package com.vishal.datastructures.ternary;

public class TernarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	TernaryNode root;

	TernarySearchTree() {
		root = new TernaryNode();
	}

	void insert(String s) {

		insert(s, 0, root);
	}

	void insert(String s, int pos, TernaryNode node) {

		if (node == null) {
			node = new TernaryNode();
			node.c = s.charAt(pos);
		}

		if (s.charAt(pos) < node.c) {
			insert(s, pos, node.left);
		} else if (s.charAt(pos) > node.c) {
			insert(s, pos, node.right);
		} else {
			if (pos == s.length() - 1) {
				node.isWord = true;
			} else {
				insert(s, pos + 1, node.center);
			}
		}
	}

}
