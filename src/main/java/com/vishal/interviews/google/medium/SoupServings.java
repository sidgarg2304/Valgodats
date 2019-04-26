package com.vishal.interviews.google.medium;

/**
 * 808. Soup Servings
 * 
 * There are two types of soup: type A and type B. Initially we have N ml of each type of soup. There are four kinds of operations:

Serve 100 ml of soup A and 0 ml of soup B
Serve 75 ml of soup A and 25 ml of soup B
Serve 50 ml of soup A and 50 ml of soup B
Serve 25 ml of soup A and 75 ml of soup B
When we serve some soup, we give it to someone and we no longer have it.  Each turn, we will choose from the four operations with equal probability 0.25. If the remaining volume of soup is not enough to complete the operation, we will serve as much as we can.  We stop once we no longer have some quantity of both types of soup.

Note that we do not have the operation where all 100 ml's of soup B are used first.  

Return the probability that soup A will be empty first, plus half the probability that A and B become empty at the same time.

 

Example:
Input: N = 50
Output: 0.625
Explanation: 
If we choose the first two operations, A will become empty first. For the third operation, A and B will become empty at the same time. For the fourth operation, B will become empty first. So the total probability of A becoming empty first plus half the probability that A and B become empty at the same time, is 0.25 * (1 + 1 + 0.5 + 0) = 0.625.

Notes:

0 <= N <= 10^9. 
Answers within 10^-6 of the true value will be accepted as correct.
 *
 */
public class SoupServings {

	public static void main(String[] args) {

	}

	/**
	 * Approach #1: Dynamic Programming [Accepted]
Intuition

First, we can simplify all the numbers by dividing by 25. More specifically, each unit is 25ml, and partial quantities of 25ml are rounded up to a full quantity.

When N is small, this is a relatively straightforward dynamic programming problem: we have quantities of soup represented by the state (x, y), and we can either go to (x-4, y-0), (x-3, y-1), (x-2, y-2), or (x-1, y-3) each with equal probability.

When N is very large, this approach fails, so we need a different idea.

Instead of serving in batches of (4, 0), (3, 1), (2, 2), (1, 3), pretend we serve (1, 0) on the side first, and then serve from the fair distribution (3, 0), (2, 1), (1, 2), (0, 3). If the pots of soup initially start at (N, N), then after roughly less than N/2 servings, one pot will still have soup. Because of the (1, 0) servings on the side, this means that roughly speaking, pot A is used first if we serve N/2 fairly from the first pot before N from the second pot.

When N is very large, this almost always happens (better than 99.9999%, so we can output 1), and we can check this either experimentally or mathematically.

Algorithm

We convert all units by dividing by 25 and rounding up. If N >= 500 (in new units), then by the above argument the answer is 1.

Otherwise, we will perform a dynamic programming algorithm to find the answer. Our Java implementation showcases a "bottom-up" approach, that fills memo diagonally from top left to bottom right, where s = i + j is the sum of the indices. Our Python implemtation showcases a "top-down" approach that uses memoization.


Complexity Analysis

Time Complexity: O(1)O(1). (There exists a constant C such that the algorithm never performs more than C steps.)

Space Complexity: O(1)O(1). (There exists a constant C such that the algorithm never uses more than C space.)
	 */
	public double soupServings(int N) {
      N = N/25 + (N%25 > 0 ? 1 : 0);
      if (N >= 500) return 1.0;

      double[][] memo = new double[N+1][N+1];
      for (int s = 0; s <= 2*N; ++s) {
          for (int i = 0; i <= N; ++i) {
              int j = s-i;
              if (j < 0 || j > N) continue;
              double ans = 0.0;
              if (i == 0) ans = 1.0;
              if (i == 0 && j == 0) ans = 0.5;
              if (i > 0 && j > 0) {
                  ans = 0.25 * (memo[M(i-4)][j] + memo[M(i-3)][M(j-1)] +
                                memo[M(i-2)][M(j-2)] + memo[M(i-1)][M(j-3)]);
              }
              memo[i][j] = ans;

          }
      }
      return memo[N][N];
  }

  public int M(int x) { return Math.max(0, x); }
}
