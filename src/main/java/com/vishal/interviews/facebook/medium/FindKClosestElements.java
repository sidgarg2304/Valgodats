package com.vishal.interviews.facebook.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> findClosestElements(int[] arr, int k, int x) {

		List<Integer> res = new ArrayList<>();

		PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] == a[1] ? b[0] - a[0] : b[1] - a[1]);

		for (int i : arr) {
			maxHeap.offer(new int[] { i, Math.abs(i - k) });
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		while (!maxHeap.isEmpty()) {
			res.add(maxHeap.poll()[0]);
		}
		return res;
	}

}
