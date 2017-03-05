package com.vishal.interviews.google.medium;

import com.vishal.datastructures.linkedlist.ListNode;

/**
 * 369. Plus One Linked List
 * 
 * Given a non-negative integer represented as non-empty a singly linked list of
 * digits, plus one to the integer.
 * 
 * You may assume the integer do not contain any leading zero, except the number
 * 0 itself.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 * 
 * Example:
 * 
 * Input:
 * 
 * 1->2->3
 * 
 * Output:
 * 
 * 1->2->4
 */
public class PlusOneLinkedList {

	public static void main(String[] args) {

	}

	/**
	 * Iterative Two-Pointers with dummy node Java O(n) time, O(1) space
	 * 
	 * i stands for the most significant digit that is going to be incremented if
	 * there exists a carry
	 * 
	 * dummy node can handle cases such as "9->9>-9" automatically
	 * 
	 * @param head
	 * @return
	 */
	public ListNode<Integer> plusOne(ListNode<Integer> head) {
		ListNode<Integer> dummy = new ListNode(0);
		dummy.next = head;
		ListNode<Integer> i = dummy;
		ListNode<Integer> j = dummy;

		while (j.next != null) {
			j = j.next;
			if (j.value != 9) {
				i = j;
			}
		}

		if (j.value != 9) {
			j.value++;
		} else {
			i.value++;
			i = i.next;
			while (i != null) {
				i.value = 0;
				i = i.next;
			}
		}

		if (dummy.value == 0) {
			return dummy.next;
		}

		return dummy;
	}

	/**
	 * At the first glance, I want to reverse the inputs, add one, then reverse
	 * back. But that is too intuitive and I don't think this is an expected
	 * solution. Then what kind of alg would adding one in reverse way for list?
	 * 
	 * Recursion! With recursion, we can visit list in reverse way! So here is my
	 * recursive solution.
	 * 
	 * @param head
	 * @return
	 */
	public ListNode<Integer> plusOneRecursive(ListNode<Integer> head) {
		if (DFS(head) == 0) {
			return head;
		} else {
			ListNode<Integer> newHead = new ListNode<>(1);
			newHead.next = head;
			return newHead;
		}
	}

	public int DFS(ListNode<Integer> head) {
		if (head == null)
			return 1;

		int carry = DFS(head.next);

		if (carry == 0)
			return 0;

		int val = head.value + 1;
		head.value = val % 10;
		return val / 10;
	}

	public ListNode<Integer> plusOneTwoPointersSol(ListNode<Integer> head) {
		ListNode<Integer> dummy = new ListNode<>(0);
		dummy.next = head;
		ListNode<Integer> i = dummy;
		ListNode<Integer> j = dummy;

		while (j.next != null) {
			j = j.next;
			if (j.value != 9) {
				i = j;
			}
		}
		// i = index of last non-9 digit

		i.value++;
		i = i.next;
		while (i != null) {
			i.value = 0;
			i = i.next;
		}

		if (dummy.value == 0)
			return dummy.next;
		return dummy;
	}

	/**
	 * 9 lines recursive *without* helper
	 * 
	 * If the +1 was already handled without further carry, then the result is
	 * the given head node. Otherwise it's a new node (with carry value 1). In
	 * other words, a carry-node is created at the end and gets carried towards
	 * the front until it has been fully integrated.
	 * 
	 * @param head
	 * @return
	 */
	public ListNode<Integer> plusOneRecursiveWithoutHelper(ListNode<Integer> head) {
		if (head == null)
			return new ListNode<>(1);
		ListNode<Integer> plused = plusOneRecursiveWithoutHelper(head.next);
		if (plused != head.next)
			head.value++;
		if (head.value <= 9)
			return head;
		head.value = 0;
		plused.next = head;
		return plused;
	}
}
