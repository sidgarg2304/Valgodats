package com.vishal.datastructures.binarysearchtree;

public class BinarySearchTreePrograms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isSubTree(BSTNode<Integer> t1, BSTNode<Integer> t2) {

		if (t1 == null) {
			return t2 == null;
		}

		if (t2.value < t1.value) {
			return isSubTree(t1.left, t2);
		} else if (t2.value > t1.value) {
			return isSubTree(t1.right, t2);
		} else {
			return isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
		}
	}

	static boolean isSame(BSTNode<Integer> t1, BSTNode<Integer> t2) {
		if (t1 == null) {
			return t2 == null;
		}
		return t1.value == t2.value && isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
	}

}
