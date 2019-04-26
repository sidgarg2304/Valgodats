package com.vishal.interviews.google.medium;

import java.util.*;

/**
 * 756. Pyramid Transition Matrix
 * 
 * We are stacking blocks to form a pyramid. Each block has a color which is a one letter string, like `'Z'`.

For every block of color `C` we place not in the bottom row, we are placing it on top of a left block of color `A` and right block of color `B`. We are allowed to place the block there only if `(A, B, C)` is an allowed triple.

We start with a bottom row of bottom, represented as a single string. We also start with a list of allowed triples allowed. Each allowed triple is represented as a string of length 3.

Return true if we can build the pyramid all the way to the top, otherwise false.

Example 1:
Input: bottom = "XYZ", allowed = ["XYD", "YZE", "DEA", "FFF"]
Output: true
Explanation:
We can stack the pyramid like this:
    A
   / \
  D   E
 / \ / \
X   Y   Z

This works because ('X', 'Y', 'D'), ('Y', 'Z', 'E'), and ('D', 'E', 'A') are allowed triples.
Example 2:
Input: bottom = "XXYX", allowed = ["XXX", "XXY", "XYX", "XYY", "YXZ"]
Output: false
Explanation:
We can't stack the pyramid to the top.
Note that there could be allowed triples (A, B, C) and (A, B, D) with C != D.
Note:
bottom will be a string with length in range [2, 8].
allowed will have length in range [0, 200].
Letters in all strings will be chosen from the set {'A', 'B', 'C', 'D', 'E', 'F', 'G'}.
 *
 */
public class PyramidTransitionMatrix {

	public static void main(String[] args) {

	}
	
	/**
	 * Approach #1: State to State Transition [Wrong Answer]
Intuition and Algorithm

We model the states that blocks can be in. Each state is a binary number where the kth bit is set if the kth type of block is a possibility. Then, we create a transition map T[state1][state2] -> state that takes a left state and a right state and outputs all possible parent states.

At the end, applying these transitions is straightforward. However, this approach is not correct, because the transitions are not independent. If for example we have states in a row A, {B or C}, A, and allowed triples (A, B, D), (C, A, D), then regardless of the choice of {B or C} we cannot create the next row of the pyramid.

Complexity Analysis

Time Complexity: O(2^{2\mathcal{A}}A + N^2)O(2
​2A
​​ A+N
​2
​​ ), where NN is the length of bottom, AA is the length of allowed, and \mathcal{A}A is the size of the alphabet.

Space Complexity: O(2^{2\mathcal{A}})O(2
​2A
​​ ) in additional space complexity.
	 */
	public boolean pyramidTransition(String bottom, List<String> allowed) {
      int[][] T = new int[1 << 7][1 << 7];
      for (String triple: allowed) {
          int u = 1 << (triple.charAt(0) - 'A');
          int v = 1 << (triple.charAt(1) - 'A');
          int w = 1 << (triple.charAt(2) - 'A');
          for (int b1 = 0; b1 < (1 << 7); ++b1) if ((u & b1) > 0)
              for (int b2 = 0; b2 < (1 << 7); ++b2) if ((v & b2) > 0)
                  T[b1][b2] |= w;
      }

      int[] state = new int[bottom.length()];
      int t = 0;
      for (char c: bottom.toCharArray())
          state[t++] = 1 << (c - 'A');
      while (t-- > 1)
          for (int i = 0; i < t; ++i)
              state[i] = T[state[i]][state[i+1]];
      return state[0] > 0;
  }
	
	/**
	 * Approach #2: Depth-First Search [Accepted]
Intuition

We exhaustively try every combination of blocks.

Algorithm

We can work in either strings or integers, but we need to create a transition map T from the list of allowed triples. This map T[x][y] = {set of z} will be all possible parent blocks for a left child of x and a right child of y. When we work in strings, we use Set, and when we work in integers, we will use the set bits of the result integer.

Afterwards, to solve a row, we generate every possible combination of the next row and solve them. If any of those new rows are solvable, we return True, otherwise False.

We can also cache intermediate results, saving us time. This is illustrated in the comments for Python. For Java, all caching is done with lines of code that mention the integer R.

Complexity Analysis

Time Complexity: O(\mathcal{A}^{N})O(A
​N
​​ ), where NN is the length of bottom, and \mathcal{A}A is the size of the alphabet, and assuming we cache intermediate results. We might try every sequence of letters for each row. [The total complexity is because O(\sum_{k}^n \mathcal{A}^{k})O(∑
​k
​n
​​ A
​k
​​ ) is a geometric series equal to O(\frac{\mathcal{A^{n+1}}-1}{\mathcal{A}-1})O(
​A−1
​
​A
​n+1
​​ −1
​​ ).] Without intermediate caching, this would be O(\mathcal{A}^{N^2})O(A
​N
​2
​​ 
​​ ).

Space Complexity: O(N^2)O(N
​2
​​ ) additional space complexity.
	 */
	int[][] T;
   Set<Long> seen;

   public boolean pyramidTransitionDFS(String bottom, List<String> allowed) {
       T = new int[7][7];
       for (String a: allowed)
           T[a.charAt(0) - 'A'][a.charAt(1) - 'A'] |= 1 << (a.charAt(2) - 'A');

       seen = new HashSet();
       int N = bottom.length();
       int[][] A = new int[N][N];
       int t = 0;
       for (char c: bottom.toCharArray())
           A[N-1][t++] = c - 'A';
       return solve(A, 0, N-1, 0);
   }

   //A[i] - the ith row of the pyramid
   //R - integer representing the current row of the pyramid
   //N - length of current row we are calculating
   //i - index of how far in the current row we are calculating
   //Returns true iff pyramid can be built
   public boolean solve(int[][] A, long R, int N, int i) {
       if (N == 1 && i == 1) { // If successfully placed entire pyramid
           return true;
       } else if (i == N) {
           if (seen.contains(R)) return false; // If we've already tried this row, give up
           seen.add(R); // Add row to cache
           return solve(A, 0, N-1, 0); // Calculate next row
       } else {
           // w's jth bit is true iff block #j could be
           // a parent of A[N][i] and A[N][i+1]
           int w = T[A[N][i]][A[N][i+1]];
           // for each set bit in w...
           for (int b = 0; b < 7; ++b) if (((w >> b) & 1) != 0) {
               A[N-1][i] = b; //set parent to be equal to block #b
               //If rest of pyramid can be built, return true
               //R represents current row, now with ith bit set to b+1
               // in base 8.
               if (solve(A, R * 8 + (b+1), N, i+1)) return true;
           }
           return false;
       }
   }
}


