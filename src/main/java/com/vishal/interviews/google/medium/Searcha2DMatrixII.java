package com.vishal.interviews.google.medium;

/**
 * 
 * 240. Search a 2D Matrix II
 * 
 * https://leetcode.com/problems/search-a-2d-matrix-ii/?tab=Solutions
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false
 *
 */
public class Searcha2DMatrixII {

	public static void main(String[] args) {

	}

	/**
	 * My concise O(m+n) Java solution
	 * 
	 * We start search the matrix from top right corner, initialize the current
	 * position to top right corner, if the target is greater than the value in
	 * current position, then the target can not be in entire row of current
	 * position because the row is sorted, if the target is less than the value
	 * in current position, then the target can not in the entire column because
	 * the column is sorted too. We can rule out one row or one column each time,
	 * so the time complexity is O(m+n).
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
			return false;
		}
		int col = matrix[0].length - 1;
		int row = 0;
		while (col >= 0 && row <= matrix.length - 1) {
			if (target == matrix[row][col]) {
				return true;
			} else if (target < matrix[row][col]) {
				col--;
			} else if (target > matrix[row][col]) {
				row++;
			}
		}
		return false;
	}
	
	/**
	 * O(m+n)
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrixShort(int[][] matrix, int target) {
	    int m=matrix.length, n=matrix[0].length, i=0, j=n-1;
	    while (i<m && j>=0) {
	        if (matrix[i][j]==target) return true;
	        else if (matrix[i][j]<target) i++;
	        else j--;
	    }
	    return false;
	}

	/**
	 * *Java* an easy-to-understand divide and conquer method The coding seems to
	 * be much more complex than those smart methods such as this one, but the
	 * idea behind is actually quite straightforward. Unfortunately, it is not as
	 * fast as the smart ones.
	 * 
	 * First, we divide the matrix into four quarters as shown below:
	 * 
	 *   zone 1      zone 2
*  *  *  * | *  *  *  *
*  *  *  * | *  *  *  *
*  *  *  * | *  *  *  *
*  *  *  * | *  *  *  *
-----------------------
*  *  *  * | *  *  *  *
*  *  *  * | *  *  *  *
*  *  *  * | *  *  *  *
*  *  *  * | *  *  *  *
  zone 3      zone 4
  
	 * 
	 * We then compare the element in the center of the matrix with the target. There are three possibilities:

center < target. In this case, we discard zone 1 because all elements in zone 1 are less than target.

center > target. In this case, we discard zone 4.

center == target. return true.

For time complexity, if the matrix is a square matrix of size nxn, then for the worst case,

T(nxn) = 3T(n/2 x n/2)
which makes

T(nxn) = O(n^log3)

	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrixRecursive(int[][] matrix, int target) {
		int m = matrix.length;
		if (m < 1)
			return false;
		int n = matrix[0].length;

		return searchMatrixRecursive(matrix, new int[] { 0, 0 }, new int[] { m - 1, n - 1 }, target);
	}

	private boolean searchMatrixRecursive(int[][] matrix, int[] upperLeft, int[] lowerRight, int target) {
		if (upperLeft[0] > lowerRight[0] || upperLeft[1] > lowerRight[1] || lowerRight[0] >= matrix.length
				|| lowerRight[1] >= matrix[0].length)
			return false;
		if (lowerRight[0] - upperLeft[0] == 0 && lowerRight[1] - upperLeft[1] == 0)
			return matrix[upperLeft[0]][upperLeft[1]] == target;
		int rowMid = (upperLeft[0] + lowerRight[0]) >> 1;
		int colMid = (upperLeft[1] + lowerRight[1]) >> 1;
		int diff = matrix[rowMid][colMid] - target;
		if (diff > 0) {
			return searchMatrixRecursive(matrix, upperLeft, new int[] { rowMid, colMid }, target)
					|| searchMatrixRecursive(matrix, new int[] { upperLeft[0], colMid + 1 },
							new int[] { rowMid, lowerRight[1] }, target)
					|| searchMatrixRecursive(matrix, new int[] { rowMid + 1, upperLeft[1] },
							new int[] { lowerRight[0], colMid }, target);
		} else if (diff < 0) {
			return searchMatrixRecursive(matrix, new int[] { upperLeft[0], colMid + 1 },
					new int[] { rowMid, lowerRight[1] }, target)
					|| searchMatrixRecursive(matrix, new int[] { rowMid + 1, upperLeft[1] },
							new int[] { lowerRight[0], colMid }, target)
					|| searchMatrixRecursive(matrix, new int[] { rowMid + 1, colMid + 1 }, lowerRight, target);
		} else
			return true;
	}

}
