package com.vishal.interviews.google.hard;

import java.util.*;
/**
 * 782. Transform to Chessboard
 * 
 * An N x N board contains only 0s and 1s. In each move, you can swap any 2 rows with each other, or any 2 columns with each other.

What is the minimum number of moves to transform the board into a "chessboard" - a board where no 0s and no 1s are 4-directionally adjacent? If the task is impossible, return -1.

Examples:
Input: board = [[0,1,1,0],[0,1,1,0],[1,0,0,1],[1,0,0,1]]
Output: 2
Explanation:
One potential sequence of moves is shown below, from left to right:

0110     1010     1010
0110 --> 1010 --> 0101
1001     0101     1010
1001     0101     0101

The first move swaps the first and second column.
The second move swaps the second and third row.


Input: board = [[0, 1], [1, 0]]
Output: 0
Explanation:
Also note that the board with 0 in the top left corner,
01
10

is also a valid chessboard.

Input: board = [[1, 0], [1, 0]]
Output: -1
Explanation:
No matter what sequence of moves you make, you cannot end with a valid chessboard.
Note:

board will have the same number of rows and columns, a number in the range [2, 30].
board[i][j] will be only 0s or 1s.

 *
 */
public class TransformtoChessboard {

	public static void main(String[] args) {

	}

	/**
	 * Approach #1: Dimension Independence [Accepted]
Intuition

After a swap of columns, two rows that were the same stay the same, and two rows that were different stay different. Since the final state of a chessboard has only two different kinds of rows, there must have originally been only two different kinds of rows.

Furthermore, these rows must have had half zeros and half ones, (except when the length is odd, where there could be an extra zero or one), and one row must be the opposite (0 changed to 1 and vice versa) of the other row. This is because moves do not change these properties either.

Similarly, the above is true for columns.

Now, because a row move followed by a column move is the same as a column move followed by a row move, we can assume all the row moves happen first, then all the column moves. (Note: it is not true that a row move followed by another row move is the same as those moves backwards.)

Since there are only two kinds of rows, we want the minimum number of moves to make them alternating; and similarly for columns. This reduces to a one dimensional problem, where we have an array like [0, 1, 1, 1, 0, 0] and we want to know the least cost to make it [0, 1, 0, 1, 0, 1] or [1, 0, 1, 0, 1, 0].

Algorithm

For each set of rows (and columns respectively), make sure there are only 2 kinds of lines in the right quantities that are opposites of each other.

Then, for each possible ideal transformation of that line, find the minimum number of swaps to convert that line to it's ideal and add it to the answer. For example, [0, 1, 1, 1, 0, 0] has two ideals [0, 1, 0, 1, 0, 1] or [1, 0, 1, 0, 1, 0]; but [0, 1, 1, 1, 0] only has one ideal [1, 0, 1, 0, 1].

In Java, we use integers to represent the rows as binary numbers. We check the number of differences with [1, 0, 1, 0, 1, 0, ...] by xoring with 0b010101010101.....01 = 0x55555555. To make sure we don't add extra large powers of 2, we also bitwise-AND by 0b00...0011...11 where there are N ones in this mask.

Complexity Analysis

Time Complexity: O(N^2)O(N
​2
​​ ), where NN is the number of rows (and columns) in board.

Space Complexity: O(N)O(N), the space used by count.
	 */
	public int movesToChessboard(int[][] board) {
      int N = board.length;

      // count[code] = v, where code is an integer
      // that represents the row in binary, and v
      // is the number of occurrences of that row
      Map<Integer, Integer> count = new HashMap();
      for (int[] row: board) {
          int code = 0;
          for (int x: row)
              code = 2 * code + x;
          count.put(code, count.getOrDefault(code, 0) + 1);
      }

      int k1 = analyzeCount(count, N);
      if (k1 == -1) return -1;

      // count[code], as before except with columns
      count = new HashMap();
      for (int c = 0; c < N; ++c) {
          int code = 0;
          for (int r = 0; r < N; ++r)
              code = 2 * code + board[r][c];
          count.put(code, count.getOrDefault(code, 0) + 1);
      }

      int k2 = analyzeCount(count, N);
      return k2 >= 0 ? k1 + k2 : -1;
  }

  public int analyzeCount(Map<Integer, Integer> count, int N) {
      // Return -1 if count is invalid
      // Otherwise, return number of swaps required
      if (count.size() != 2) return -1;

      List<Integer> keys = new ArrayList(count.keySet());
      int k1 = keys.get(0), k2 = keys.get(1);

      // If lines aren't in the right quantity
      if (!(count.get(k1) == N/2 && count.get(k2) == (N+1)/2) &&
              !(count.get(k2) == N/2 && count.get(k1) == (N+1)/2))
          return -1;
      // If lines aren't opposite
      if ((k1 ^ k2) != (1<<N) - 1)
          return -1;

      int Nones = (1 << N) - 1;
      int ones = Integer.bitCount(k1 & Nones);
      int cand = Integer.MAX_VALUE;
      if (N%2 == 0 || ones * 2 < N) // zero start
          cand = Math.min(cand, Integer.bitCount(k1 ^ 0xAAAAAAAA & Nones) / 2);

      if (N%2 == 0 || ones * 2 > N) // ones start
          cand = Math.min(cand, Integer.bitCount(k1 ^ 0x55555555 & Nones) / 2);

      return cand;
  }
}
