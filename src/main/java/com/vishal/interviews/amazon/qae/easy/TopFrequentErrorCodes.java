package com.vishal.interviews.amazon.qae.easy;

import java.util.*;
import java.util.Map.Entry;

/**
 * From multiple log files if you have queried different error codes, return top
 * 5 error codes
 * 
 */
public class TopFrequentErrorCodes {

	public static void main(String[] args) {
		List<Integer> errorCodes = new ArrayList<>();
		errorCodes.add(500);
		errorCodes.add(304);
		errorCodes.add(304);
		errorCodes.add(404);
		errorCodes.add(404);
		errorCodes.add(404);

		System.out.println(topKErrorCodes(errorCodes, 2));
	}

	public static List<Integer> topKErrorCodes(List<Integer> errorCodes, int k) {

		LinkedList<Integer> res = new LinkedList<>();

		Map<Integer, Integer> countMap = new HashMap<>();
		for (int e : errorCodes) {
			countMap.put(e, countMap.getOrDefault(e, 0) + 1);
		}
		// 500 -> 1
		// 304 -> 2
		// 404 -> 3

		// return {404, 304}
		PriorityQueue<Entry<Integer, Integer>> minHeap = new PriorityQueue<>(new Comparator<Entry<Integer, Integer>>() {
			public int compare(Entry<Integer, Integer> e1, Entry<Integer, Integer> e2) {
				return e1.getValue() - e2.getValue();
			}
		});
		for (Entry<Integer, Integer> e : countMap.entrySet()) {
			minHeap.offer(e);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}

		//Since minHeap has the min value first, we need to copy in reverse order
		while (!minHeap.isEmpty()) {
			res.addFirst(minHeap.poll().getKey());
		}

		return res;

	}

}
