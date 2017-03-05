package com.vishal.interviews.google.hard;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * 146. LRU Cache
 * 
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. put(key, value) - Set or insert the
 * value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new
 * item.
 * 
 * Follow up:
 * 
 * Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * LRUCache cache = new LRUCache( 2 *capacity );
 * 
 * cache.put(1, 1);
 * 
 * cache.put(2, 2);
 * 
 * cache.get(1); // returns 1
 * 
 * cache.put(3, 3); // evicts key 2
 * 
 * cache.get(2); // returns -1 (not found)
 * 
 * cache.put(4, 4); // evicts key 1
 * 
 * cache.get(1); // returns -1 (not found)
 * 
 * cache.get(3); // returns 3
 * 
 * cache.get(4); // returns 4
 */
public class LRUCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/**
 * [Java] Hashtable + Double linked list (with a touch of pseudo nodes) The
 * problem can be solved with a hashtable that keeps track of the keys and its
 * values in the double linked list. One interesting property about double
 * linked list is that the node can remove itself without other reference. In
 * addition, it takes constant time to add and remove nodes from the head or
 * tail.
 * 
 * One particularity about the double linked list that I implemented is that I
 * create a pseudo head and tail to mark the boundary, so that we don't need to
 * check the NULL node during the update. This makes the code more concise and
 * clean, and also it is good for the performance as well.
 *
 * 
 */
class LRUCacheSol1 {
	class DLinkedNode {
		int key;
		int value;
		DLinkedNode pre;
		DLinkedNode post;
	}

	/**
	 * Always add the new node right after head;
	 */
	private void addNode(DLinkedNode node) {
		node.pre = head;
		node.post = head.post;

		head.post.pre = node;
		head.post = node;
	}

	/**
	 * Remove an existing node from the linked list.
	 */
	private void removeNode(DLinkedNode node) {
		DLinkedNode pre = node.pre;
		DLinkedNode post = node.post;

		pre.post = post;
		post.pre = pre;
	}

	/**
	 * Move certain node in between to the head.
	 */
	private void moveToHead(DLinkedNode node) {
		this.removeNode(node);
		this.addNode(node);
	}

	// pop the current tail.
	private DLinkedNode popTail() {
		DLinkedNode res = tail.pre;
		this.removeNode(res);
		return res;
	}

	private Hashtable<Integer, DLinkedNode> cache = new Hashtable<Integer, DLinkedNode>();
	private int count;
	private int capacity;
	private DLinkedNode head, tail;

	public LRUCacheSol1(int capacity) {
		this.count = 0;
		this.capacity = capacity;

		head = new DLinkedNode();
		head.pre = null;

		tail = new DLinkedNode();
		tail.post = null;

		head.post = tail;
		tail.pre = head;
	}

	public int get(int key) {

		DLinkedNode node = cache.get(key);
		if (node == null) {
			return -1; // should raise exception here.
		}

		// move the accessed node to the head;
		this.moveToHead(node);

		return node.value;
	}

	public void set(int key, int value) {
		DLinkedNode node = cache.get(key);

		if (node == null) {

			DLinkedNode newNode = new DLinkedNode();
			newNode.key = key;
			newNode.value = value;

			this.cache.put(key, newNode);
			this.addNode(newNode);

			++count;

			if (count > capacity) {
				// pop the tail
				DLinkedNode tail = this.popTail();
				this.cache.remove(tail.key);
				--count;
			}
		} else {
			// update the value.
			node.value = value;
			this.moveToHead(node);
		}

	}
}

/**
 * JAVA-----------Easy Version To Understand!!!! 
 * 
 * 1.The key to solve this problem
 * is using a double linked list which enables us to quickly move nodes.
 * 
 * 2.The LRU cache is a hash table of keys and double linked nodes. The hash
 * table makes the time of get() to be O(1). The list of double linked nodes
 * make the nodes adding/removal operations O(1).
 *
 */
class LRUCacheEasy {

	class Node {
		int key;
		int value;
		Node pre;
		Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	HashMap<Integer, Node> map;
	int capicity, count;
	Node head, tail;

	public LRUCacheEasy(int capacity) {
		this.capicity = capacity;
		map = new HashMap<>();
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.pre = head;
		head.pre = null;
		tail.next = null;
		count = 0;
	}

	public void deleteNode(Node node) {
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}

	public void addToHead(Node node) {
		node.next = head.next;
		node.next.pre = node;
		node.pre = head;
		head.next = node;
	}

	public int get(int key) {
		if (map.get(key) != null) {
			Node node = map.get(key);
			int result = node.value;
			deleteNode(node);
			addToHead(node);
			return result;
		}
		return -1;
	}

	public void set(int key, int value) {
		if (map.get(key) != null) {
			Node node = map.get(key);
			node.value = value;
			deleteNode(node);
			addToHead(node);
		} else {
			Node node = new Node(key, value);
			map.put(key, node);
			if (count < capicity) {
				count++;
				addToHead(node);
			} else {
				map.remove(tail.pre.key);
				deleteNode(tail.pre);
				addToHead(node);
			}
		}
	}

}


class LRUCacheNormal {
   private class Node{
       int key, value;
       Node prev, next;
       Node(int k, int v){
           this.key = k;
           this.value = v;
       }
       Node(){
           this(0, 0);
       }
   }
   private int capacity, count;
   private Map<Integer, Node> map;
   private Node head, tail;
   
   public LRUCacheNormal(int capacity) {
       this.capacity = capacity;
       this.count = 0;
       map = new HashMap<>();
       head = new Node();
       tail = new Node();
       head.next = tail;
       tail.prev = head;
   }
   
   public int get(int key) {
       Node n = map.get(key);
       if(null==n){
           return -1;
       }
       update(n);
       return n.value;
   }
   
   public void set(int key, int value) {
       Node n = map.get(key);
       if(null==n){
           n = new Node(key, value);
           map.put(key, n);
           add(n);
           ++count;
       }
       else{
           n.value = value;
           update(n);
       }
       if(count>capacity){
           Node toDel = tail.prev;
           remove(toDel);
           map.remove(toDel.key);
           --count;
       }
   }
   
   private void update(Node node){
       remove(node);
       add(node);
   }
   private void add(Node node){
       Node after = head.next;
       head.next = node;
       node.prev = head;
       node.next = after;
       after.prev = node;
   }
   
   private void remove(Node node){
       Node before = node.prev, after = node.next;
       before.next = after;
       after.prev = before;
   }
}