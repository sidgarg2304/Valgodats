package com.vishal.interviews.google.medium;

import java.util.Arrays;

/**
 * 562. Longest Line of Consecutive One in Matrix
 * 
 * Given a 01 matrix M, find the longest line of consecutive one in the matrix. The line could be horizontal, vertical, diagonal or anti-diagonal.

Example:
Input:
[[0,1,1,0],
 [0,1,1,0],
 [0,0,0,1]]
Output: 3
Hint: The number of elements in the given matrix will not exceed 10,000.
 *
 */
public class LongestLineofConsecutiveOneinMatrix {

	public static void main(String[] args) {

		int[][] m = new int[3][4];

		m[0] = new int[] { 0, 1, 1, 0 };
		m[1] = new int[] { 0, 1, 1, 0 };
		m[2] = new int[] { 0, 0, 0, 1 };

		System.out.println(longestLineSimple(m));
	}

	public static int longestLineSimple(int[][] M) {

		int res = 0;

		if (M == null || M.length == 0) {
			return 0;
		}
		
      for(int i =0;i<M.length;i++){
          for(int j = 0;j<M[0].length;j++){
              if(M[i][j] == 1){
                  res = Math.max(res,getMaxOneLine(M, i, j));
              }
          }
      }
		return res;
	}
	
	static int getMaxOneLine(int[][] m, int i, int j) {
		int res = 1;
		int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { 1, 1 }, { 1, -1 } };
		for (int d = 0; d < dirs.length; d++) {
			int x = i + dirs[d][0];
			int y = j + dirs[d][1];
			int ct = 1;
			while (x >= 0 && y >= 0 && x < m.length && y < m[0].length && m[x][y] == 1) {
				ct++;
				x += dirs[d][0];
				y += dirs[d][1];
			}
			res = Math.max(res, ct);
		}
		return res;

	}

	
	public static int longestLineDP(int[][] M) {

		if (M == null || M.length == 0) {
			return 0;
		}

		int res = 0;

		int[][][] dp = new int[M.length][M[0].length][4];

		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[0].length; j++) {
				if (M[i][j] == 0) {
					continue;
				}

				for (int k = 0; k < 4; k++) {
					dp[i][j][k] = 1;
				}

				if (i >= 1) {
					dp[i][j][0] += dp[i - 1][j][0];
				}
				if (i >= 1 && j >= 1) {
					dp[i][j][1] += dp[i - 1][j - 1][1];
				}
				if (j >= 1) {
					dp[i][j][2] += dp[i][j - 1][2];
				}
				if (i >= 1 && j < M[0].length - 1) {
					dp[i][j][3] += dp[i - 1][j + 1][3];
				}

				res = Math.max(dp[i][j][0], dp[i][j][1]);
				res = Math.max(dp[i][j][2], res);
				res = Math.max(dp[i][j][3], res);
			}
		}

		return res;
	}
	
  
}
