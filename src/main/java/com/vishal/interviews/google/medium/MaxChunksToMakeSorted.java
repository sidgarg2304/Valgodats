package com.vishal.interviews.google.medium;

/**
 * 769. Max Chunks To Make Sorted
 * 
 * Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into some number of "chunks" (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.

What is the most number of chunks we could have made?

Example 1:

Input: arr = [4,3,2,1,0]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
Example 2:

Input: arr = [1,0,2,3,4]
Output: 4
Explanation:
We can split into two chunks, such as [1, 0], [2, 3, 4].
However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
Note:

arr will have length in range [1, 10].
arr[i] will be a permutation of [0, 1, ..., arr.length - 1].
 *
 */
public class MaxChunksToMakeSorted {

	public static void main(String[] args) {

	}
	
	/**
	 * Approach #1: Brute Force [Accepted]
Intuition and Algorithm

Let's try to find the smallest left-most chunk. If the first k elements are [0, 1, ..., k-1], then it can be broken into a chunk, and we have a smaller instance of the same problem.

We can check whether k+1 elements chosen from [0, 1, ..., n-1] are [0, 1, ..., k] by checking whether the maximum of that choice is k.

Complexity Analysis

Time Complexity: O(N)O(N), where NN is the length of arr

Space Complexity: O(1)O(1).
	 */
	public int maxChunksToSorted(int[] arr) {
      int ans = 0, max = 0;
      for (int i = 0; i < arr.length; ++i) {
          max = Math.max(max, arr[i]);
          if (max == i) ans++;
      }
      return ans;
  }

}
