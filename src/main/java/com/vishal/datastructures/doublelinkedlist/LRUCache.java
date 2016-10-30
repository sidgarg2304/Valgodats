package com.vishal.datastructures.doublelinkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<T> {

	private Map<Integer, DListNode<T>> map;
	private int size;
	private DListNode<T> head;
	private DListNode<T> tail;

	public LRUCache(int size) {
		map = new HashMap<>();
		this.size = size;
	}

	public T getValue(Integer key) {

		if (map.containsKey(key)) {
			DListNode<T> n = map.get(key);
			removeDListNode(n);
			setHead(n);
			return n.getValue();
		} else {
			throw new RuntimeException("No entry exists for the key" + key);
		}
	}

	public void setValue(Integer key, T value) {
		if (map.containsKey(key)) {
			// update existing node
			DListNode<T> n = map.get(key);
			n.setValue(value);
			removeDListNode(n);
			setHead(n);
		} else {
			// create new node
			DListNode<T> n = new DListNode<>(value);

			if (map.size() >= size) {
				map.remove(tail.getKey());
				removeDListNode(tail);
			}

			setHead(n);

			map.put(key, n);
		}
	}

	public void removeDListNode(DListNode<T> node) {

		DListNode<T> prev = node.getPrev();

		DListNode<T> next = node.getNext();

		if (prev != null) {
			prev.setNext(next);
		} else {
			head = next;
		}

		if (next != null) {
			next.setPrev(prev);
		} else {
			tail = prev;
		}
	}

	public void setHead(DListNode<T> node) {

		node.setNext(head);
		node.setPrev(null);

		if (head != null) {
			head.setPrev(node);
		}

		head = node;

		if (tail == null) {
			tail = head;
		}
	}

}
