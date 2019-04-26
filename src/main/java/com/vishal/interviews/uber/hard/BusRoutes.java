package com.vishal.interviews.uber.hard;

import java.util.*;

public class BusRoutes {

	public static void main(String[] args) {

	}

	public int numBusesToDestination(int[][] routes, int S, int T) {

		// maintains list of buses that come to each stop
		Map<Integer, Set<Integer>> busStopsToBusesMapping = new HashMap<>();
		for (int bus = 0; bus < routes.length; bus++) {
			for (int s = 0; s < routes[bus].length; s++) {
				if (!busStopsToBusesMapping.containsKey(routes[bus][s])) {
					busStopsToBusesMapping.put(routes[bus][s], new HashSet<>());
				}
				busStopsToBusesMapping.get(routes[bus][s]).add(bus);
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(S);
		Set<Integer> seen = new HashSet<>();
		seen.add(S);

		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int curStop = queue.poll();

				if (curStop == T) {
					return level;
				}
				
				Set<Integer> busesCanBeTakenFromThisStop = busStopsToBusesMapping.get(curStop);
				for(int bus : busesCanBeTakenFromThisStop) {
					for(int stopPos = 0; stopPos< routes[bus].length ; stopPos++) {
						int nextStop = routes[bus][stopPos];
						if(!seen.contains(nextStop)) {
							seen.add(nextStop);
							queue.offer(nextStop);
						}
					}
				}
			}
			level++;
		}
		return -1;
	}

}
