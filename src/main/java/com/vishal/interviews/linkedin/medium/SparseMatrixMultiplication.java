package com.vishal.interviews.linkedin.medium;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 311. Sparse Matrix Multiplication
 * Given two sparse matrices A and B, return the result of AB.
 * You may assume that A's column number is equal to B's row number.
 * Example:
 * A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
 */
public class SparseMatrixMultiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Easiest JAVA solution
	 * @param A
	 * @param B
	 * @return
	 */
	public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length, nB = B[0].length;
        int[][] C = new int[m][nB];

        for(int i = 0; i < m; i++) {
            for(int k = 0; k < n; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < nB; j++) {
                        if (B[k][j] != 0) C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return C;   
    }
	
	/**
	 * A sparse matrix can be represented as a sequence of rows, 
	 * each of which is a sequence of (column-number, value) pairs of the nonzero values in the row.
	 * So let's create a non-zero array for A, and do multiplication on B.
	 */
	
	public int[][] multiply2(int[][] A, int[][] B) {
	    int m = A.length, n = A[0].length, nB = B[0].length;
	    int[][] result = new int[m][nB];

	    List<Integer>[] indexA = new List[m];
	    for(int i = 0; i < m; i++) {
	        List<Integer> numsA = new ArrayList<>();
	        for(int j = 0; j < n; j++) {
	            if(A[i][j] != 0){
	                numsA.add(j); 
	                numsA.add(A[i][j]);
	            }
	        }
	        indexA[i] = numsA;
	    }

	    for(int i = 0; i < m; i++) {
	        List<Integer> numsA = indexA[i];
	        for(int p = 0; p < numsA.size() - 1; p += 2) {
	            int colA = numsA.get(p);
	            int valA = numsA.get(p + 1);
	            for(int j = 0; j < nB; j ++) {
	                int valB = B[colA][j];
	                result[i][j] += valA * valB;
	            }
	        }
	    }

	    return result;   
	}
	
	/**
	 * Java solution with only one table for B (~150ms):
	 */
	
	public int[][] multiply3(int[][] A, int[][] B) {
        if (A == null || A[0] == null || B == null || B[0] == null) return null;
        int m = A.length, n = A[0].length, l = B[0].length;
        int[][] C = new int[m][l];
        Map<Integer, HashMap<Integer, Integer>> tableB = new HashMap<>();
        
        for(int k = 0; k < n; k++) {
            tableB.put(k, new HashMap<Integer, Integer>());
            for(int j = 0; j < l; j++) {
                if (B[k][j] != 0){
                    tableB.get(k).put(j, B[k][j]);
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int k = 0; k < n; k++) {
                if (A[i][k] != 0){
                    for (Integer j: tableB.get(k).keySet()) {
                        C[i][j] += A[i][k] * tableB.get(k).get(j);
                    }
                }
            }
        }
        return C;   
    }
	
	/**
	 * Java solution without table (~70ms):
	 */
	
	public int[][] multiply4(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length, l = B[0].length;
        int[][] C = new int[m][l];

        for(int i = 0; i < m; i++) {
            for(int k = 0; k < n; k++) {
                if (A[i][k] != 0){
                    for (int j = 0; j < l; j++) {
                        if (B[k][j] != 0) C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return C;   
    }
	
	/**
	 * Java solution with two tables (~160ms):
	 */
	
	public int[][] multiply5(int[][] A, int[][] B) {
        if (A == null || B == null) return null;
        if (A[0].length != B.length) 
            throw new IllegalArgumentException("A's column number must be equal to B's row number.");
        Map<Integer, HashMap<Integer, Integer>> tableA = new HashMap<>();
        Map<Integer, HashMap<Integer, Integer>> tableB = new HashMap<>();
        int[][] C = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] != 0) {
                    if(tableA.get(i) == null) tableA.put(i, new HashMap<Integer, Integer>());
                    tableA.get(i).put(j, A[i][j]);
                }
            }
        }
        
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[i].length; j++) {
                if (B[i][j] != 0) {
                    if(tableB.get(i) == null) tableB.put(i, new HashMap<Integer, Integer>());
                    tableB.get(i).put(j, B[i][j]);
                }
            }
        }
        
        for (Integer i: tableA.keySet()) {
            for (Integer k: tableA.get(i).keySet()) {
                if (!tableB.containsKey(k)) continue;
                for (Integer j: tableB.get(k).keySet()) {
                    C[i][j] += tableA.get(i).get(k) * tableB.get(k).get(j);
                }
            }
        }
        return C;
    }

}
