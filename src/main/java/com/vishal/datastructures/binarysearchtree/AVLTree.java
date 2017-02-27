package com.vishal.datastructures.binarysearchtree;

public class AVLTree {

	BSTNode<Integer> avlInsert(BSTNode<Integer> root, int val) {
				
		if (root == null) {
			return new BSTNode<Integer>(val);
		} else if (root.value > val) {
			root.setLeft(avlInsert(root.left, val));
		} else {
			root.setRight(avlInsert(root.right, val));
		}

		int leftHeight = root.getLeft().getHeight();
		int rightHeight = root.getRight().getHeight();
		int diff = leftHeight - rightHeight;
		if (diff > 1) {
			// left > right
			if (root.getLeft().getLeft().getHeight() > root.getLeft().getRight().getHeight()) {
				// Left Left case
				return rotateRight(root);
			} else {
				// Left right case
				root.setLeft(rotateLeft(root.getLeft()));
				return rotateRight(root);
			}
		} else if (diff < -1) {

			if (root.getRight().getRight().getHeight() > root.getRight().getLeft().getHeight()) {
				// right right case
				return rotateLeft(root);
			} else {
				// right Left case
				root.setRight(rotateRight(root.getRight()));
				return rotateLeft(root);
			}

		}
		root.setHeight((1 + Math.max(root.getLeft().getHeight(), root.getRight().getHeight())));
		return root;

	}

	public BSTNode<Integer> rotateRight(BSTNode<Integer> root) {
		BSTNode<Integer> newRoot = root.left;
		root.setLeft(newRoot.right);
		newRoot.setRight(root);

		root.setHeight(1 + Math.max(root.left.height, root.right.height));
		newRoot.setHeight(1 + Math.max(newRoot.left.height, newRoot.right.height));

		return newRoot;
	}

	public BSTNode<Integer> rotateLeft(BSTNode<Integer> root) {
		BSTNode<Integer> newRoot = root.right;
		root.setRight(newRoot.left);
		newRoot.setLeft(root);

		root.setHeight(1 + Math.max(root.left.height, root.right.height));
		newRoot.setHeight(1 + Math.max(newRoot.left.height, newRoot.right.height));

		return newRoot;
	}
}
