package com.vishal.interviews.top100linkedquestions.hard;

import java.util.*;

public class TheSkylineProblem {

	public static void main(String[] args) {

	}

	public List<int[]> getSkyline(int[][] buildings) {

		List<int[]> res = new ArrayList<>();

		if (buildings == null || buildings.length == 0) {
			return res;
		}

		List<int[]> heights = new ArrayList<>();
		for (int[] bldg : buildings) {
			heights.add(new int[] { bldg[0], -bldg[2] });
			heights.add(new int[] { bldg[1], bldg[2] });
		}

		Collections.sort(heights, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] == b[0]) {
					return a[1] - b[1];
				}

				return a[0] - b[0];
			}
		});

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
		maxHeap.offer(0);
		int prev = 0;

		for (int[] h : heights) {
			if (h[1] < 0) {
				maxHeap.offer(Math.abs(h[1]));
			} else {
				maxHeap.remove(h[1]);
			}

			if (maxHeap.peek() != prev) {
				res.add(new int[] {h[0], maxHeap.peek()});
				prev = maxHeap.peek();
			}
		}

		return res;
	}

}
