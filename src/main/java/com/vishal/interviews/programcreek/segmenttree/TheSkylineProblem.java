package com.vishal.interviews.programcreek.segmenttree;

import java.util.*;

public class TheSkylineProblem {

	public static void main(String[] args) {

	}

	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> res = new ArrayList<>();

		List<int[]> heights = new ArrayList<>();

		for (int[] bldg : buildings) {
			heights.add(new int[] { bldg[0], -bldg[2] });
			heights.add(new int[] { bldg[1], bldg[2] });
		}

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		int prev = 0;
		maxHeap.offer(0);

		for (int[] h : heights) {
			if (h[1] < 0) {
				maxHeap.offer(Math.abs(h[1]));
			} else {
				maxHeap.remove(h[1]);
			}
			
			if(maxHeap.peek() > prev){
				res.add(new int[]{h[0], maxHeap.peek()});
				prev = maxHeap.peek();
			}
		}

		return res;
	}

}
