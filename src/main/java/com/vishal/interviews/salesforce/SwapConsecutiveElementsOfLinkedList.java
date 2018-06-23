package com.vishal.interviews.salesforce;

public class SwapConsecutiveElementsOfLinkedList {

	public static void main(String[] args) {

		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		
		one.next = two;
		two.next = three;
		three.next = four;
		
		print(one);
		
		swap(three, two);
		
		print(one);
	}

	// 1 -> 2 -> 3 -> 4
	// 1 -> 3 -> 2 -> 4
	static void swap(ListNode node, ListNode prev) {

		if(node == null || node.next == null){
			return;
		}
		
		ListNode p = prev; // 1
		ListNode n = node; // 2
		ListNode next = node.next; //3
		ListNode nnext = next.next; //4
		
		n.next = nnext;
		next.next = n;
		
		p.next = next;				
		
	}
	
	static void print(ListNode head){
		ListNode h = head;
		StringBuilder sb = new StringBuilder();
		while(h != null){
			sb.append(h.val + ",");
			h = h.next;
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}

}
