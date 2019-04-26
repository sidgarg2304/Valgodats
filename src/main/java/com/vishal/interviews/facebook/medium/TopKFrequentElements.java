package com.vishal.interviews.facebook.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> res = new ArrayList<>();

		if(nums == null || k > nums.length){
			return res;
		}
		Map<Integer, Integer> countMap = new HashMap<>();
		for (int i : nums) {
			countMap.put(i, countMap.getOrDefault(i, 0) + 1);
		}

		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		for (Map.Entry<Integer, Integer> e : countMap.entrySet()) {
			minHeap.offer(new int[] { e.getValue(), e.getKey() });
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}
		System.out.println("min " + minHeap);

		for (int[] e : minHeap) {
			res.add(e[1]);
		}
		return res;
	}

}
