package com.vishal.interviews.facebook.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class ReconstructItinerary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> findItinerary(String[][] tickets) {
      List<String> res = new ArrayList<>();
		
		if(tickets == null || tickets.length == 0){
			return res;
		}
		Map<String, PriorityQueue<String>> map = new HashMap<>();
		for(String [] ticket: tickets){
			if(!map.containsKey(ticket[0])){
				map.put(ticket[0], new PriorityQueue<>());
			}
			map.get(ticket[0]).offer(ticket[1]);
		}
		
		Stack<String> stack = new Stack<>();
		stack.push("JFK");
		
		while (!stack.isEmpty()) {
			String cur = stack.peek();

			if (map.containsKey(cur) && !map.get(cur).isEmpty()) {
				stack.push(map.get(cur).poll());
			} else {
				res.add(0, stack.pop());
			}

		}
		return res;
  }

}
