package com.vishal.interviews.facebook.hard;

import java.util.*;
import com.vishal.interviews.util.LRUDListNode;

public class LRUCache {

	public static void main(String[] args) {

	}

	LRUDListNode head;
	LRUDListNode tail;
	int capacity;
	Map<Integer, LRUDListNode> map;

	LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
	}

	int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}

		LRUDListNode cur = map.get(key);
		int res = cur.val;

		remove(cur);
		setHead(cur);

		return res;
	}

	void setHead(LRUDListNode node) {
		node.next = head;
		node.prev = null;
		if (head != null) {
			head.prev = node;
		}
		
		head = node;
		
		if(tail == null){
			tail = head;
		}
	}

	void remove(LRUDListNode node) {
		LRUDListNode p = node.prev;
		LRUDListNode n = node.next;

		if (p != null) {
			p.next = n;
		} else {
			head = n;
		}

		if (n != null) {
			n.prev = p;
		} else {
			tail = p;
		}
	}

	void put(int key, int val) {
		if (map.containsKey(key)) {
			LRUDListNode cur = map.get(key);
			cur.val = val;

			remove(cur);
			setHead(cur);
		} else {
			if (map.size() >= capacity) {
				remove(tail);
				map.remove(tail.key);
			}
			LRUDListNode cur = new LRUDListNode();
			cur.key = key;
			cur.val = val;
			setHead(cur);
			map.put(key, cur);

		}
	}

}
