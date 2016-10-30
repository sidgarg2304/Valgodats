package com.vishal.algorithms.combinations.pascaltriangle;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleAlgorithms {

	public static void main(String[] args) {

//		formPascalTriangle(5);
		
//		pascalTriangleRow(5);
		
//		shortestPalindrome("aacecaaa"); //a aacecaa a
//		shortestPalindrome("aabacaca"); //a aacecaa a
				
	}		

	public static void formPascalTriangle(int numOfRows) {

		List<List<Integer>> pascalTriangle = new ArrayList<>();

		List<Integer> row1 = new ArrayList<>();
		row1.add(1);
		pascalTriangle.add(row1);

		for (int i = 1; i < numOfRows; i++) {
			List<Integer> curRow = new ArrayList<>();
			curRow.add(1);
			List<Integer> prevRow = pascalTriangle.get(i - 1);
			for (int j = 1; j < prevRow.size(); j++) {
				curRow.add(prevRow.get(j - 1) + prevRow.get(j));
			}
			curRow.add(1);
			pascalTriangle.add(curRow);
		}

		System.out.println(pascalTriangle);
	}

	public static void pascalTriangleRow(int rowNum) {
		List<Integer> row = new ArrayList<>();
		row.add(1);

		for (int i = 1; i < rowNum; i++) {
			for (int j = row.size() - 2; j >= 0; j--) {				
				row.set(j+1, (row.get(j) + row.get(j+1)));
			}
			row.add(1);
		}
		
		System.out.println(row);

	}

}
