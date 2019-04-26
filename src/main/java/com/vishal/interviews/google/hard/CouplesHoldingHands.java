package com.vishal.interviews.google.hard;

import java.util.*;
/**
 * 765. Couples Holding Hands
 * 
 * N couples sit in 2N seats arranged in a row and want to hold hands. We want to know the minimum number of swaps so that every couple is sitting side by side. A swap consists of choosing any two people, then they stand up and switch seats.

The people and seats are represented by an integer from 0 to 2N-1, the couples are numbered in order, the first couple being (0, 1), the second couple being (2, 3), and so on with the last couple being (2N-2, 2N-1).

The couples' initial seating is given by row[i] being the value of the person who is initially sitting in the i-th seat.

Example 1:

Input: row = [0, 2, 1, 3]
Output: 1
Explanation: We only need to swap the second (row[1]) and third (row[2]) person.
Example 2:

Input: row = [3, 2, 0, 1]
Output: 0
Explanation: All couples are already seated side by side.
Note:

len(row) is even and in the range of [4, 60].
row is guaranteed to be a permutation of 0...len(row)-1.
 *
 */

/**
 * Approach Framework
Observations

First, instead of couples (0, 1), (2, 3), (4, 5), ..., we could just consider couples (0, 0), (1, 1), (2, 2), ... without changing the answer. Also, we could imagine that we have N two-seat couches 0, 1, 2, ..., N-1. This is because the person sitting on the left-most seat of the row must be paired with the person sitting on the second-left-most seat, the third-left-most paired with the fourth-left-most, and so on. Call a person happy if they are with their partner on the same couch. Intuitively, a swap that keeps both persons swapped unhappy is not part of some optimal solution. We'll call this the happy swap assumption (HSA), and we'll prove it in Approach #2.


 *
 */
public class CouplesHoldingHands {

	public static void main(String[] args) {

	}
	
	/**
	 * Approach #1: Backtracking [Time Limit Exceeded]
Intuition

We could guess without proof that a solution where we make the people on each couch happy in order is optimal. This assumption is stronger than HSA, but it seems reasonable because at each move we are making at least 1 couple happy. (See Approach #2 for a proof.) Under such an assumption, for some couch with unhappy people X and Y, we either replace Y with X's partner, or replace X with Y's partner. For each of the two possibilities, we can try both using a backtracking approach.

Algorithm

For each couch with two possibilities (ie. both people on the couch are unhappy), we will try the first possibility, find the answer as ans1, then undo our move and try the second possibility, find the associated answer as ans2, undo our move and then return the smallest answer.

Complexity Analysis

Time Complexity: O(N * 2^N)O(N∗2
​N
​​ ), where NN is the number of couples, as for each couch we check up to two complete possibilities. The NN factor is from searching for jx and jy; this factor can be removed with a more efficient algorithm that keeps track of where pairs[j][k] is x as we swap elements through pairs.

Space Complexity: O(N)O(N).
	 */
	int N;
   int[][] pairs;

   public int minSwapsCouples(int[] row) {
       N = row.length / 2;
       pairs = new int[N][2];
       for (int i = 0; i < N; ++i) {
           pairs[i][0] = row[2*i] / 2;
           pairs[i][1] = row[2*i+1] / 2;
       }

       return solve(0);
   }

   public void swap(int a, int b, int c, int d) {
       int t = pairs[a][b];
       pairs[a][b] = pairs[c][d];
       pairs[c][d] = t;
   }

   public int solve(int i) {
       if (i == N) return 0;
       int x = pairs[i][0], y = pairs[i][1];
       if (x == y) return solve(i+1);

       int jx=0, kx=0, jy=0, ky=0; // Always gets set later
       for (int j = i+1; j < N; ++j) {
           for (int k = 0; k <= 1; ++k) {
               if (pairs[j][k] == x) {jx = j; kx = k;}
               if (pairs[j][k] == y) {jy = j; ky = k;}
           }
       }

       swap(i, 1, jx, kx);
       int ans1 = 1 + solve(i+1);
       swap(i, 1, jx, kx);

       swap(i, 0, jy, ky);
       int ans2 = 1 + solve(i+1);
       swap(i, 0, jy, ky);

       return Math.min(ans1, ans2);
   }
   
   
   /**
    * Approach #2: Cycle Finding [Accepted]
Intuition

If we take the HSA as true, it means that if a couple is on two separate couches, there are two possible moves to make this couple happy, depending on which partner visits their partner and which stays in place. This leads to the following idea: for each couple sitting at couches X and Y (possibly the same), draw an undirected edge from X to Y. Call such a graph the couples graph. This graph is 2-regular (every node has degree 2), and it is easy to see that every connected component of this graph must be a cycle.
    * 
    * Then, making a swap for X_1X
​1
​​  to meet their partner X_2X
​2
​​  has a corresponding move on the couples graph equivalent to contracting the corresponding edge to X_1X_2X
​1
​​ X
​2
​​  plus having a node with a single self edge. Our goal is to have N connected components in the graph, one for each couch. Every swap (allowed by the scheme above) always increases that number by exactly 1, so under HSA, the answer is just N minus the number of connected components in the couples graph.

Now to prove HSA, observe that it is impossible with any swap to create more than 1 additional connected component in the couples graph. So any optimal solution must have at least the number of moves in the answer we've constructed. (This also proves the ordering assumption made in Approach #1, as we can make edge contractions of a cycle in any order without changing the answer.)

Algorithm

We'll construct the graph: adj[node] will be the index of the two nodes that this node is adjacent to. After, we'll find all connected components (which are also cycles.) If at some couch (node) a person is unvisited, we will visit it and repeatedly visit some neighbor until we complete the cycle.

Complexity Analysis

Time Complexity: O(N)O(N), where NN is the number of couples.

Space Complexity: O(N)O(N), the size of adj and associated data structures.
    */
   public int minSwapsCouplesCycleFinding(int[] row) {
      int N = row.length / 2;
      //couples[x] = {i, j} means that
      //couple #x is at couches i and j (1 indexed)
      int[][] couples = new int[N][2];

      for (int i = 0; i < row.length; ++i)
          add(couples[row[i]/2], i/2 + 1);

      //adj[x] = {i, j} means that
      //x-th couch connected to couches i, j (all 1 indexed) by couples
      int[][] adj = new int[N+1][2];
      for (int[] couple: couples) {
          add(adj[couple[0]], couple[1]);
          add(adj[couple[1]], couple[0]);
      }

      // The answer will be N minus the number of cycles in adj.
      int ans = N;
      // For each couch (1 indexed)
      for (int r = 1; r <= N; ++r) {
          // If this couch has no people needing to be paired, continue
          if (adj[r][0] == 0 && adj[r][1] == 0)
              continue;

          // Otherwise, there is a cycle starting at couch r.
          // We will use two pointers x, y with y faster than x by one turn.
          ans--;
          int x = r, y = pop(adj[r]);
          // When y reaches the start 'r', we've reached the end of the cycle.
          while (y != r) {
              // We are at some couch with edges going to 'x' and 'new'.
              // We remove the previous edge, since we came from x.
              rem(adj[y], x);

              // We update x, y appropriately: y becomes new and x becomes y.
              x = y;
              y = pop(adj[y]);
          }
      }
      return ans;
  }

  // Replace the next zero element with x.
  public void add(int[] pair, int x) {
      pair[pair[0] == 0 ? 0 : 1] = x;
  }

  // Remove x from pair, replacing it with zero.
  public void rem(int[] pair, int x) {
      pair[pair[0] == x ? 0 : 1] = 0;
  }

  // Remove the next non-zero element from pair, replacing it with zero.
  public int pop(int[] pair) {
      int x = pair[0];
      if (x != 0) {
          pair[0] = 0;
      } else {
          x = pair[1];
          pair[1] = 0;
      }
      return x;
  }
  
  /**
   * Approach #3: Greedy [Accepted]
Intuition

From guessing, or by the proof in Approach #2, our strategy is to resolve each couch in order.

To resolve a couch, fix the first person and have their partner swap into the second seat if they are not already there.

Algorithm

If a person is number x, their partner is x ^ 1, where ^ is the bitwise XOR operator.

For each first person x = row[i] on a couch who is unpartnered, let's find their partner at row[j] and have them swap seats with row[i+1].

Complexity Analysis

Time Complexity: O(N^2)O(N
​2
​​ ), where NN is the number of couples.

Space Complexity: O(1)O(1) additional complexity: the swaps are in place.
   */
  public int minSwapsCouplesGreedy(int[] row) {
     int ans = 0;
     for (int i = 0; i < row.length; i += 2) {
         int x = row[i];
         if (row[i+1] == (x ^ 1)) continue;
         ans++;
         for (int j = i+1; j < row.length; ++j) {
             if (row[j] == (x^1)) {
                 row[j] = row[i+1];
                 row[i+1] = x^1;
                 break;
             }
         }
     }
     return ans;
 }

}
