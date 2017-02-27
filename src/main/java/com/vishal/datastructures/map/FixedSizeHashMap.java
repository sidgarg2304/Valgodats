package com.vishal.datastructures.map;

import java.util.LinkedHashMap;

public class FixedSizeHashMap<T, P> {

	private LinkedHashMap<T, P> linkedHashMap;
	private int maxSize;

	public FixedSizeHashMap(int maxSize) {
		linkedHashMap = new LinkedHashMap<>();
		this.maxSize = maxSize;
	}

	public int getSize() {
		return linkedHashMap.size();
	}

	public P getValue(T key) {
		return linkedHashMap.get(key);
	}

	
}
