package com.vishal.datastructures.linkedlist;

public class ListNode<T> {

	public ListNode(T value) {
		this.value = value;
	}

	T value;
	ListNode<T> next;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public ListNode<T> getNext() {
		return next;
	}

	public void setNext(ListNode<T> next) {
		this.next = next;
	}
	
	public boolean equals(Object o) {
		if (o instanceof ListNode<?>) {
			ListNode<T> ln = (ListNode<T>) o;
			if (ln.getValue().equals(this.getValue()) && ln.getNext() == this.getNext()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}