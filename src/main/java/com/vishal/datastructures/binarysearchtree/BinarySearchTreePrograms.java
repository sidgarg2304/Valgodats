package com.vishal.datastructures.binarysearchtree;

import com.vishal.datastructures.linkedlist.ListNode;

public class BinarySearchTreePrograms {

	public static void main(String[] args) {
		testsortedListToBST();
	}
	
	public static void testsortedListToBST(){
		ListNode<Integer> root1 = new ListNode<>(1);
		ListNode<Integer> root2 = new ListNode<>(2);
		ListNode<Integer> root3 = new ListNode<>(3);
		ListNode<Integer> root4 = new ListNode<>(4);
		ListNode<Integer> root5 = new ListNode<>(5);
		root1.setNext(root2);
		root2.setNext(root3);
		root3.setNext(root4);
		root4.setNext(root5);
		
		BSTNode<Integer> root = sortedListToBST(root1);
		BinarySearchTreePrinter.printNode(root);
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

	static BSTNode<Integer> commonAncestor(BSTNode<Integer> root, BSTNode<Integer> n1, BSTNode<Integer> n2) {

		if (root == null) {
			return null;
		}

		if ((n1.value < root.value && n2.value > root.value) || (n1.value > root.value && n2.value < root.value)) {
			return root;
		}

		BSTNode<Integer> left = commonAncestor(root.left, n1, n2);

		if (left != null) {
			return left;
		}

		return commonAncestor(root.right, n1, n2);
	}
	
	static ListNode<Integer> h = null;
	public static BSTNode<Integer> sortedListToBST(ListNode<Integer> head) {
		if (head == null)
			return null;
 
		h = head;
		int len = getLength(head);
		return sortedListToBST(0, len - 1);
	}
	
// get list length
	public static int getLength(ListNode<Integer> head) {
		int len = 0;
		ListNode<Integer> p = head;
 
		while (p != null) {
			len++;
			p = p.getNext();
		}
		return len;
	}
 
	// build tree bottom-up
	public static BSTNode<Integer> sortedListToBST(int start, int end) {
		if (start > end)
			return null;
 
		// mid
		int mid = (start + end) / 2;
 
		BSTNode<Integer> left = sortedListToBST(start, mid - 1);
		BSTNode<Integer> root = new BSTNode<Integer>(h.getValue());
		System.out.println("root val " + h.getValue());
		h = h.getNext();
		BSTNode<Integer> right = sortedListToBST(mid + 1, end);
		
		if(left != null){
			System.out.println("left val " + left.getValue());	
		}
		if(right != null){
			System.out.println("right val " + right.getValue());	
		}
		root.setLeft(left);
		root.setRight(right);
 
		return root;
	}

}
