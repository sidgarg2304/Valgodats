package com.vishal.interviews.top100linkedquestions.hard;

import java.util.*;

public class LRUCache {

	public static void main(String[] args) {

	}

	LRUNode head;
	LRUNode tail;
	Map<Integer, LRUNode> map;

	int capacity;

	LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
	}

	int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}

		LRUNode r = map.get(key);
		delete(r);
		addToHead(r);

		return r.val;
	}

	void delete(LRUNode node) {
		if (node.next != null) {
			node.next.prev = node.prev;
		} else {
			tail = node.prev;
		}

		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			head = node.next;
		}
	}

	void addToHead(LRUNode node) {
		if (head != null) {
			head.prev = node;			
		}
		
		
		node.next = head;
		node.prev = null;
		head = node;

		if (tail == null) {
			tail = head;
		}
	}

	void put(int key, int val) {
		if (map.containsKey(key)) {
			LRUNode cur = map.get(key);
			cur.val = val;
			delete(cur);
			addToHead(cur);
		} else {
			LRUNode cur = new LRUNode(key, val);
			if (map.size() >= capacity) {
				delete(tail);
			}
			map.put(key, cur);
			addToHead(cur);
		}

	}
}

class LRUNode {
	int key;
	int val;

	LRUNode next;
	LRUNode prev;

	LRUNode(int key, int val) {
		this.key = key;
		this.val = val;
	}
}
