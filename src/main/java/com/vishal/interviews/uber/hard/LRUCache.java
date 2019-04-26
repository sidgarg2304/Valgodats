package com.vishal.interviews.uber.hard;

import java.util.*;

public class LRUCache {

	public static void main(String[] args) {

	}

	Map<Integer, Node> map;
	Node head;
	Node tail;
	int capacity;

	LRUCache(int capacity) {
		map = new HashMap<>();
		this.capacity = capacity;
	}

	int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}

		Node cur = map.get(key);
		remove(cur);
		setHead(cur);
		return cur.val;
	}

	void remove(Node node) {
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

	void setHead(Node node) {
		node.next = head;
		if (head != null) {
			head.prev = node;
			node.prev = null;
		}
		head = node;

		if (tail == null) {
			tail = head;
		}
	}

	void set(int key, int val) {
		if (map.containsKey(key)) {
			Node cur = map.get(key);
			cur.val = val;
			remove(cur);
			setHead(cur);
		} else {
			Node cur = new Node(key, val);
			if (map.size() == capacity) {
				map.remove(tail.key);
				remove(tail);
			}
			map.put(key, cur);
			setHead(cur);
		}
	}

	class Node {
		int key;
		int val;
		Node next;
		Node prev;

		Node(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

}
