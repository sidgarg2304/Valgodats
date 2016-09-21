package com.vishal.algorithms.matrix;

public class MatrixBasicAlgorithms {

	public static void main(String[] args) {

		testAllRowColValuesZero();
		
		testAllRowColValuesOne();
	}
	
	public static void testAllRowColValuesZero(){
		int[][] a = new int[4][4];
		a[0] = new int[] { 1, 1, 1, 0 };
		a[1] = new int[] { 1, 1, 1, 0 };
		a[2] = new int[] { 1, 1, 0, 0 };
		a[3] = new int[] { 1, 0, 0, 0 };		
		
		System.out.println("original matrix is below");
		printMatrix(a);		
		setAllRowColValues(a, 0);
		System.out.println("matrix after setting zeroes is below");		
		printMatrix(a);
	}
	
	public static void testAllRowColValuesOne(){
		int[][] a = new int[3][4];
		a[0] = new int[] { 1, 0, 0, 1 };
		a[1] = new int[] { 0, 0, 1, 0 };
		a[2] = new int[] { 0, 0, 0, 0 };			
		
		System.out.println("original matrix is below");
		printMatrix(a);		
		setAllRowColValues(a, 1);
		System.out.println("matrix after setting ones is below");		
		printMatrix(a);
	}

	public static void setAllRowColValues(int[][] a, int n) {
		boolean[] row = new boolean[a.length];
		boolean[] col = new boolean[a[0].length];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] == n) {
					row[i] = true;
					col[j] = true;
				}
			}
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (row[i] || col[j]) {
					a[i][j] = n;
				}
			}
		}
	}	

	public static void printMatrix(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
