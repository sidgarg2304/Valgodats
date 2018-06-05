package com.vishal.interviews.topinterviewquestions.hard;

import java.util.*;

public class LRUCache {

	public static void main(String[] args) {

	}

	LRUDListNode head;
	LRUDListNode tail;

	Map<Integer, LRUDListNode> map;
	int capacity;

	LRUCache(int capacity) {
		map = new HashMap<>();
		this.capacity = capacity;
	}

	int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}
		LRUDListNode r = map.get(key);
		remove(r);
		setHead(r);

		return r.val;

	}

	void put(int key, int val) {
		if (map.containsKey(key)) {
			LRUDListNode r = map.get(key);
			r.val = val;
			remove(r);
			setHead(r);
		} else {
			LRUDListNode c = new LRUDListNode();
			c.key = key;
			c.val = val;

			if (map.size() >= capacity) {
				map.remove(tail.key);
				remove(tail);
			}

			map.put(key, c);
			setHead(c);
		}
	}

	void remove(LRUDListNode node) {
		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			head = node.next;
		}

		if (node.next != null) {
			node.next.prev = node.prev;
		} else {
			tail = node.prev;
		}
	}

	void setHead(LRUDListNode node) {

		if (head != null) {
			head.prev = node;
		}
		node.next = head;

		head = node;
		head.prev = null;
		
		if (tail == null) {
			tail = head;
		}

	}

}

class LRUDListNode {

	public LRUDListNode next;
	public LRUDListNode prev;
	public int key;
	public int val;
}
