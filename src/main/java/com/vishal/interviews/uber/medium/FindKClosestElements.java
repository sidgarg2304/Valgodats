package com.vishal.interviews.uber.medium;

import java.util.*;

public class FindKClosestElements {

	public static void main(String[] args) {

	}

	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> res = new ArrayList<>();
		
		if(arr == null || arr.length == 0) {
			return res;
		}

		PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] == a[1] ? b[0] - a[0] : b[1] - a[1]);

		for (int i = 0; i < arr.length; i++) {
			maxHeap.offer(new int[] { arr[i], Math.abs(arr[i] - x) });
			if(maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		
		while(!maxHeap.isEmpty()) {
			res.add(maxHeap.poll()[0]);
		}
		Collections.sort(res);
		return res;
	}

}
