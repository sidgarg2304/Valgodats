package com.vishal.datastructures.linkedlist;

public class ListNodeWithRandomPointer<T> {

	private T value;
	private ListNodeWithRandomPointer<T> next;
	private ListNodeWithRandomPointer<T> randomPointer;
	
	public ListNodeWithRandomPointer(T value){
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public ListNodeWithRandomPointer<T> getNext() {
		return next;
	}

	public void setNext(ListNodeWithRandomPointer<T> next) {
		this.next = next;
	}

	public ListNodeWithRandomPointer<T> getRandomPointer() {
		return randomPointer;
	}

	public void setRandomPointer(ListNodeWithRandomPointer<T> randomPointer) {
		this.randomPointer = randomPointer;
	}

}
