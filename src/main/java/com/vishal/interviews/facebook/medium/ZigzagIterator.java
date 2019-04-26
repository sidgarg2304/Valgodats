package com.vishal.interviews.facebook.medium;

import java.util.*;

public class ZigzagIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	boolean readFirst = true;
	int i = 0;
	int j = 0;
	List<Integer> v1;
	List<Integer> v2;

	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		this.v1 = v1;
		this.v2 = v2;
	}

	public int next() {		
		if(i >= v1.size()) {
			readFirst = true;
			return v2.get(j++);			
		}
		
		if(j >= v2.size()) {
			readFirst = false;
			return v1.get(i++);
		}
		
		if(readFirst) {
			readFirst = !readFirst;
			return v1.get(i++);	
		} else {
			readFirst = !readFirst;
			return v2.get(j++);
		}
		
	}

	public boolean hasNext() {
		return i < v1.size() || j < v2.size();
	}

}
