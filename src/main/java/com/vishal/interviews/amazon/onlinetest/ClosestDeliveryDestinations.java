package com.vishal.interviews.amazon.onlinetest;

import java.util.*;

public class ClosestDeliveryDestinations {

	public static void main(String[] args) {

		List<List<Integer>> allLocations = new ArrayList<>();
		List<Integer> a1 = new ArrayList<>();
		a1.add(1);
		a1.add(2);

		List<Integer> a2 = new ArrayList<>();
		a2.add(3);
		a2.add(4);

		List<Integer> a3 = new ArrayList<>();
		a3.add(1);
		a3.add(-1);

		List<Integer> a4 = new ArrayList<>();
		a4.add(1);
		a4.add(0);
		
		List<Integer> a5 = new ArrayList<>();
		a5.add(0);
		a5.add(-1);

		allLocations.add(a1);
		allLocations.add(a2);
		allLocations.add(a3);
		allLocations.add(a4);
		allLocations.add(a5);

		System.out.println(ClosestXdestinations(3, allLocations, 2));

	}

	public static List<List<Integer>> ClosestXdestinations(int numDestinations, List<List<Integer>> allLocations,
			int numDeliveries) {
		List<List<Integer>> res = new ArrayList<>();

		PriorityQueue<long[]> maxHeap = new PriorityQueue<>((a, b) -> (int) (b[0] - a[0]));

		for (List<Integer> a : allLocations) {
			if (a.size() != 2) {
				continue;
			}
			long dist = (a.get(0) * a.get(0)) + (a.get(1) * a.get(1));

			maxHeap.offer(new long[] { dist, a.get(0), a.get(1) });
			if (maxHeap.size() > numDeliveries) {
				maxHeap.poll();
			}
		}

		while (!maxHeap.isEmpty()) {
			List<Integer> temp = new ArrayList<>();
			long[] cur = maxHeap.poll();
			temp.add((int) cur[1]);
			temp.add((int) cur[2]);
			res.add(0, temp);
		}

		return res;
	}

}
