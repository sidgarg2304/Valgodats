package com.vishal.interviews.linkedin.easy;

import com.vishal.datastructures.linkedlist.ListNode;

public class MergeTwoSortedLists {

	public static void main(String[] args) {

	}
	
	
	// 1 -> 3 -> 5
	// 2 -> 4 -> 6 -> 7
	static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> l1, ListNode<Integer> l2){
		
		ListNode<Integer> res = new ListNode<Integer>(0);
		
		ListNode<Integer> p = res;
		
		while(l1 != null && l2 != null){
			if(l1.value < l2.value){
				p.next = l1;
				l1 = l1.next;
			}else {
				p.next = l2;
				l2 = l2.next;
			}
			
			p = p.next;
			
		}
		
		if(l1 != null){
			p.next = l1;			
		}
		
		if(l2 != null){
			p.next = l2;			
		}
		
		return res.next;
	}
	

}
