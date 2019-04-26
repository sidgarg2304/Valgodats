package com.vishal.interviews.facebook.easy;

/**
 * 206. Reverse Linked List
 * 
 * Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
 *
 */
public class ReverseLinkedList {

	public static void main(String[] args) {

	}
	
	public ListNode reverseList(ListNode head) {
      if (head == null) {
			return null;
		}
		ListNode p = null;
		ListNode c = head;
		while (c != null) {
			ListNode n = c.next;
			c.next = p;
			p = c;
			c = n;
		}
		return p;
  }

}
