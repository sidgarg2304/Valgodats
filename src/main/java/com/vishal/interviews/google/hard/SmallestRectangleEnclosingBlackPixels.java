package com.vishal.interviews.google.hard;

/**
 * 302. Smallest Rectangle Enclosing Black Pixels
 * 
 * An image is represented by a binary matrix with 0 as a white pixel and 1 as a
 * black pixel. The black pixels are connected, i.e., there is only one black
 * region. Pixels are connected horizontally and vertically. Given the location
 * (x, y) of one of the black pixels, return the area of the smallest
 * (axis-aligned) rectangle that encloses all black pixels.
 * 
 * For example, given the following image:
 * 
 * [ "0010", "0110", "0100" ] and x = 0, y = 2, Return 6.
 */
public class SmallestRectangleEnclosingBlackPixels {

	public static void main(String[] args) {

	}

}

/**
 * Suppose we have a 2D array

"000000111000000"
"000000101000000"
"000000101100000"
"000001100100000"
Imagine we project the 2D array to the bottom axis with the rule "if a column has any black pixel it's projection is black otherwise white". The projected 1D array is

"000001111100000"
Theorem

If there are only one black pixel region, then in a projected 1D array all the black pixels are connected.

Proof by contradiction

Assume to the contrary that there are disconnected black pixels at i
and j where i < j in the 1D projection array. Thus there exists one
column k, k in (i, j) and and the column k in the 2D array has no
black pixel. Therefore in the 2D array there exists at least 2 black
pixel regions separated by column k which contradicting the condition
of "only one black pixel region".

Therefore we conclude that all the black pixels in the 1D projection
array is connected.
This means we can do a binary search in each half to find the boundaries, if we know one black pixel's position. And we do know that.

To find the left boundary, do the binary search in the [0, y) range and find the first column vector who has any black pixel.

To determine if a column vector has a black pixel is O(m) so the search in total is O(m log n)

We can do the same for the other boundaries. The area is then calculated by the boundaries.
Thus the algorithm runs in O(m log n + n log m)
 *
 */
class SmallestRectangleEnclosingBlackPixelsBinarySearch {
	private char[][] image;

	public int minArea(char[][] iImage, int x, int y) {
		image = iImage;
		int m = image.length, n = image[0].length;
		int left = searchColumns(0, y, 0, m, true);
		int right = searchColumns(y + 1, n, 0, m, false);
		int top = searchRows(0, x, left, right, true);
		int bottom = searchRows(x + 1, m, left, right, false);
		return (right - left) * (bottom - top);
	}

	private int searchColumns(int i, int j, int top, int bottom, boolean opt) {
		while (i != j) {
			int k = top, mid = (i + j) / 2;
			while (k < bottom && image[k][mid] == '0')
				++k;
			if (k < bottom == opt)
				j = mid;
			else
				i = mid + 1;
		}
		return i;
	}

	private int searchRows(int i, int j, int left, int right, boolean opt) {
		while (i != j) {
			int k = left, mid = (i + j) / 2;
			while (k < right && image[mid][k] == '0')
				++k;
			if (k < right == opt)
				j = mid;
			else
				i = mid + 1;
		}
		return i;
	}
}

/**
 * 1ms Concise Java Binary Search (DFS is 4ms)
If we don't know programming, how do we find the 4 boundaries given a black pixel?

Do we need to search every black cell? Absolutely not.

Intuitively, we would expand from the given 1 * 1 black cell, "aggressively" expand to the 4 boundaries, roughly half of the remaining space. If we don't "cut" any black pixel, we know we go too far and should go back half.

This is exactly the process of binary search.

One simple way without any worry about boundary, is as follows:

Use a vertical line, to jump to the leftmost black pixel , in the range of [0, y]
Use a vertical line, to jump to the rightmost black pixel, in the range of [y, n - 1]
Use a horizontal line, to jump to the topmost black pixel, in the range of [0, x]
Use a horizontal line, to jump to the bottommost black pixel, in the range of [x, m - 1]
 * @author vkotha
 *
 */
class SmallestRectangleEnclosingBlackPixelsConciseBinarySearch {
	public int minArea(char[][] image, int x, int y) {
		int left = leftmost(image, 0, y, true);
		int right = rightmost(image, y, image[0].length - 1, true);
		int top = leftmost(image, 0, x, false);
		int bottom = rightmost(image, x, image.length - 1, false);
		return (right - left + 1) * (bottom - top + 1);
	}

	int leftmost(char[][] image, int min, int max, boolean horizontal) {
		int l = min, r = max;
		while (l < r) {
			int mid = l + (r - l) / 2;
			if (!hasBlack(image, mid, horizontal)) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}
		return l;
	}

	int rightmost(char[][] image, int min, int max, boolean horizontal) {
		int l = min, r = max;
		while (l < r) {
			int mid = l + (r - l + 1) / 2;
			if (!hasBlack(image, mid, horizontal)) {
				r = mid - 1;
			} else {
				l = mid;
			}
		}
		return r;
	}

	boolean hasBlack(char[][] image, int mid, boolean horizontal) {
		if (horizontal) {
			for (int i = 0; i < image.length; i++) {
				if (image[i][mid] == '1') {
					return true;
				}
			}
		} else {
			for (int j = 0; j < image[0].length; j++) {
				if (image[mid][j] == '1') {
					return true;
				}
			}
		}
		return false;
	}
}

/**
 * Version 2: Another harder but more compact way is as follows:
 *
 */
class SmallestRectangleEnclosingBlackPixelsCompactBinarySearch {
	public int minArea(char[][] image, int x, int y) {
		int m = image.length, n = image[0].length;
		int colMin = binarySearch(image, true, 0, y, 0, m, true);
		int colMax = binarySearch(image, true, y + 1, n, 0, m, false);
		int rowMin = binarySearch(image, false, 0, x, colMin, colMax, true);
		int rowMax = binarySearch(image, false, x + 1, m, colMin, colMax, false);
		return (rowMax - rowMin) * (colMax - colMin);
	}

	public int binarySearch(char[][] image, boolean horizontal, int lower, int upper, int min, int max,
			boolean goLower) {
		while (lower < upper) {
			int mid = lower + (upper - lower) / 2;
			boolean inside = false;
			for (int i = min; i < max; i++) {
				if ((horizontal ? image[i][mid] : image[mid][i]) == '1') {
					inside = true;
					break;
				}
			}
			if (inside == goLower) {
				upper = mid;
			} else {
				lower = mid + 1;
			}
		}
		return lower;
	}
}

/**
 * DFS or BFS is the intuitive solution for this problem while the problem is with a tag "binary search". So can anyone provide a binary search answer. DFS complexity is O(m * n) and if binary search it would be O(n * lgm + m * lgn)
 */
class SmallestRectangleEnclosingBlackPixelsDFS {
	private int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = 0, maxY = 0;

	public int minArea(char[][] image, int x, int y) {
		if (image == null || image.length == 0 || image[0].length == 0)
			return 0;
		dfs(image, x, y);
		return (maxX - minX + 1) * (maxY - minY + 1);
	}

	private void dfs(char[][] image, int x, int y) {
		int m = image.length, n = image[0].length;
		if (x < 0 || y < 0 || x >= m || y >= n || image[x][y] == '0')
			return;
		image[x][y] = '0';
		minX = Math.min(minX, x);
		maxX = Math.max(maxX, x);
		minY = Math.min(minY, y);
		maxY = Math.max(maxY, y);
		dfs(image, x + 1, y);
		dfs(image, x - 1, y);
		dfs(image, x, y - 1);
		dfs(image, x, y + 1);
	}
}

/**
 * Very easy DFS JAVA solution with comments
 *
 */
class SmallestRectangleEnclosingBlackPixelsEasyDFS {
	public int minArea(char[][] image, int x, int y) {
		int column = image.length; // vertical
		if (column == 0)
			return 0;
		int row = image[0].length; // horizontal

		int[] res = new int[4];
		res[0] = column - 1; // initial upper bound value
		res[1] = 0; // initial bottom bound value
		res[2] = row - 1; // initial left bound value
		res[3] = 0; // initial right bound value
		dfs(image, x, y, res);
		return (res[1] - res[0] + 1) * (res[3] - res[2] + 1); // (bot - upper + 1)
																				// * (right - left +
																				// 1)
	}

	public void dfs(char[][] image, int x, int y, int[] res) {
		int column = image.length;
		int row = image[0].length;
		if (x < 0 || x > column - 1 || y < 0 || y > row - 1)
			return;
		if (image[x][y] == '0')
			return;
		image[x][y] = '0'; // once visit, set to 0

		if (x < res[0])
			res[0] = x; // update upper bound
		if (x > res[1])
			res[1] = x; // update bottom bound
		if (y < res[2])
			res[2] = y; // update left bound
		if (y > res[3])
			res[3] = y; // update right bound

		dfs(image, x + 1, y, res);
		dfs(image, x, y + 1, res);
		dfs(image, x - 1, y, res);
		dfs(image, x, y - 1, res);
	}
}
