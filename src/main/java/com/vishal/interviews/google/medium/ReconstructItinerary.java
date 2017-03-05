package com.vishal.interviews.google.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 332. Reconstruct Itinerary
 * 
 * Given a list of airline tickets represented by pairs of departure and arrival
 * airports [from, to], reconstruct the itinerary in order. All of the tickets
 * belong to a man who departs from JFK. Thus, the itinerary must begin with
 * JFK.
 * 
 * Note:
 * 
 * 1. If there are multiple valid itineraries, you should return the itinerary
 * that has the smallest lexical order when read as a single string. For
 * example, the itinerary ["JFK", "LGA"] has a smaller lexical order than
 * ["JFK", "LGB"].
 * 
 * 2. All airports are represented by three capital letters (IATA code).
 * 
 * 3. You may assume all tickets form at least one valid itinerary.
 * 
 * Example 1:
 * 
 * tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 
 * Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
 * 
 * Example 2:
 * 
 * tickets =
 * [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 
 * Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
 * 
 * Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But
 * it is larger in lexical order.
 */
public class ReconstructItinerary {

	public static void main(String[] args) {

	}

	public List<String> findItineraryIterative(String[][] tickets) {
		Map<String, PriorityQueue<String>> targets = new HashMap<>();
		for (String[] ticket : tickets)
			targets.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
		List<String> route = new LinkedList<>();
		Stack<String> stack = new Stack<>();
		stack.push("JFK");
		while (!stack.empty()) {
			while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty())
				stack.push(targets.get(stack.peek()).poll());
			route.add(0, stack.pop());
		}
		return route;
	}

	/**
	 * Java, Greedy, Stack, 15ms with explanation
	 * 
	 * Noticed some folks are using Hierholzer's algorithm to find a Eulerian
	 * path.
	 * 
	 * My solution is similar, considering this passenger has to be physically in
	 * one place before move to another airport, we are considering using up all
	 * tickets and choose lexicographically smaller solution if in tie as two
	 * constraints.
	 * 
	 * Thinking as that passenger, the passenger choose his/her flight greedy as
	 * the lexicographical order, once he/she figures out go to an airport
	 * without departure with more tickets at hand. the passenger will push
	 * current ticket in a stack and look at whether it is possible for him/her
	 * to travel to other places from the airport on his/her way.
	 * 
	 * Please let me know if you have any suggestions.
	 * 
	 * @param tickets
	 * @return
	 */
	public List<String> findItinerary(String[][] tickets) {
		List<String> ans = new ArrayList<String>();
		if (tickets == null || tickets.length == 0)
			return ans;
		Map<String, PriorityQueue<String>> ticketsMap = new HashMap<>();
		for (int i = 0; i < tickets.length; i++) {
			if (!ticketsMap.containsKey(tickets[i][0]))
				ticketsMap.put(tickets[i][0], new PriorityQueue<String>());
			ticketsMap.get(tickets[i][0]).add(tickets[i][1]);
		}

		String curr = "JFK";
		Stack<String> drawBack = new Stack<String>();
		for (int i = 0; i < tickets.length; i++) {
			while (!ticketsMap.containsKey(curr) || ticketsMap.get(curr).isEmpty()) {
				drawBack.push(curr);
				curr = ans.remove(ans.size() - 1);
			}
			ans.add(curr);
			curr = ticketsMap.get(curr).poll();
		}
		ans.add(curr);
		while (!drawBack.isEmpty())
			ans.add(drawBack.pop());
		return ans;
	}

}

/**
 * Explanation
 * 
 * First keep going forward until you get stuck. That's a good main path
 * already. Remaining tickets form cycles which are found on the way back and
 * get merged into that main path. By writing down the path backwards when
 * retreating from recursion, merging the cycles into the main path is easy -
 * the end part of the path has already been written, the start part of the path
 * hasn't been written yet, so just write down the cycle now and then keep
 * backwards-writing the path.
 * 
 * 
 * 
 * From JFK we first visit JFK -> A -> C -> D -> A. There we're stuck, so we
 * write down A as the end of the route and retreat back to D. There we see the
 * unused ticket to B and follow it: D -> B -> C -> JFK -> D. Then we're stuck
 * again, retreat and write down the airports while doing so: Write down D
 * before the already written A, then JFK before the D, etc. When we're back
 * from our cycle at D, the written route is D -> B -> C -> JFK -> D -> A. Then
 * we retreat further along the original path, prepending C, A and finally JFK
 * to the route, ending up with the route JFK -> A -> C -> D -> B -> C -> JFK ->
 * D -> A.
 * 
 * 11 ms
 *
 */
class ReconstructItineraryWithGlobalVariables {
	Map<String, PriorityQueue<String>> targets = new HashMap<>();
	List<String> route = new LinkedList<>();

	public List<String> findItinerary(String[][] tickets) {
		for (String[] ticket : tickets)
			targets.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
		visit("JFK");
		return route;
	}

	void visit(String airport) {
		while (targets.containsKey(airport) && !targets.get(airport).isEmpty())
			visit(targets.get(airport).poll());
		route.add(0, airport);
	}
}

/**
 * All the airports are vertices and tickets are directed edges. Then all these
 * tickets form a directed graph.
 * 
 * The graph must be Eulerian since we know that a Eulerian path exists.
 * 
 * Thus, start from "JFK", we can apply the Hierholzer's algorithm to find a
 * Eulerian path in the graph which is a valid reconstruction.
 * 
 * Since the problem asks for lexical order smallest solution, we can put the
 * neighbors in a min-heap. In this way, we always visit the smallest possible
 * neighbor first in our trip.
 * 
 * 
 */
class ReconstructItineraryDFS {

	Map<String, PriorityQueue<String>> flights;
	LinkedList<String> path;

	public List<String> findItinerary(String[][] tickets) {
		flights = new HashMap<>();
		path = new LinkedList<>();
		for (String[] ticket : tickets) {
			flights.putIfAbsent(ticket[0], new PriorityQueue<>());
			flights.get(ticket[0]).add(ticket[1]);
		}
		dfs("JFK");
		return path;
	}

	public void dfs(String departure) {
		PriorityQueue<String> arrivals = flights.get(departure);
		while (arrivals != null && !arrivals.isEmpty())
			dfs(arrivals.poll());
		path.addFirst(departure);
	}
}
