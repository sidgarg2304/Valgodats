package com.vishal.algorithms.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixComplexAlgorithms {

	public static void main(String[] args) {
		// testRotateMatrix90Degrees();

		int[][] edges = new int[3][2];
		edges[0] = new int[] { 0, 1 };
		edges[1] = new int[] { 1, 2 };
		edges[2] = new int[] { 3, 4 };

		System.out.println(countComponents(5, edges));

		int[][] m = new int[3][3];
		m[0] = new int[] { 1, 5, 9 };
		m[1] = new int[] { 10, 11, 13 };
		m[2] = new int[] { 12, 13, 15 };

		System.out.println(kthSmallest(m, 8));
	}

	public static int countComponents(int n, int[][] edges) {
		int count = n;

		int[] root = new int[n];
		// initialize each node is an island
		for (int i = 0; i < n; i++) {
			root[i] = i;
		}

		for (int i = 0; i < edges.length; i++) {
			int x = edges[i][0];
			int y = edges[i][1];

			int xRoot = getRoot(root, x);
			int yRoot = getRoot(root, y);

			System.out.println("xroot " + xRoot + " and yRoot " + yRoot + " for " + Arrays.toString(edges[i]));
			System.out.println("root is " + Arrays.toString(root));

			if (xRoot != yRoot) {
				count--;
				root[xRoot] = yRoot;
			}

		}

		return count;
	}

	public static int getRoot(int[] arr, int i) {
		while (arr[i] != i) {
			arr[i] = arr[arr[i]];
			i = arr[i];
		}
		return i;
	}

	public static void testRotateMatrix90Degrees() {
		int[][] a = new int[4][4];
		a[0] = new int[] { 1, 2, 3, 4 };
		a[1] = new int[] { 5, 6, 7, 8 };
		a[2] = new int[] { 9, 10, 11, 12 };
		a[3] = new int[] { 13, 14, 15, 16 };

		System.out.println("original matrix is below");
		MatrixBasicAlgorithms.printMatrix(a);
		rotateMatrix90Degrees(a);
		System.out.println("matrix after rotation is below");
		MatrixBasicAlgorithms.printMatrix(a);
	}

	static int minPathSumInTriangle(List<ArrayList<Integer>> triangle) {

		int l = triangle.size() - 1;
		int total[] = new int[triangle.get(l).size()];

		for (int i = 0; i < total.length; i++) {
			total[i] = triangle.get(l).get(i);
		}

		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j + 1]);
			}
		}

		return total[0];
	}

	public static void rotateMatrix90Degrees(int[][] a) {
		int n = a.length;
		for (int i = 0; i < a.length / 2; i++) {
			for (int j = 0; j < a.length / 2; j++) {
				int tmp = a[i][j]; // [0][1]
				a[i][j] = a[n - 1 - j][i]; // [2][0]
				a[n - 1 - j][i] = a[n - 1 - i][n - 1 - j];//
				a[n - 1 - i][n - 1 - j] = a[j][n - 1 - i];
				a[j][n - 1 - i] = tmp;
			}
		}
	}

	// 1 5 9
	// 10 11 13
	// 12 13 15
	public static int kthSmallest(int[][] matrix, int k) {
		int m = matrix.length;

		int lower = matrix[0][0];
		int upper = matrix[m - 1][m - 1];

		while (lower < upper) {
			int mid = lower + ((upper - lower) >> 1);

			int count = count(matrix, mid);
			System.out.println("count is " + count + " for lower " + lower + " and higher " + upper + " mid " + mid);
			if (count < k) {
				lower = mid + 1;
			} else {
				upper = mid;
			}
		}

		return upper;
	}

	/**
	 * Matrix is [1, 2, 3, 4], [5, 6, 7, 8], [9,10, 11, 12] print [1, 2, 5, 9, 6,
	 * 3, 4, 7, 10, 11, 8, 12] Following is the order of the elements (0, 0) ->
	 * (0, 1), (1, 0) -> (2, 0), (1, 1), (0, 2) -> (0, 3), (1, 2), (2, 1) -> (2,
	 * 2), (1, 3) -> (2, 3)
	 */
	public static void printMatrixInZigZag(int[][] m) {

		List<Integer> result = new ArrayList<>();

		int p = m.length - 1;
		int q = m[0].length - 1;

		int numOfRows = m.length + m[0].length;

		for (int i = 0; i < numOfRows; i++) {
			if (i % 2 == 0) {
				// even row case

				for (int r = i; r >= 0; r--) {
					int c = i - r;
					if (c >= 0 && c <= q && r <= p) {
						result.add(m[r][c]);
					}
				}
			} else {
				// odd row case

				for (int r = 0; r <= i; r++) {
					int c = i - r;
					if (c >= 0 && c <= q && r <= p) {
						result.add(m[r][c]);
					}
				}
			}
		}

	}

	private static int count(int[][] matrix, int target) {
		int m = matrix.length;
		int i = m - 1;
		int j = 0;
		int count = 0;

		while (i >= 0 && j < m) {
			if (matrix[i][j] <= target) {
				System.out.println("count inside is " + count + " and i+1 is " + (i + 1));
				count += i + 1;

				j++;
			} else {
				i--;
			}
		}

		return count;
	}

}
