package com.vishal.interviews.facebook.medium;

import java.util.*;

public class TopKFrequentWords {

	public static void main(String[] args) {

	}

	public List<String> topKFrequent(String[] words, int k) {

		List<String> res = new ArrayList<>();

		if (words == null || words.length == 0) {
			return res;
		}

		Map<String, Integer> countMap = new HashMap<>();
		for (String w : words) {
			countMap.put(w, countMap.getOrDefault(w, 0) + 1);
		}

		PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
				(a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());

		for (Map.Entry<String, Integer> e : countMap.entrySet()) {
			minHeap.offer(e);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}

		while (!minHeap.isEmpty()) {
			res.add(0, minHeap.poll().getKey());
		}

		return res;
	}

}
