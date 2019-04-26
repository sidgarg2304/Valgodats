package com.vishal.interviews.google.medium;

import java.util.*;

import com.vishal.interviews.util.Point;

/**
 * 835. Image Overlap
 * 
 * 
 * Two images A and B are given, represented as binary, square matrices of the same size.  (A binary matrix has only 0s and 1s as values.)

We translate one image however we choose (sliding it left, right, up, or down any number of units), and place it on top of the other image.  After, the overlap of this translation is the number of positions that have a 1 in both images.

(Note also that a translation does not include any kind of rotation.)

What is the largest possible overlap?

Example 1:

Input: A = [[1,1,0],
            [0,1,0],
            [0,1,0]]
       B = [[0,0,0],
            [0,1,1],
            [0,0,1]]
Output: 3
Explanation: We slide A to right by 1 unit and down by 1 unit.
Notes: 

1 <= A.length = A[0].length = B.length = B[0].length <= 30
0 <= A[i][j], B[i][j] <= 1

 *
 */
public class ImageOverlap {

	public static void main(String[] args) {

	}
	
	/**
	 * Approach #1: Translate by Delta [Accepted]
Intuition and Algorithm

For each translation delta, we calculate the candidate answer overlap(delta), which is the size of the overlap if we shifted the matrix A by delta.

We only need to check delta for which some point in A maps to some point in B, since a candidate overlap must be at least 1. Using seen, we don't perform this expensive check more than once per delta.

We use java.awt.Point (or complex in Python) to handle our 2D vectors gracefully. We could have also mapped a vector delta = (x, y) (which has coordinates between -(N-1) and N-1) to 2*N x + y for convenience. Note that we cannot map it to N*dx, dy as there would be interference: (0, N-1) and (1, -1) would map to the same point.

Complexity Analysis

Time Complexity: O(N^6)O(N
​6
​​ ), where NN is the length of A or B.

Space Complexity: O(N^2)O(N
​2
​​ ).
	 */
	public int largestOverlap(int[][] A, int[][] B) {
      int N = A.length;
      List<Point> A2 = new ArrayList(), B2 = new ArrayList();
      for (int i = 0; i < N*N; ++i) {
          if (A[i/N][i%N] == 1) A2.add(new Point(i/N, i%N));
          if (B[i/N][i%N] == 1) B2.add(new Point(i/N, i%N));
      }

      Set<Point> Bset = new HashSet(B2);

      int ans = 0;
      Set<Point> seen = new HashSet();
      for (Point a: A2) for (Point b: B2) {
          Point delta = new Point(b.x - a.x, b.y - a.y);
          if (!seen.contains(delta)) {
              seen.add(delta);
              int cand = 0;
              for (Point p: A2)
                  if (Bset.contains(new Point(p.x + delta.x, p.y + delta.y)))
                      cand++;
              ans = Math.max(ans, cand);
          }
      }

      return ans;
  }
	
	/**
	 * Approach #2: Count by Delta [Accepted]
Intuition and Algorithm

We can do the reverse of Approach #1: count every possible delta = b - a we see. If we see say, 5 of the same delta = b - a, then the translation by delta must have overlap 5.

Complexity Analysis

Time Complexity: O(N^4)O(N
​4
​​ ), where NN is the length of A or B.

Space Complexity: O(N^2)O(N
​2
​​ ).


	 */
	public int largestOverlapCountByDelta(int[][] A, int[][] B) {
      int N = A.length;
      int[][] count = new int[2*N+1][2*N+1];
      for (int i = 0; i < N; ++i)
          for (int j = 0; j < N; ++j)
              if (A[i][j] == 1)
                  for (int i2 = 0; i2 < N; ++i2)
                      for (int j2 = 0; j2 < N; ++j2)
                          if (B[i2][j2] == 1)
                              count[i-i2 +N][j-j2 +N] += 1;

      int ans = 0;
      for (int[] row: count)
          for (int v: row)
              ans = Math.max(ans, v);
      return ans;
  }
}
