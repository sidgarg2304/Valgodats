package com.vishal.interviews.uber.medium;

import com.vishal.interviews.util.ListNode;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode res = new ListNode(-1);

		ListNode r = res;
		ListNode f = l1;
		ListNode s = l2;

		int carry = 0;
		while (f != null || s != null) {
			int val1 = f != null ? f.val : 0;
			int val2 = s != null ? s.val : 0;

			int sum = val1 + val2 + carry;
			r.next = new ListNode(sum % 10);

			carry = sum / 10;
			
			if(f != null) {
				f = f.next;
			}
			
			if(s != null) {
				s = s.next;
			}
			
			r = r.next;

		}
		
		if(carry != 0) {
			r.next = new ListNode(carry);
		}
		
		return res.next;
	}

}
