package com.vishal.interviews.salesforce;

/**
 * 2.Write a program to print the output solution for the rat so that he can reach his hole assuming that there is a unique path possible.(1 represents that path is possible and 0 means that path is not possible).
input :

(1,0,0,0)
(1,1,0,1)
(0,1,1,1)
(0,0,0,1)

output:
(1,0,0,0)
(1,1,0,0)
(0,1,1,1)
(0,0,0,1)
 *
 */
public class PrintUniquePathForRatToReachHole {

	public static void main(String[] args) {

		int[][] paths = new int[4][4];
		paths[0] = new int[] { 1, 0, 0, 0 };
		paths[1] = new int[] { 1, 1, 0, 1 };
		paths[2] = new int[] { 0, 1, 1, 1 };
		paths[3] = new int[] { 0, 0, 0, 1 };

		printValidPath(paths);
	}

	static void printValidPath(int[][] paths) {

		int[][] dp = new int[paths.length + 1][paths[0].length + 1];

		dp[0][1] = 1;
		for (int i = 1; i <= paths.length; i++) {
			for (int j = 1; j <= paths[0].length; j++) {
				if (paths[i - 1][j - 1] == 1) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}

		System.out.println("num of paths is " + dp[paths.length][paths[0].length]);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < dp.length; i++) {
			sb.append("(");
			for (int j = 1; j < dp[0].length; j++) {
				sb.append(dp[i][j] + ",");
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append(")");
			sb.append("\n");
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());

	}

}
