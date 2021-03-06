package com.vishal.datastructures.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LinkedListPrograms {

	public static void main(String[] args) {

		ListNode<Integer> root = createLinkedList();
		printLinkedList(root);

		root = swapPairs(root);
		System.out.print("swapped list in pairs is ");
		printLinkedList(root);

		root = reverseLinkedList(root);
		System.out.print("reverse list is ");
		printLinkedList(root);

		testSum();
	}

	public static void testSum() {
		ListNode<Integer> l1 = new ListNode<Integer>(4);
		ListNode<Integer> l11 = new ListNode<Integer>(6);
		l1.next = l11;

		ListNode<Integer> l2 = new ListNode<Integer>(5);
		ListNode<Integer> l21 = new ListNode<Integer>(4);
		ListNode<Integer> l22 = new ListNode<Integer>(9);
		l2.next = l21;
		l21.next = l22;

		ListNode<Integer> res = sum(l1, l2);
		System.out.println("sum of following two lists is ");
		printLinkedList(l1);
		printLinkedList(l2);
		printLinkedList(res);
	}

	public static ListNode<Integer> sum(ListNode<Integer> l1, ListNode<Integer> l2) {

		ListNode<Integer> lr1 = reverseLinkedList(l1);
		ListNode<Integer> lr2 = reverseLinkedList(l2);

		ListNode<Integer> finalRes = null;
		ListNode<Integer> res = null;
		int carry = 0;
		ListNode<Integer> p1 = lr1;
		ListNode<Integer> p2 = lr2;
		while (p1 != null || p2 != null) {

			int x = (p1 != null) ? p1.value : 0;
			int y = (p2 != null) ? p2.value : 0;
			int sum = x + y + carry;

			int curDigit = sum % 10;
			carry = sum / 10;

			ListNode<Integer> curResNode = new ListNode<Integer>(curDigit);
			if (res == null) {
				res = curResNode;
				finalRes = res;
			} else {
				res.next = curResNode;
				res = res.next;
			}

			if (carry > 0) {
				res.next = new ListNode<Integer>(carry);
			}

			if (p1 != null) {
				p1 = p1.next;
			}
			if (p2 != null) {
				p2 = p2.next;
			}
		}

		// reverse inputs back
		reverseLinkedList(lr1);
		reverseLinkedList(lr2);
		// reverse res
		return reverseLinkedList(finalRes);
	}

	// 1 -> 2 -> 3 -> 4

	// 1 -> null
	// 2 -> 1
	// 3 -> 2
	// 4 -> 3 -> 2 -> 1 -> null;
	static ListNode<Integer> reverseLinkedList(ListNode<Integer> root) {

		ListNode<Integer> prev = null;
		ListNode<Integer> cur = root; // 1
		ListNode<Integer> next = null;

		while (cur != null) {
			next = cur.next; // 2
			cur.next = prev; // 1 > null
			prev = cur;
			cur = next;
		}

		return prev;
	}

	// 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 ---- p = 0
	// 0 -> 2 -> 1 -> 3 -> 4 -> 5 -> 6
	public static ListNode<Integer> swapPairs(ListNode<Integer> root) {

		ListNode<Integer> res = new ListNode<Integer>(0);
		res.next = root;
		ListNode<Integer> p = res;

		while (p.next != null && p.next.next != null) {

			// p = 0, 1
			ListNode<Integer> t1 = p.next; // 1, 3
			ListNode<Integer> t2 = p.next.next; // 2, 4
			ListNode<Integer> t3 = p.next.next.next; // 3, 5

			// p t1 t2 t3
			// 0 -> 1 -> 2 -> 3
			// 0 -> 2 -> 1 -> 3

			p.next = t2; // 0 -> 2, 1->4
			t2.next = t1; // 2 -> 1, 4 -> 3
			t1.next = t3; // 1 -> 3, 3 -

			p = t1; // 1
		}

		return res.next;
	}

	// 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 4 -> 7 -> 8
	// 1 -> 2 -> 3 -> 4 -> 4 -> -> 6 -> 7 -> 8
	static void arrangeDuplicatesSidebySide(ListNode<Integer> root) {
		ListNode<Integer> p = root;

		while (p != null) {
			ListNode<Integer> q = p.next;
			while (q != null) {
				if (q.value == p.value) {

				}
				q = q.next;
			}

			p = p.next;
		}
	}

	public static void cloneLinkedListWithRandomPointer(ListNodeWithRandomPointer<Integer> root) {

		Map<ListNodeWithRandomPointer<Integer>, ListNodeWithRandomPointer<Integer>> map = new HashMap<>();
		ListNodeWithRandomPointer<Integer> clonedRoot = new ListNodeWithRandomPointer<Integer>(root.getValue());
		map.put(root, clonedRoot);

		ListNodeWithRandomPointer<Integer> p = root;
		ListNodeWithRandomPointer<Integer> q = clonedRoot;

		p = p.getNext();
		while (p != null) {
			ListNodeWithRandomPointer<Integer> clonedP = new ListNodeWithRandomPointer<Integer>(p.getValue());
			q.setNext(clonedP);
			map.put(p, clonedP);
			p = p.getNext();
			q = clonedP;
		}

		p = root;
		q = clonedRoot;
		while (p != null) {
			ListNodeWithRandomPointer<Integer> pRandomPointer = p.getRandomPointer() != null ? p.getRandomPointer() : null;
			ListNodeWithRandomPointer<Integer> clonedPRandomPointer = map.get(pRandomPointer);
			q.setRandomPointer(clonedPRandomPointer);
			p = p.getNext();
			q = q.getNext();
		}
	}
	
	/**
	 * 1 -> 2 -> 3 -> 4 -> 5 to
	 * 1 -> 5 -> 2 -> 4 -> 3
	 * @param root
	 */
	public static void printFrontAndBackLinkedList(ListNode<Integer> root){
		ListNode<Integer> slow = root;
		ListNode<Integer> fast = root;
		
		while(fast != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode<Integer> m = slow.next;
		ListNode<Integer> reverseM = reverseLinkedList(m); // 5 -> 4
		m.next = null;
		
		ListNode<Integer> p = root.next;
		ListNode<Integer> q = reverseM;
		ListNode<Integer> res = new ListNode<>(0);
		res.setNext(root);
		
		ListNode<Integer> t = res.next;
		boolean sec = true;
		while(p != null && q != null){
			if(sec){
				t.setNext(q);
				q = q.next;
			}else{
				t.setNext(p);
				p = p.next;
			}
			t = t.next;
		}
		
		printLinkedList(res.next);
	}

	public static ListNode<Integer> createLinkedList() {
		ListNode<Integer> first = new ListNode<Integer>(1);
		ListNode<Integer> second = new ListNode<Integer>(2);
		ListNode<Integer> third = new ListNode<Integer>(3);
		ListNode<Integer> fourth = new ListNode<Integer>(4);
		ListNode<Integer> fifth = new ListNode<Integer>(5);
		ListNode<Integer> sixth = new ListNode<Integer>(6);

		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;

		return first;
	}

	public static void printLinkedList(ListNode<Integer> root) {

		ListNode<Integer> p = root;
		while (p != null) {
			System.out.print(p.getValue() + " -> ");
			p = p.next;
		}
		System.out.print("null");
		System.out.println("");
	}
}
