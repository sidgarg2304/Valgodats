package com.vishal.interviews.salesforce;

import java.util.*;

public class LRUCache {

	public static void main(String[] args) {

	}

	Map<Integer, LRUNode> map;
	int capacity;
	LRUNode head;
	LRUNode tail;

	LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
	}

	int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}

		LRUNode cur = map.get(key);
		int res = cur.val;

		remove(cur);
		makeHead(cur);
		return res;
	}

	void makeHead(LRUNode node) {

		if (head == null) {
			head = null;
		} else {
			node.next = head;
			head.prev = node;
			head = node;
		}

		head.prev = null;

		if (tail == null) {
			tail = head;
		}
	}

	void remove(LRUNode node) {
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

	void set(int key, int val) {
		if (map.containsKey(key)) {
			map.get(key).val = val;
			LRUNode cur = map.get(key);
			remove(cur);
			makeHead(cur);
		} else {
			LRUNode cur = new LRUNode(key, val);
			if (map.size() == capacity) {
				map.remove(tail.key);
				remove(tail);				
			}
			map.put(key, cur);
			makeHead(cur);
		}
	}
}

class LRUNode {

	public int key;
	public int val;
	public LRUNode next;
	public LRUNode prev;
	
	public LRUNode(int key, int val){
		this.key = key;
		this.val = val;
	}
}
