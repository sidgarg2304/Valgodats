package com.vishal.interviews.programcreek.math;

import java.util.*;

public class SuperUglyNumber {

	public static void main(String[] args) {

	}

	public int nthSuperUglyNumber(int n, int[] primes) {

		int[] ugly = new int[n];
		ugly[0] = 1;
		PriorityQueue<Ugly> minHeap = new PriorityQueue<>(new Comparator<Ugly>() {
			public int compare(Ugly a, Ugly b) {
				return a.ugly - b.ugly;
			}
		});

		for (int i = 0; i < primes.length; i++) {
			minHeap.offer(new Ugly(primes[i], primes[i], 0));
		}

		for (int i = 1; i < n; i++) {
			Ugly cur = minHeap.peek();
			ugly[i] = cur.ugly;

			while (!minHeap.isEmpty() && minHeap.peek().ugly == ugly[i]) {
				Ugly dupUgly = minHeap.poll();
				minHeap.offer(
						new Ugly(dupUgly.primeFactor * ugly[dupUgly.index + 1], dupUgly.primeFactor, dupUgly.index + 1));
			}

		}
		return ugly[n - 1];

	}

}

class Ugly {
	int ugly;
	int primeFactor;
	int index;

	Ugly(int ugly, int primeFactor, int index) {
		this.ugly = ugly;
		this.primeFactor = primeFactor;
		this.index = index;

	}
}
