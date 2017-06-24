package com.vishal.design.consistenhashing;

import java.util.*;

public class ConsisteHashMap<T> {

	public static void main(String[] args) {

		
	}

	HashFunction hasFunction;
	int numOfReplicas;
	TreeMap<Integer, Object> circularMap;

	ConsisteHashMap(HashFunction hasFunction, int numOfReplicas) {
		this.numOfReplicas = numOfReplicas;
		this.hasFunction = hasFunction;
		circularMap = new TreeMap<>();
	}

	void addNode(Object node) {
		for (int i = 0; i < numOfReplicas; i++) {
			int hash = hasFunction.getHash(node.toString()) + i;
			circularMap.put(hash, node);
		}
	}

	void remove(Object node) {
		for (int i = 0; i < numOfReplicas; i++) {
			int hash = hasFunction.getHash(node) + i;
			circularMap.remove(hash, node);
		}
	}

	Object getNode(Object key) {
		int hash = hasFunction.getHash(key);

		if (circularMap.containsKey(hash)) {
			return circularMap.get(hash);
		}

		SortedMap<Integer, Object> tailMap = circularMap.tailMap(hash);
		hash = tailMap.isEmpty() ? circularMap.firstKey() : tailMap.firstKey();

		return circularMap.get(hash);

	}

}
