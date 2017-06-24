package com.vishal.interviews.programcreek;

import java.util.*;

public class TopKFrequentElements {

	public static void main(String[] args) {

	}

	public List<Integer> topKFrequent(int[] nums, int k) {
		
		
		List<Integer> res = new ArrayList<>();

		if(nums == null || nums.length == 0){
			return res;
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[1] - b[1];
			}
		});

		for (int key : map.keySet()) {
			minHeap.offer(new int[] { key, map.get(key) });
			if(minHeap.size() > k){
				minHeap.poll();				
			}
		}
		
		while(minHeap.isEmpty()){
			res.add(minHeap.poll()[0]);
		}
		
		return res;
	}

}
