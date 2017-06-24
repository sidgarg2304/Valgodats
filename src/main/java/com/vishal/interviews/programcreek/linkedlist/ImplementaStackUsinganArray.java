package com.vishal.interviews.programcreek.linkedlist;

public class ImplementaStackUsinganArray {

	public static void main(String[] args) {

	}

	int[] arr;
	int maxSize;
	int size;
	int top;

	public ImplementaStackUsinganArray(int maxSize) {
		this.maxSize = maxSize;
		arr = new int[maxSize];
	}

	boolean push(int val) {
		if (size == maxSize) {
			return false;
		}

		size++;
		arr[++top] = val;
		return true;
	}

	int pop() {
		int res = arr[top];
		arr[top] = -1;
		top--;

		return res;
	}

	int peek() {
		return arr[top];
	}

}
