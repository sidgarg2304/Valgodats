package com.vishal.interviews.programcreek.linkedlist;

public class ImplementaQueueusinganArray {

	public static void main(String[] args) {

	}

	int[] arr;
	int head = -1;
	int tail = -1;
	int size;

	ImplementaQueueusinganArray(int size) {
		this.size = 0;
		arr = new int[size];

	}

	boolean offer(int val) {
		if (size == arr.length) {
			return false;
		}
		head = (head + 1) % arr.length;

		arr[head] = val;
		size++;

		if (tail == -1) {
			tail = head;
		}

		return true;
	}

	int poll() {
		int res = arr[tail];
		arr[tail] = 0;
		tail = (tail + 1) % arr.length;
		size--;

		if (size == 0) {
			tail = -1;
			head = -1;
		}
		return res;

	}

	int size() {
		return size;
	}

	int peek() {
		if (size == 0) {
			return -1;
		}
		return arr[tail];
	}

}
