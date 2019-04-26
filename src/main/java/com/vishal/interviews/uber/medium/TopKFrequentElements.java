package com.vishal.interviews.uber.medium;

import java.util.*;

public class TopKFrequentElements {

	public static void main(String[] args) {

	}

	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> res = new ArrayList<>();
		
		if(nums == null || nums.length == 0) {
			return res;
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			minHeap.offer(e);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}
		while(!minHeap.isEmpty()) {
			res.add(minHeap.poll().getKey());
		}
		return res;
	}

}
