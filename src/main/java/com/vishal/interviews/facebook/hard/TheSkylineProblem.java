package com.vishal.interviews.facebook.hard;

import java.util.*;

public class TheSkylineProblem {

	public static void main(String[] args) {

	}

	public List<int[]> getSkyline(int[][] buildings) {

		List<int[]> res = new ArrayList<>();

		List<int[]> heights = new ArrayList<>();

		for (int[] building : buildings) {
			heights.add(new int[] { building[0], -building[2] });
			heights.add(new int[] { building[1], building[2] });
		}

		Collections.sort(heights, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0]) {
					return a[1] - b[1];
				}

				return a[0] - b[0];
			}
		});

		PriorityQueue<Integer> maxHeightHeap = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		maxHeightHeap.offer(0);
		int prevPeek = 0;
		for (int[] height : heights) {
			int curHeight = Math.abs(height[1]);
			if (height[1] < 0) {
				maxHeightHeap.offer(curHeight);
			} else {
				maxHeightHeap.remove(curHeight);
			}

			int curPeek = maxHeightHeap.peek();

			if (curPeek > prevPeek) {
				res.add(new int[] { height[0], curPeek });
				prevPeek = curPeek;
			}
		}

		return res;
	}

}
