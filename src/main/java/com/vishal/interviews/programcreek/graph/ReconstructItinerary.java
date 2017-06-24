package com.vishal.interviews.programcreek.graph;

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

		for (String[] ticket : tickets) {
			if (!map.containsKey(ticket[0])) {
				map.put(ticket[0], new PriorityQueue<>());
			}

			map.get(ticket[0]).offer(ticket[1]);
		}

		dfs("JFK", map, res);

		return res;
	}

	void dfs(String ticket, Map<String, PriorityQueue<String>> map, List<String> res) {

		PriorityQueue<String> queue = map.get(ticket);

		while (!queue.isEmpty()) {
			dfs(queue.poll(), map, res);
		}

		res.add(0, ticket);
	}

}
