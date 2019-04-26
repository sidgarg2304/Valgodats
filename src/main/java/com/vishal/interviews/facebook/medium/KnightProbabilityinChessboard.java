package com.vishal.interviews.facebook.medium;

/**
 * 688. Knight Probability in Chessboard
 * 
 * On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves. The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).

A chess knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.

Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.

The knight continues moving until it has made exactly K moves or has moved off the chessboard. Return the probability that the knight remains on the board after it has stopped moving.

Example:
Input: 3, 2, 0, 0
Output: 0.0625
Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
From each of those positions, there are also two moves that will keep the knight on the board.
The total probability the knight stays on the board is 0.0625.
Note:
N will be between 1 and 25.
K will be between 0 and 100.
The knight always initially starts on the board.
 * @author vkotha
 *
 */
public class KnightProbabilityinChessboard {

	public static void main(String[] args) {

	}
	
	/**
	 * Approach #1: Dynamic Programming [Accepted]
Intuition and Algorithm

Let f[r][c][steps] be the probability of being on square (r, c) after steps steps. Based on how a knight moves, we have the following recursion:

f[r][c][steps] = \sum_{dr, dc} f[r+dr][c+dc][steps-1] / 8.0f[r][c][steps]=∑ 
dr,dc
​	
 f[r+dr][c+dc][steps−1]/8.0

where the sum is taken over the eight (dr, dc)(dr,dc) pairs (2, 1),(2,1), (2, -1),(2,−1), (-2, 1),(−2,1), (-2, -1),(−2,−1), (1, 2),(1,2), (1, -2),(1,−2), (-1, 2),(−1,2), (-1, -2)(−1,−2).

Instead of using a three-dimensional array f, we will use two two-dimensional ones dp and dp2, storing the result of the two most recent layers we are working on. dp2 will represent f[][][steps], and dp will represent f[][][steps-1].


	 * @param N
	 * @param K
	 * @param sr
	 * @param sc
	 * @return
	 */
	public double knightProbabilityDP(int N, int K, int r, int c) {
      double[][] dp = new double[N][N];
		dp[r][c] = 1;

		int[][] dirs = new int[][] { { -2, 1 }, { 2, 1 }, { -2, -1 }, { 2, -1 }, { 1, -2 }, { 1, 2 }, { -1, -2 },
				{ -1, 2 } };

		while (K > 0) {
			double[][] curDp = new double[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int d = 0; d < dirs.length; d++) {
						int x = i + dirs[d][0];
						int y = j + dirs[d][1];

						//since the prob need to be found only while the Knight is on chess board
						if (x >= 0 && x < N && y >= 0 && y < N) {
							curDp[x][y] += dp[i][j] / 8.0; // every move the prob keeps going down. 1/8
						}
					}
				}
			}

			// since we move to the next steps, find the prob after this move
			dp = curDp;
			K--;
		}

		double res = 0.0f;
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				res += dp[i][j];
			}
		}

		return res;
  }
	/**
	 * Approach #2: Matrix Exponentiation [Accepted]
Intuition

The recurrence expressed in Approach #1 expressed states that transitioned to a linear combination of other states. Any time this happens, we can represent the entire transition as a matrix of those linear combinations. Then, the nn-th power of this matrix represents the transition of nn moves, and thus we can reduce the problem to a problem of matrix exponentiation.

Algorithm

First, there is a lot of symmetry on the board that we can exploit. Naively, there are N^2N 
2
  possible states the knight can be in (assuming it is on the board). Because of symmetry through the horizontal, vertical, and diagonal axes, we can assume that the knight is in the top-left quadrant of the board, and that the column number is equal to or larger than the row number. For any square, the square that is found by reflecting about these axes to satisfy these conditions will be the canonical index of that square.

This will reduce the number of states from N^2N 
2
  to approximately \frac{N^2}{8} 
8
N 
2
 
​	
 , which makes the following (cubic) matrix exponentiation on this O(\frac{N^2}{8}) \times O(\frac{N^2}{8})O( 
8
N 
2
 
​	
 )×O( 
8
N 
2
 
​	
 ) matrix approximately 8^38 
3
  times faster.

Now, if we know that every state becomes some linear combination of states after one move, then let's write a transition matrix \mathcal{T}T of them, where the ii-th row of \mathcal{T}T represents the linear combination of states that the ii-th state goes to. Then, \mathcal{T}^nT 
n
  represents a transition of nn moves, for which we want the sum of the ii-th row, where ii is the index of the starting square.
	 * @param N
	 * @param K
	 * @param sr
	 * @param sc
	 * @return
	 */
	public double knightProbability(int N, int K, int sr, int sc) {
      int[] dr = new int[]{-1, -1, 1, 1, -2, -2, 2, 2};
      int[] dc = new int[]{2, -2, 2, -2, 1, -1, 1, -1};

      int[] index = new int[N * N];
      int t = 0;
      for (int r = 0; r < N; r++) {
          for (int c = 0; c < N; c++) {
              if (r * N + c == canonical(r, c, N)) {
                  index[r * N + c] = t;
                  t++;
              } else {
                  index[r * N + c] = index[canonical(r, c, N)];
              }
          }
      }

      double[][] T = new double[t][t];
      int curRow = 0;
      for (int r = 0; r < N; r++) {
          for (int c = 0; c < N; c++) {
              if (r * N + c == canonical(r, c, N)) {
                  for (int k = 0; k < 8; k++) {
                      int cr = r + dr[k], cc = c + dc[k];
                      if (0 <= cr && cr < N && 0 <= cc && cc < N) {
                          T[curRow][index[canonical(cr, cc, N)]] += 0.125;
                      }
                  }
                  curRow++;
              }
          }
      }

      double[] row = matrixExpo(T, K)[index[sr*N + sc]];
      double ans = 0.0;
      for (double x: row) ans += x;
      return ans;
  }

  public int canonical(int r, int c, int N) {
      if (2*r > N) r = N-1-r;
      if (2*c > N) c = N-1-c;
      if (r > c) {
          int t = r;
          r = c;
          c = t;
      }
      return r * N + c;
  }
  public double[][] matrixMult(double[][] A, double[][] B) {
      double[][] ans = new double[A.length][A.length];
      for (int i = 0; i < A.length; i++) {
          for (int j = 0; j < B[0].length; j++) {
              for (int k = 0; k < B.length; k++) {
                  ans[i][j] += A[i][k] * B[k][j];
              }
          }
      }
      return ans;
  }
  public double[][] matrixExpo(double[][] A, int pow) {
      double[][] ans = new double[A.length][A.length];
      for (int i = 0; i < A.length; i++) ans[i][i] = 1;
      if (pow == 0) return ans;
      if (pow == 1) return A;
      if (pow % 2 == 1) return matrixMult(matrixExpo(A, pow-1), A);
      double[][] B = matrixExpo(A, pow / 2);
      return matrixMult(B, B);
  }
}
