package com.vishal.interviews.google.medium;

/**
 * 790. Domino and Tromino Tiling
 * 
 * We have two types of tiles: a 2x1 domino shape, and an "L" tromino shape. These shapes may be rotated.

XX  <- domino

XX  <- "L" tromino
X
Given N, how many ways are there to tile a 2 x N board? Return your answer modulo 10^9 + 7.

(In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.)

Example:
Input: 3
Output: 5
Explanation: 
The five different ways are listed below, different letters indicates different tiles:
XYZ XXZ XYY XXY XYY
XYZ YYZ XZZ XYY XXY
Note:

N  will be in range [1, 1000].
 *
 */
public class DominoandTrominoTiling {

	public static void main(String[] args) {

	}
	
	/**
	 * Approach #1: Dynamic Programming [Accepted]
Intuition

Let dp[state] be the previous number of ways to fill i columns where the i-th row of the last column is filled if the i-th bit of state is 1.

In particular, dp[0] will be the number of ways to fill i columns where the last column has nothing filled; dp[1] will be the number of ways with the square in the last row filled; dp[2] will be the number of ways with the square in the first row filled; and dp[3] will be the number of ways with the squares in both rows filled.

From there, we only have to accurately record the transitions.

Algorithm

If in the future we have:

0 rows filled - it could have come from either:

having 0 rows filled and a vertical domino, or
both rows filled and nothing.
last row filled - it could have come from either:

having 0 rows filled and an L shaped tromino, or
having top row filled and a horizontal domino
first row filled - case is symmetric to the 'last row filled' case

both rows filled - could have come from either:

having 0 rows filled and two horizontal dominos, or
having 1 row filled and an L shaped tromino (two cases.)
After writing the recurrence correctly, the solution follows.

Complexity Analysis

Time Complexity: O(N)O(N). We update the state N times.

Space Complexity: O(1)O(1).
	 *
	 */
	public int numTilings(int N) {
      int MOD = 1_000_000_007;
      long[] dp = new long[]{1, 0, 0, 0};
      for (int i = 0; i < N; ++i) {
          long[] ndp = new long[4];
          ndp[0b00] = (dp[0b00] + dp[0b11]) % MOD;
          ndp[0b01] = (dp[0b00] + dp[0b10]) % MOD;
          ndp[0b10] = (dp[0b00] + dp[0b01]) % MOD;
          ndp[0b11] = (dp[0b00] + dp[0b01] + dp[0b10]) % MOD;
          dp = ndp;
      }
      return (int) dp[0];
  }
	
	/**
	 * Approach #2: Matrix Exponentiation
Intuition

The recurrence expressed in Approach #1 expressed states that transitioned to a linear combination of other states. Any time this happens, we can represent the entire transition as a matrix of those linear combinations. Then, the nn-th power of this matrix represents the transition of nn moves, and thus we can reduce the problem to a problem of matrix exponentiation.

Algorithm

Let TT be the linear transformation taking dp -> ndp under the notation in Approach #1. Then, the matrix T^nT
​n
​​ represents the transformation nn times in a row.

To compute T^nT
​n
​​  efficiently, we use the trick T^{2k} = T^k * T^kT
​2k
​​ =T
​k
​​ ∗T
​k
​​  and T^{2k + 1} = T * T^{2k}T
​2k+1
​​ =T∗T
​2k
​​  to reduce the exponentiation to O(\log n)O(logn) multiplications. To multiply two matrices, we use the textbook definition.

Complexity Analysis

Time Complexity: O(\log N)O(logN). We perform O(\log N)O(logN) multiplications.

Space Complexity: O(\log N)O(logN), the size of the recursive call stack.


	 */
	int MOD = 1_000_000_007;

   public int numTilingsMatrixExponention(int N) {
       int[][] T = new int[][]{{1,0,0,1},{1,0,1,0},{1,1,0,0},{1,1,1,0}};
       return matrixExpo(T, N)[0][0];
   }

   public int[][] matrixMult(int[][] A, int[][] B) {
       int[][] ans = new int[A.length][A.length];
       for (int i = 0; i < A.length; i++)
           for (int j = 0; j < B[0].length; j++) {
               long entry = 0;
               for (int k = 0; k < B.length; k++)
                   entry += (long) A[i][k] * (long) B[k][j] % MOD;
               ans[i][j] = (int) (entry % MOD);
           }

       return ans;
   }

   public int[][] matrixExpo(int[][] A, int pow) {
       int[][] ans = new int[A.length][A.length];
       for (int i = 0; i < A.length; i++) ans[i][i] = 1;
       if (pow == 0) return ans;
       if (pow == 1) return A;
       if (pow % 2 == 1) return matrixMult(matrixExpo(A, pow-1), A);
       int[][] B = matrixExpo(A, pow / 2);
       return matrixMult(B, B);
   }

}
