package com.vishal.interviews.google.hard;

/**
 * 308. Range Sum Query 2D - Mutable
 * 
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle
 * defined by its upper left corner (row1, col1) and lower right corner (row2,
 * col2).
 * 
 * Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
update(3, 2, 2)
sumRegion(2, 1, 4, 3) -> 10
Note:
The matrix is only modifiable by the update function.
You may assume the number of calls to update and sumRegion function is distributed evenly.
You may assume that row1 ≤ row2 and col1 ≤ col2.
 */
public class RangeSumQuery2DMutable {

	public static void main(String[] args) {

	}

}

/**
 * Explanation of Binary Indexed Tree :
 * 
https://www.topcoder.com/community/data-science/data-science-tutorials/binary-indexed-trees/
 *
 *Java 2D Binary Indexed Tree Solution clean and short 17ms

 */
class RangeSumQuery2DMutableIndexedTreeSol {

	int[][] tree;
	int[][] nums;
	int m;
	int n;

	public RangeSumQuery2DMutableIndexedTreeSol(int[][] matrix) {
       if (matrix.length == 0 || matrix[0].length == 0) return;
       m = matrix.length;
       n = matrix[0].length;
       tree = new int[m+1][n+1];
       nums = new int[m][n];
       for (int i = 0; i < m; i++) {
           for (int j = 0; j < n; j++) {
               update(i, j, matrix[i][j]);
           }
       }
   }

	public void update(int row, int col, int val) {
		if (m == 0 || n == 0)
			return;
		int delta = val - nums[row][col];
		nums[row][col] = val;
		for (int i = row + 1; i <= m; i += i & (-i)) {
			for (int j = col + 1; j <= n; j += j & (-j)) {
				tree[i][j] += delta;
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		if (m == 0 || n == 0)
			return 0;
		return sum(row2 + 1, col2 + 1) + sum(row1, col1) - sum(row1, col2 + 1) - sum(row2 + 1, col1);
	}

	public int sum(int row, int col) {
		int sum = 0;
		for (int i = row; i > 0; i -= i & (-i)) {
			for (int j = col; j > 0; j -= j & (-j)) {
				sum += tree[i][j];
			}
		}
		return sum;
	}
}
//time should be O(log(m) * log(n))

/**
 * 15ms easy to understand java solution
 * 
 * We use colSums[i][j] = the sum of ( matrix[0][j], matrix[1][j],
 * matrix[2][j],......,matrix[i - 1][j] ).
 * 
 */
class RangeSumQuery2DMutableIndexedTreeEasy {
	private int[][] colSums;
	private int[][] matrix;

	public RangeSumQuery2DMutableIndexedTreeEasy(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}

		this.matrix = matrix;

		int m = matrix.length;
		int n = matrix[0].length;
		colSums = new int[m + 1][n];
		for (int i = 1; i <= m; i++) {
			for (int j = 0; j < n; j++) {
				colSums[i][j] = colSums[i - 1][j] + matrix[i - 1][j];
			}
		}
	}

	// time complexity for the worst case scenario: O(m)
	public void update(int row, int col, int val) {
		for (int i = row + 1; i < colSums.length; i++) {
			colSums[i][col] = colSums[i][col] - matrix[row][col] + val;
		}

		matrix[row][col] = val;
	}

	// time complexity for the worst case scenario: O(n)
	public int sumRegion(int row1, int col1, int row2, int col2) {
		int ret = 0;

		for (int j = col1; j <= col2; j++) {
			ret += colSums[row2 + 1][j] - colSums[row1][j];
		}

		return ret;
	}
}

/**
 * 15ms Very Concise Java Code Using BIT
 * 
 * Salute to
 * https://leetcode.com/discuss/71169/java-2d-binary-indexed-tree-solution-clean
 * -and-short-17ms
 * 
 */
class RangeSumQuery2DMutableIndexedTreeConcise {
	// Using 2D Binary Indexed Tree, 2D BIT Def:
	// bit[i][j] saves the rangeSum of [i-(i&-i), i] x [j-(j&-j), j]
	// note bit index == matrix index + 1
	int n, m;
	int[][] bit, a;

	public RangeSumQuery2DMutableIndexedTreeConcise(int[][] matrix) {
		if (matrix.length < 1)
			return;
		n = matrix.length;
		m = matrix[0].length;
		bit = new int[n + 1][m + 1];
		a = new int[n][m];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				update(i, j, matrix[i][j]);
	}

	public void update(int row, int col, int val) {
		int diff = val - a[row][col];
		a[row][col] = val;
		for (int i = row + 1; i <= n; i += i & -i)
			for (int j = col + 1; j <= m; j += j & -j)
				bit[i][j] += diff;
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return sum(row2, col2) + sum(row1 - 1, col1 - 1) - sum(row1 - 1, col2) - sum(row2, col1 - 1);
	}

	public int sum(int row, int col) {
		int tot = 0;
		for (int i = row + 1; i > 0; i -= i & -i)
			for (int j = col + 1; j > 0; j -= j & -j)
				tot += bit[i][j];
		return tot;
	}
}