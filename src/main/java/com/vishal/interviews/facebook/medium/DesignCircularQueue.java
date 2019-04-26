package com.vishal.interviews.facebook.medium;


public class DesignCircularQueue {

	public static void main(String[] args) {

	}

	int curSize = 0;
	int maxSize = 0;

	DListNode head;
	DListNode tail;

	public DesignCircularQueue(int size) {
		maxSize = size;
		head = new DListNode(-1);
		tail = new DListNode(-1);
		head.next = tail;
		tail.next = head;
	}

	public boolean enQueue(int value) {

		if (isFull()) {
			return false;
		}

		DListNode cur = new DListNode(value);
		cur.next = tail;
		cur.prev = tail.prev;
		tail.prev.next = cur;
		tail.prev = cur;
		curSize++;
		return true;
	}

	public int Rear() {

		if (isEmpty()) {
			return -1;
		}
		return tail.val;
	}

	public int Front() {
		if (isEmpty()) {
			return -1;
		}
		return head.val;
	}

	public boolean deQueue() {
		if (isEmpty()) {
			return false;
		}

		DListNode nodeToBeDeleted = head.next;
		head.next = nodeToBeDeleted.next;
		nodeToBeDeleted.next.prev = head;
		nodeToBeDeleted.next = null;
		nodeToBeDeleted.prev = null;
		curSize--;
		return true;

	}

	public boolean isFull() {
		return curSize == maxSize;
	}

	public boolean isEmpty() {
		return curSize == 0;
	}

	class DListNode {

		public DListNode prev;
		public DListNode next;
		public int val;

		public DListNode(int val) {
			this.val = val;
		}
	}

}
