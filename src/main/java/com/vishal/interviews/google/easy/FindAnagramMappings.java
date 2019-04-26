package com.vishal.interviews.google.easy;

import java.util.*;

/**
 * 760. Find Anagram Mappings
 * 
 * 
 * Given two lists Aand B, and B is an anagram of A. B is an anagram of A means B is made by randomizing the order of the elements in A.

We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.

These lists A and B may contain duplicates. If there are multiple answers, output any of them.

For example, given

A = [12, 28, 46, 32, 50]
B = [50, 12, 32, 46, 28]
We should return
[1, 4, 3, 2, 0]
as P[0] = 1 because the 0th element of A appears at B[1], and P[1] = 4 because the 1st element of A appears at B[4], and so on.
Note:

A, B have equal lengths in range [1, 100].
A[i], B[i] are integers in range [0, 10^5].
 *
 */
public class FindAnagramMappings {

	public static void main(String[] args) {

	}
	
	public int[] anagramMappingsEasy(int[] A, int[] B) {

		if (A == null || A.length == 0) {
			return new int[] {};
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < B.length; i++) {
			map.put(B[i], i);
		}

		int[] res = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			res[i] = map.get(A[i]);
		}
		return res;
	}
	
	/**
	 * Approach #1: Hash Table [Accepted]
Intuition

Take the example A = [12, 28, 46], B = [46, 12, 28]. We want to know where the 12 occurs in B, say at position 1; then where the 28 occurs in B, which is position 2; then where the 46 occurs in B, which is position 0.

If we had a dictionary (hash table) D = {46: 0, 12: 1, 28: 2}, then this question could be handled easily.

Algorithm

Create the hash table D as described above. Then, the answer is a list of D[A[i]] for i = 0, 1, ....

Complexity Analysis

Time Complexity: O(N)O(N), where NN is the length of AA.

Space Complexity: O(N)O(N).
	 */
	public int[] anagramMappings(int[] A, int[] B) {
      Map<Integer, Integer> D = new HashMap();
      for (int i = 0; i < B.length; ++i)
          D.put(B[i], i);

      int[] ans = new int[A.length];
      int t = 0;
      for (int x: A)
          ans[t++] = D.get(x);
      return ans;
  }

}
