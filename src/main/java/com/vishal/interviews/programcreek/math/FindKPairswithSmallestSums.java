package com.vishal.interviews.programcreek.math;

import java.util.*;

public class FindKPairswithSmallestSums {

	public static void main(String[] args) {

	}

	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> res = new ArrayList<>();

		PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return (a[0] + a[1]) - (b[0] + b[1]);
			}
		});
		for (int i = 0; i < nums1.length; i++) {
			minHeap.offer(new int[] { nums1[i], nums2[0], 0 });
		}

		for (int i = 0; i < k; i++) {
			int[] cur = minHeap.isEmpty() ? null : minHeap.poll();
			if (cur == null) {
				break;
			}
			res.add(new int[] { cur[0], cur[1] });

			if (cur[2] < nums2.length - 1) {
				minHeap.offer(new int[] { cur[0], nums2[cur[2] + 1], cur[2] + 1 });
			}
		}

		return res;
	}

}
