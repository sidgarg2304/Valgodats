package com.vishal.interviews.google.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 313. Super Ugly Number
 * 
 * Write a program to find the nth super ugly number.
 * 
 * Super ugly numbers are positive numbers whose all prime factors are in the
 * given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16,
 * 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given
 * primes = [2, 7, 13, 19] of size 4.
 * 
 * Note:
 * 
 * (1) 1 is a super ugly number for any given primes.
 * 
 * (2) The given numbers in primes are in ascending order.
 * 
 * (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 * 
 * (4) The nth super ugly number is guaranteed to fit in a 32-bit signed
 * integer.
 */
public class SuperUglyNumber {

	public static void main(String[] args) {

	}

	/**
	 * Basic idea is same as ugly number II, new ugly number is generated by
	 * multiplying a prime with previous generated ugly number. One catch is need
	 * to remove duplicate
	 * 
	 * Let's start with the common solution from ugly number II 36 ms,
	 * Theoretically O(kN)
	 * 
	 * @param n
	 * @param primes
	 * @return
	 */
	public int nthSuperUglyNumberI(int n, int[] primes) {
		int[] ugly = new int[n];
		int[] idx = new int[primes.length];

		ugly[0] = 1;
		for (int i = 1; i < n; i++) {
			// find next
			ugly[i] = Integer.MAX_VALUE;
			for (int j = 0; j < primes.length; j++)
				ugly[i] = Math.min(ugly[i], primes[j] * ugly[idx[j]]);

			// slip duplicate
			for (int j = 0; j < primes.length; j++) {
				while (primes[j] * ugly[idx[j]] <= ugly[i])
					idx[j]++;
			}
		}

		return ugly[n - 1];
	}

	/**
	 * If you look at the above solution, it has redundant multiplication can be
	 * avoided, and also two for loops can be consolidated into one. This
	 * trade-off space for speed. 23 ms, Theoretically O(kN)
	 * 
	 * @param n
	 * @param primes
	 * @return
	 */
	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] ugly = new int[n];
		int[] idx = new int[primes.length];
		int[] val = new int[primes.length];
		Arrays.fill(val, 1);

		int next = 1;
		for (int i = 0; i < n; i++) {
			ugly[i] = next;

			next = Integer.MAX_VALUE;
			for (int j = 0; j < primes.length; j++) {
				// skip duplicate and avoid extra multiplication
				if (val[j] == ugly[i])
					val[j] = ugly[idx[j]++] * primes[j];
				// find next ugly number
				next = Math.min(next, val[j]);
			}
		}

		return ugly[n - 1];
	}

	/**
	 * Can we do better? Theoretically yes, by keep the one candidates for each
	 * prime in a heap, it can improve the theoretical bound to O( log(k)N ), but
	 * in reality it's 58 ms. I think it's the result of using higher level
	 * object instead of primitive. Can be improved by writing an index heap
	 * (http://algs4.cs.princeton.edu/24pq/IndexMinPQ.java.html)
	 * 
	 * @param n
	 * @param primes
	 * @return
	 */
	public int nthSuperUglyNumberHeap(int n, int[] primes) {
		int[] ugly = new int[n];

		PriorityQueue<Num> pq = new PriorityQueue<>();
		for (int i = 0; i < primes.length; i++)
			pq.add(new Num(primes[i], 1, primes[i]));
		ugly[0] = 1;

		for (int i = 1; i < n; i++) {
			ugly[i] = pq.peek().val;
			while (pq.peek().val == ugly[i]) {
				Num nxt = pq.poll();
				pq.add(new Num(nxt.p * ugly[nxt.idx], nxt.idx + 1, nxt.p));
			}
		}

		return ugly[n - 1];
	}

	private class Num implements Comparable<Num> {
		int val;
		int idx;
		int p;

		public Num(int val, int idx, int p) {
			this.val = val;
			this.idx = idx;
			this.p = p;
		}

		@Override
		public int compareTo(Num that) {
			return this.val - that.val;
		}
	}

	/**
	 * 108ms easy to understand java solution
	 * 
	 * @param n
	 * @param primes
	 * @return
	 */
	public int nthSuperUglyNumberEasySolution(int n, int[] primes) {
		int[] ret = new int[n];
		ret[0] = 1;

		int[] indexes = new int[primes.length];

		for (int i = 1; i < n; i++) {
			ret[i] = Integer.MAX_VALUE;

			for (int j = 0; j < primes.length; j++) {
				ret[i] = Math.min(ret[i], primes[j] * ret[indexes[j]]);
			}

			for (int j = 0; j < indexes.length; j++) {
				if (ret[i] == primes[j] * ret[indexes[j]]) {
					indexes[j]++;
				}
			}
		}

		return ret[n - 1];
	}

}
