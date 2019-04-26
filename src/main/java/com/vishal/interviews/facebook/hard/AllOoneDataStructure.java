package com.vishal.interviews.facebook.hard;

import java.util.*;

/**
 * 432. All O`one Data Structure
 * 
 * Implement a data structure supporting the following operations:
 * 
 * Inc(Key) - Inserts a new key with value 1. Or increments an existing key by
 * 1. Key is guaranteed to be a non-empty string. Dec(Key) - If Key's value is
 * 1, remove it from the data structure. Otherwise decrements an existing key by
 * 1. If the key does not exist, this function does nothing. Key is guaranteed
 * to be a non-empty string. GetMaxKey() - Returns one of the keys with maximal
 * value. If no element exists, return an empty string "". GetMinKey() - Returns
 * one of the keys with minimal value. If no element exists, return an empty
 * string "". Challenge: Perform all these in O(1) time complexity.
 *
 */
public class AllOoneDataStructure {

	public static void main(String[] args) {

	}

	Map<String, Node> map;
	PriorityQueue<Node> minHeap;
	PriorityQueue<Node> maxHeap;

	AllOoneDataStructure() {
		map = new HashMap<>();
		minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
		maxHeap = new PriorityQueue<>((a, b) -> b.val - a.val);
	}

	public void inc(String key) {
		Node n = null;
		if (!map.containsKey(key)) {
			n = new Node(key, 1);
		} else {
			n = map.get(key);
			minHeap.remove(n);
			maxHeap.remove(n);
			n.val++;
		}
		map.put(key, n);
		minHeap.offer(n);
		maxHeap.offer(n);
	}

	public void dec(String key) {
		if (!map.containsKey(key)) {
			return;
		}

		Node n = map.get(key);
		minHeap.remove(n);
		maxHeap.remove(n);
		if (n.val == 1) {
			map.remove(key);
			return;
		}

		n.val--;
		map.put(key, n);
		minHeap.offer(n);
		maxHeap.offer(n);
	}

	public String getMaxKey() {
		if (!maxHeap.isEmpty()) {
			return maxHeap.peek().key;
		}
		return "";
	}

	public String getMinKey() {
		if (!minHeap.isEmpty()) {
			return minHeap.peek().key;
		}
		return "";
	}

	class Node {
		String key;
		int val;

		Node(String key, int val) {
			this.key = key;
			this.val = val;
		}
	}
}
