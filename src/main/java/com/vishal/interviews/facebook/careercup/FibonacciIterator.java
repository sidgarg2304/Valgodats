package com.vishal.interviews.facebook.careercup;

public class FibonacciIterator {

	// 1 1 2 3 5 8
	public static void main(String[] args) {

		FibonacciIterator iter = new FibonacciIterator(10);

		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}

	int prev;
	int cur;

	int size;

	public FibonacciIterator(int size) {
		prev = 0;
		cur = 1;
		this.size = size;
	}

	int next() {
		int res = cur;

		int next = prev + cur;
		prev = cur;
		cur = next;

		size--;
		return res;
	}

	boolean hasNext() {
		return size > 0;
	}

}
