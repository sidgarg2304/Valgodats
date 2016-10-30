package com.vishal.datastructures.doublelinkedlist;

public class DListNode<T> {

	private DListNode<T> prev;
	private DListNode<T> next;
	private T value;
	private Integer key;

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public DListNode(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public DListNode<T> getPrev() {
		return prev;
	}

	public void setPrev(DListNode<T> prev) {
		this.prev = prev;
	}

	public DListNode<T> getNext() {
		return next;
	}

	public void setNext(DListNode<T> next) {
		this.next = next;
	}
}
