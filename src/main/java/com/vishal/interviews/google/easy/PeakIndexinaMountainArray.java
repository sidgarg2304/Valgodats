package com.vishal.interviews.google.easy;

/**
 * 852. Peak Index in a Mountain Array
 * Let's call an array A a mountain if the following properties hold:

A.length >= 3
There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].

Example 1:

Input: [0,1,0]
Output: 1
Example 2:

Input: [0,2,1,0]
Output: 1
Note:

3 <= A.length <= 10000
0 <= A[i] <= 10^6
A is a mountain, as defined above.
 *
 */
public class PeakIndexinaMountainArray {

	public static void main(String[] args) {

	}
	
	/**
	 * Approach 1: Linear Scan
Intuition and Algorithm

The mountain increases until it doesn't. The point at which it stops increasing is the peak.

Complexity Analysis

Time Complexity: O(N)O(N), where NN is the length of A.

Space Complexity: O(1)O(1).
	 */
	public int peakIndexInMountainArrayLinearScan(int[] A) {
      int i = 0;
      while (A[i] < A[i+1]) i++;
      return i;
  }
	
	/**
	 * Approach 2: Binary Search
Intuition and Algorithm

The comparison A[i] < A[i+1] in a mountain array looks like [True, True, True, ..., True, False, False, ..., False]: 1 or more boolean Trues, followed by 1 or more boolean False. For example, in the mountain array [1, 2, 3, 4, 1], the comparisons A[i] < A[i+1] would be True, True, True, False.

We can binary search over this array of comparisons, to find the largest index i such that A[i] < A[i+1]. For more on binary search, see the LeetCode explore topic here.

Complexity Analysis

Time Complexity: O(\log N)O(logN), where NN is the length of A.

Space Complexity: O(1)O(1).
	 * @param A
	 * @return
	 */
	public int peakIndexInMountainArrayBinary(int[] A) {
      int lo = 0, hi = A.length - 1;
      while (lo < hi) {
          int mi = lo + (hi - lo) / 2;
          if (A[mi] < A[mi + 1])
              lo = mi + 1;
          else
              hi = mi;
      }
      return lo;
  }

}
