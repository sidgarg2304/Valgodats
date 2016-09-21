package com.vishal.datastructures.binarytree;

public class BinaryTreePrograms {

	public static void main(String[] args) {
		BTNode<Integer> bstRoot = constructBST();

		System.out.println("is bst recursive is " + isBSTRecursive(bstRoot));
		System.out.println("is bst recursive is " + isBSTMinMax(bstRoot));
	}

	public static boolean isBSTRecursive(BTNode<Integer> root) {
		if (root == null) {
			return true;
		}

		if ((root.left != null && root.left.value > root.value)
				|| (root.right != null && root.right.value < root.value)) {
			return false;
		}

		return isBSTRecursive(root.left) && isBSTRecursive(root.right);
	}

	public static boolean isBSTMinMax(BTNode<Integer> root) {
		return isMinMaxHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isMinMaxHelper(BTNode<Integer> p, int min, int max) {
		if (p == null) {
			return true;
		}
		if (p.value < min || p.value > max) {
			return false;
		}

		return isMinMaxHelper(p.left, min, p.value) && isMinMaxHelper(p.right, p.value, max);
	}

	public static BTNode<Integer> constructBST() {
		BTNode<Integer> root = new BTNode<Integer>(5);
		root.left = new BTNode<Integer>(2);
		root.right = new BTNode<Integer>(8);

		root.left.left = new BTNode<Integer>(1);
		root.left.right = new BTNode<Integer>(3);

		root.right.left = new BTNode<Integer>(6);
		root.right.right = new BTNode<Integer>(9);

		return root;
	}

}

class BTNode<T> {

	public BTNode(T value) {
		this.value = value;
	}

	T value;
	BTNode<T> left;
	BTNode<T> right;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public BTNode<T> getLeft() {
		return left;
	}

	public void setLeft(BTNode<T> left) {
		this.left = left;
	}

	public BTNode<T> getRight() {
		return right;
	}

	public void setRight(BTNode<T> right) {
		this.right = right;
	}
}
