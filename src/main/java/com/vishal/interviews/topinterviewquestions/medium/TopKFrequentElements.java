package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

public class TopKFrequentElements {

	public static void main(String[] args) {

	}

	// 5 3 2 1
	//
	// 1 2 3 5
	// 1 1 1 2 2 3 and k = 2 -> 1,2
	// Map
	// {1,3}
	// {2,2}
	// {3,1}
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> res = new ArrayList<>();

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[1] - b[1];
			}
		});

		for (int key : map.keySet()) {
			minHeap.offer(new int[] { key, map.get(key) });
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}

		while (!minHeap.isEmpty()) {
			res.add(minHeap.poll()[0]);
		}
		return res;

	}

}
