package com.vishal.interviews.amazon.easy;

import com.vishal.datastructures.linkedlist.ListNode;

/**
 * 234. Palindrome Linked List
 * 
 * Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
 *
 */
public class PalindromeLinkedList {

	public static void main(String[] args) {

	}

	/**
	 * Java, easy to understand
This can be solved by reversing the 2nd half and compare the two halves. Let's start with an example [1, 1, 2, 1].

In the beginning, set two pointers fast and slow starting at the head.

1 -> 1 -> 2 -> 1 -> null 
sf
(1) Move: fast pointer goes to the end, and slow goes to the middle.

1 -> 1 -> 2 -> 1 -> null 
          s          f
(2) Reverse: the right half is reversed, and slow pointer becomes the 2nd head.

1 -> 1    null <- 2 <- 1           
h                      s
(3) Compare: run the two pointers head and slow together and compare.

1 -> 1    null <- 2 <- 1             
     h            s

	 * @param head
	 * @return
	 */
	public boolean isPalindromeEasy(ListNode<Integer> head) {
		ListNode<Integer> fast = head, slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		if (fast != null) { // odd nodes: let right half smaller
			slow = slow.next;
		}
		slow = reverse(slow);
		fast = head;

		while (slow != null) {
			if (fast.value != slow.value) {
				return false;
			}
			fast = fast.next;
			slow = slow.next;
		}
		return true;
	}

	public ListNode<Integer> reverse(ListNode<Integer> head) {
		ListNode<Integer> prev = null;
		while (head != null) {
			ListNode<Integer> next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
	
	public boolean isPalindromeAnotherEasy(ListNode<Integer> head) {
		if (head == null) {
			return true;
		}
		ListNode<Integer> p1 = head;
		ListNode<Integer> p2 = head;
		ListNode<Integer> p3 = p1.next;
		ListNode<Integer> pre = p1;
		// find mid pointer, and reverse head half part
		while (p2.next != null && p2.next.next != null) {
			p2 = p2.next.next;
			pre = p1;
			p1 = p3;
			p3 = p3.next;
			p1.next = pre;
		}

		// odd number of elements, need left move p1 one step
		if (p2.next == null) {
			p1 = p1.next;
		} else { // even number of elements, do nothing

		}
		// compare from mid to head/tail
		while (p3 != null) {
			if (p1.value != p3.value) {
				return false;
			}
			p1 = p1.next;
			p3 = p3.next;
		}
		return true;

	}

}
