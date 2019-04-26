package com.vishal.interviews.uber.hard;

import java.util.*;

public class TheSkylineProblem {

	public static void main(String[] args) {

	}

	public List<int[]> getSkyline(int[][] buildings) {

		List<int[]> heights = new ArrayList<>();
		for (int[] b : buildings) {
			heights.add(new int[] { b[0], -b[2] });
			heights.add(new int[] { b[1], b[2] });
		}

		Collections.sort(heights, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

		List<int[]> res = new ArrayList<>();
		int prevPeek = 0;

		for (int[] h : heights) {
			if (h[1] < 0) {
				maxHeap.offer(Math.abs(h[1]));
			} else {
				maxHeap.remove(h[1]);
			}

			int curPeek = maxHeap.peek();
			if (curPeek != prevPeek) {
				res.add(new int[] { h[0], curPeek });
				prevPeek = curPeek;
			}
		}
		return res;
	}

}
