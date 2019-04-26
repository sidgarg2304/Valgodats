package com.vishal.interviews.facebook.medium;

import java.util.Random;

import com.vishal.interviews.util.ListNode;

public class LinkedListRandomNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Random rand;
	ListNode head;

	public LinkedListRandomNode(ListNode head) {
		rand = new Random();
		this.head = head;
	}

	/** Returns a random node's value. */
	public int getRandom() {

		ListNode res = head;
		ListNode c = head;

		int cnt = 0;
		while (c != null) {
			if (rand.nextInt(cnt + 1) == cnt) {
				res = c;
			}
			c = c.next;
			cnt++;
		}
		return res.val;
	}

}
