package com.vishal.datastructures.binarytree;

import java.util.Arrays;

import com.vishal.datastructures.doublelinkedlist.DListNode;

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

	static BTNode<Integer> leastCommonAncestor(BTNode<Integer> root, BTNode<Integer> n1, BTNode<Integer> n2) {

		if (root == null || root == n1 || root == n2) {
			return root;
		}

		BTNode<Integer> left = leastCommonAncestor(root.left, n1, n2);
		BTNode<Integer> right = leastCommonAncestor(root.right, n1, n2);

		if (left != null && right != null) {
			return root;
		} else if (left == null && right == null) {
			return null;
		} else {
			return left != null ? left : right;
		}

	}

	//  5
	// / \
	// / \
	// 2  8
	/// \ / \
	//1 3 6 9
	
	// >--------------------------------->
	// <-1-> 2 -> 3 -> 5 -> 6 -> 8 -> 9 ->
	// <----------------------------------

	public static DListNode<Integer> convertBinaryTreeToCircularDoubleLinkedList(BTNode<Integer> root) {

		if (root == null) {
			return null;
		}

		DListNode<Integer> dListRoot = new DListNode<>(root.getValue());

		DListNode<Integer> dListLeft = convertBinaryTreeToCircularDoubleLinkedList(root.getLeft());
		DListNode<Integer> dListRight = convertBinaryTreeToCircularDoubleLinkedList(root.getRight());

		if (dListLeft == null && dListRight == null) {
			dListRoot.setNext(dListRoot);
			dListRoot.setPrev(dListRoot);
		} else if (dListLeft == null) {

			// dListRoot 6
			// dListRight //7

			DListNode<Integer> dListRightEnd = dListRight.getPrev(); // 9
			DListNode<Integer> dListRightStart = dListRight; // 7

			dListRoot.setNext(dListRightStart); // 6 -> 7
			dListRightStart.setPrev(dListRoot); // 6 <- 7

			dListRightEnd.setNext(dListRoot); // 9 -> 6
			dListRoot.setPrev(dListRightEnd); // 9 <- 6

		} else if (dListRight == null) {

			DListNode<Integer> dListLeftEnd = dListLeft.getPrev(); // 7
			DListNode<Integer> dListLeftStart = dListLeft; // 9

			dListLeftEnd.setNext(dListRoot);
			dListRoot.setPrev(dListLeftEnd);

			dListLeftStart.setPrev(dListRoot);
			dListRoot.setNext(dListLeftStart);

		} else {
			DListNode<Integer> dListLeftEnd = dListLeft.getPrev(); // 2
			DListNode<Integer> dListRightStart = dListRight; // 6
			DListNode<Integer> dListRightEnd = dListRightStart.getPrev(); // 9
			DListNode<Integer> dListLeftStart = dListLeft;

			dListLeftEnd.setNext(dListRoot); // 2 -> 5
			dListRoot.setPrev(dListLeftEnd); // 2 <- 5

			dListRoot.setNext(dListRightStart); // 5 -> 6
			dListRightStart.setPrev(dListRoot); // 5 <- 6

			dListLeftStart.setPrev(dListRightEnd); // 9 <- 1
			dListRightEnd.setNext(dListLeftStart); // 9 -> 1

			return dListLeft;
		}

		return dListRoot;
	}

}
