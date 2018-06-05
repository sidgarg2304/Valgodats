package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

public class Flatten2DVector {

	public static void main(String[] args) {

	}

	Queue<Iterator<Integer>> queue;

	public Flatten2DVector(List<List<Integer>> vec2d) {
		queue = new LinkedList<>();
		for (List<Integer> v : vec2d) {
			queue.offer(v.iterator());
		}

	}

	boolean hasNext() {
		return !queue.isEmpty() && queue.peek().hasNext();
	}

	int next() {
		Iterator<Integer> c = queue.peek();
		int res = c.next();
		if (!c.hasNext()) {
			queue.poll();
		}
		return res;
	}

}
