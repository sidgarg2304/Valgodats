package com.vishal.interviews.facebook.medium;

import com.vishal.interviews.util.ListNode;

public class ReorderList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void reorderList(ListNode head) {

      if(head == null) {
          return;
      }
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		
		ListNode sec = reverse(slow.next);
		slow.next = null;
		ListNode first = head;
		ListNode res = new ListNode(-1);
		ListNode r = res;

		int f = 0;
		while (sec != null) {
			if (f == 0) {
				r.next = first;
				first = first.next;
			} else {
				r.next = sec;
				sec = sec.next;
			}
			f ^= 1;
          r = r.next;
		}        
      
      if(first != null){
          r.next = first;
      }

	}
  
  ListNode reverse(ListNode head) {
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
