package com.vishal.interviews.facebook.medium;

public class InsertintoaCyclicSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Node insert(Node head, int insertVal) {

		if (head == null) {
			return null;
		}

		Node newNode = new Node(insertVal);
		if (head.next == null) {
			head.next = newNode;
			newNode.next = head;
			return head;
		}

		Node cur = head;
		while (!(insertVal > cur.val && insertVal <= cur.next.val)) {

			if (cur.val > cur.next.val && (insertVal >= cur.val || insertVal <= cur.next.val)) {
				break;
			}
			cur = cur.next;
			if (cur == head) {
				break;
			}
		}
		newNode.next = cur.next;
		cur.next = newNode;
		
		return head;
	}
	
	class Node {
	    public int val;
	    public Node next;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;	        
	    }
	}

}
