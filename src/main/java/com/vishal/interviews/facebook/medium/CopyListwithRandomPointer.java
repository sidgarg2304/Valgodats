package com.vishal.interviews.facebook.medium;

public class CopyListwithRandomPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Node copyRandomList(Node head) {

		if (head == null) {
			return null;
		}

		Node n = head;
		while (n != null) {
			Node cloneN = new Node(n.val);
			cloneN.next = n.next;
			n.next = cloneN;
			n = cloneN.next;
		}

		n = head;
		while (n != null) {
			Node cloneN = n.next;
			if (n.random != null) {
				cloneN.random = n.random.next;
			}
			n = cloneN.next;
		}

		Node res = head.next;

		n = head;
		while (n != null) {
			Node cloneN = n.next;
			Node next = cloneN.next;
			if (next != null) {
				cloneN.next = next.next;
			}
            n.next = next;
			n = next;
		}

		return res;
	}
	
	class Node {
		public int val;
		public Node next;
		public Node random;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}
	}

}
