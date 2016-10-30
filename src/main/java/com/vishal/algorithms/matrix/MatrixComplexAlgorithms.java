package com.vishal.algorithms.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixComplexAlgorithms {

	public static void main(String[] args) {
//		testRotateMatrix90Degrees();
		
		int [][] edges = new int[3][2];
		edges[0] = new int[]{0,1};
		edges[1] = new int[]{1,2};
		edges[2] = new int[]{3,4};
		
		System.out.println(countComponents(5, edges));
	}
	
	public static int countComponents(int n, int[][] edges) {
	    int count = n;
	 
	    int[] root = new int[n];
	    // initialize each node is an island
	    for(int i=0; i<n; i++){
	        root[i]=i;        
	    }
	 
	    for(int i=0; i<edges.length; i++){
	        int x = edges[i][0];
	        int y = edges[i][1];
	 
	        int xRoot = getRoot(root, x);
	        int yRoot = getRoot(root, y);
	        
	        System.out.println("xroot " + xRoot + " and yRoot " + yRoot + " for " + Arrays.toString(edges[i]));
	        System.out.println("root is " + Arrays.toString(root));
	 
	        if(xRoot!=yRoot){
	            count--;
	            root[xRoot]=yRoot;
	        }
	 
	    }
	 
	    return count;
	}
	 
	public static int getRoot(int[] arr, int i){
	    while(arr[i]!=i){
	        arr[i]= arr[arr[i]];
	        i=arr[i];
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

}
