package com.vishal.interviews.google.hard;

import java.util.*;
/**
 * 768. Max Chunks To Make Sorted II
 * 
 * This question is the same as "Max Chunks to Make Sorted" except the integers of the given array are not necessarily distinct, the input array could be up to length 2000, and the elements could be up to 10**8.

Given an array arr of integers (not necessarily distinct), we split the array into some number of "chunks" (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.

What is the most number of chunks we could have made?

Example 1:

Input: arr = [5,4,3,2,1]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [5, 4], [3, 2, 1] will result in [4, 5, 1, 2, 3], which isn't sorted.
Example 2:

Input: arr = [2,1,3,4,4]
Output: 4
Explanation:
We can split into two chunks, such as [2, 1], [3, 4, 4].
However, splitting into [2, 1], [3], [4], [4] is the highest number of chunks possible.
Note:

arr will have length in range [1, 2000].
arr[i] will be an integer in range [0, 10**8].
 


 *
 */
public class MaxChunksToMakeSortedII {

	public static void main(String[] args) {

	}
	
	/**
	 * Approach #1: Sliding Window [Accepted]
Intuition

Let's try to find the smallest left-most chunk.

Algorithm

Notice that if a1,a2,…,am is a chunk, and a1,a2,…,an is a chunk (m < nm<n), then am+1,am+2,…,an is a chunk too. This shows that a greedy approach produces the highest number of chunks.

We know the array arr should end up like expect = sorted(arr). If the count of the first k elements minus the count what those elements should be is zero everywhere, then the first k elements form a valid chunk. We repeatedly perform this process.

We can use a variable nonzero to count the number of letters where the current count is non-zero.
	 * @param arr
	 * @return
	 */
	 public int maxChunksToSorted(int[] arr) {
       Map<Integer, Integer> count = new HashMap();
       int ans = 0, nonzero = 0;

       int[] expect = arr.clone();
       Arrays.sort(expect);

       for (int i = 0; i < arr.length; ++i) {
           int x = arr[i], y = expect[i];

           count.put(x, count.getOrDefault(x, 0) + 1);
           if (count.get(x) == 0) nonzero--;
           if (count.get(x) == 1) nonzero++;

           count.put(y, count.getOrDefault(y, 0) - 1);
           if (count.get(y) == -1) nonzero++;
           if (count.get(y) == 0) nonzero--;

           if (nonzero == 0) ans++;
       }

       return ans;
   }
	 
	 /**
	  * Approach #2: Sorted Count Pairs [Accepted]
Intuition

As in Approach #1, let's try to find the smallest left-most chunk, where we have some expectation expect = sorted(arr)

If the elements were distinct, then it is enough to find the smallest k with max(arr[:k+1]) == expect[k], as this must mean the elements of arr[:k+1] are some permutation of expect[:k+1].

Since the elements are not distinct, this fails; but we can amend the cumulative multiplicity of each element to itself to make the elements distinct.

Algorithm

Instead of elements x, have counted elements (x, count) where count ranges from 1 to the total number of x present in arr.

Now cur will be the cumulative maximum of counted[:k+1], where we expect a result of Y = expect[k]. We count the number of times they are equal.
Complexity Analysis

Time Complexity: O(N \log N)O(NlogN), where NN is the length of arr

Space Complexity: O(N)O(N).

	  */
	 public int maxChunksToSortedUsingPairs(int[] arr) {
       Map<Integer, Integer> count = new HashMap();
       List<Pair> counted = new ArrayList();
       for (int x: arr) {
           count.put(x, count.getOrDefault(x, 0) + 1);
           counted.add(new Pair(x, count.get(x)));
       }

       List<Pair> expect = new ArrayList(counted);
       Collections.sort(expect, (a, b) -> a.compare(b));

       Pair cur = counted.get(0);
       int ans = 0;
       for (int i = 0; i < arr.length; ++i) {
           Pair X = counted.get(i), Y = expect.get(i);
           if (X.compare(cur) > 0) cur = X;
           if (cur.compare(Y) == 0) ans++;
       }

       return ans;
   }
	 
	 private class Pair {
	    int val, count;
	    Pair(int v, int c) {
	        val = v; count = c;
	    }
	    int compare(Pair that) {
	        return this.val != that.val ? this.val - that.val : this.count - that.count;
	    }
	}
}