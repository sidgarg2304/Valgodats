package com.vishal.interviews.google.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 373. Find K Pairs with Smallest Sums
 * 
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/?tab=Solutions
 * 
 *You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the 
second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:
Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

Return: [1,2],[1,4],[1,6]

The first 3 pairs are returned from the sequence:
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:
Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

Return: [1,1],[1,1]

The first 2 pairs are returned from the sequence:
[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:
Given nums1 = [1,2], nums2 = [3],  k = 3 

Return: [1,3],[2,3]

All possible pairs are returned from the sequence:
[1,3],[2,3]
 */
public class FindKPairswithSmallestSums {

	public static void main(String[] args) {

	}

	/**
	 * simple Java O(KlogK) solution with explanation
	 * 
	 * Basic idea: Use min_heap to keep track on next minimum pair sum, and we
	 * only need to maintain K possible candidates in the data structure.
	 * 
	 * Some observations: For every numbers in nums1, its best partner(yields min
	 * sum) always strats from nums2[0] since arrays are all sorted; And for a
	 * specific number in nums1, its next candidate sould be [this specific
	 * number] + nums2[current_associated_index + 1], unless out of boundary;)
	 * 
	 * @param nums1
	 * @param nums2
	 * @param k
	 * @return
	 */
	public List<int[]> kSmallestPairsSimple(int[] nums1, int[] nums2, int k) {
		PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
		List<int[]> res = new ArrayList<>();
		if (nums1.length == 0 || nums2.length == 0 || k == 0)
			return res;
		for (int i = 0; i < nums1.length && i < k; i++)
			que.offer(new int[] { nums1[i], nums2[0], 0 });
		while (k-- > 0 && !que.isEmpty()) {
			int[] cur = que.poll();
			res.add(new int[] { cur[0], cur[1] });
			if (cur[2] == nums2.length - 1)
				continue;
			que.offer(new int[] { cur[0], nums2[cur[2] + 1], cur[2] + 1 });
		}
		return res;
	}

}

/**
 * Java 9ms heap queue solution, k log(k)
 * 
Frist, we take the first k elements of nums1 and paired with nums2[0] as the starting pairs so that we have (0,0), (1,0), (2,0),.....(k-1,0) in the heap.
Each time after we pick the pair with min sum, we put the new pair with the second index +1. ie, pick (0,0), we put back (0,1). Therefore, the heap alway maintains at most min(k, len(nums1)) elements.
 */
class FindKPairswithSmallestSumsHeapQueue {
	class Pair {
		int[] pair;
		int idx; // current index to nums2
		long sum;

		Pair(int idx, int n1, int n2) {
			this.idx = idx;
			pair = new int[] { n1, n2 };
			sum = (long) n1 + (long) n2;
		}
	}

	class CompPair implements Comparator<Pair> {
		public int compare(Pair p1, Pair p2) {
			return Long.compare(p1.sum, p2.sum);
		}
	}

	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> ret = new ArrayList<>();
		if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
			return ret;
		int len2 = nums2.length;

		PriorityQueue<Pair> q = new PriorityQueue<>(k, new CompPair());
		for (int i = 0; i < nums1.length && i < k; i++) { // only need first k
																		  // number in nums1 to
																		  // start
			q.offer(new Pair(0, nums1[i], nums2[0]));
		}
		for (int i = 1; i <= k && !q.isEmpty(); i++) { // get the first k sums
			Pair p = q.poll();
			ret.add(p.pair);
			if (p.idx < len2 - 1) { // get to next value in nums2
				int next = p.idx + 1;
				q.offer(new Pair(next, p.pair[0], nums2[next]));
			}
		}
		return ret;
	}
}

/**
 * Share My Solution which beat 96.42% This problem is exactly the same as
 * Leetcode378 Kth Smallest Element in a Sorted Matrix, the only difference is
 * this problem give two array while 378 gives a matrix, but they are the same.
 * You can check my previous post for 378 to see how it works.
 * https://discuss.leetcode.com/topic/52948/share-my-thoughts-and-solution
 */
class FindKPairswithSmallest96PercentSolution {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
		int m = nums1.length, n = nums2.length;
		List<int[]> res = new ArrayList<int[]>();
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0)
			return res;
		for (int j = 0; j <= n - 1; j++)
			pq.offer(new Tuple(0, j, nums1[0] + nums2[j]));
		for (int i = 0; i < Math.min(k, m * n); i++) {
			Tuple t = pq.poll();
			res.add(new int[] { nums1[t.x], nums2[t.y] });
			if (t.x == m - 1)
				continue;
			pq.offer(new Tuple(t.x + 1, t.y, nums1[t.x + 1] + nums2[t.y]));
		}
		return res;
	}
	
	class Tuple implements Comparable<Tuple> {
	   int x, y, val;
	   public Tuple (int x, int y, int val) {
	       this.x = x;
	       this.y = y;
	       this.val = val;
	   }
	   
	   @Override
	   public int compareTo (Tuple that) {
	       return this.val - that.val;
	   }
	}

}

