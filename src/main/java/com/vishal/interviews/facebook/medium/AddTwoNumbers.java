package com.vishal.interviews.facebook.medium;

import com.vishal.interviews.util.ListNode;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode res = new ListNode(-1);
		int carry = 0;
		ListNode node1 = l1;
		ListNode node2 = l2;

		ListNode r = res;
		while (node1 != null || node2 != null) {
			int val1 = node1 != null ? node1.val : 0;
			int val2 = node2 != null ? node2.val : 0;
			int sum = val1 + val2 + carry;

			ListNode curNode = new ListNode(sum % 10);
			carry = sum / 10;
			r.next = curNode;
			r = curNode;
            if(node1 != null) {
                node1 = node1.next;
            }
            if(node2 != null) {
                node2 = node2.next;
            }
		}

		if (carry != 0) {
			r.next = new ListNode(carry);
		}

		return res.next;

	}

}
