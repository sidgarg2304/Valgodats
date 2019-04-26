package com.vishal.interviews.uber.medium;

import java.util.*;

public class ReconstructItinerary {

	public static void main(String[] args) {

	}

	public List<String> findItinerary(String[][] tickets) {
		List<String> res = new ArrayList<>();

		if (tickets == null || tickets.length == 0) {
			return res;
		}

		Map<String, PriorityQueue<String>> map = new HashMap<>();
		for (String[] t : tickets) {
			if (!map.containsKey(t[0])) {
				map.put(t[0], new PriorityQueue<>());
			}
			map.get(t[0]).offer(t[1]);
		}

		Stack<String> stack = new Stack<>();
		stack.push("JFK");

		while (!stack.isEmpty()) {
			if (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty()) {
				stack.push(map.get(stack.peek()).poll());				
			} else {
				res.add(0, stack.pop());
			}
		}
		return res;
	}

}
