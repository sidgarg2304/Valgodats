package com.vishal.interviews.programcreek;

import java.util.*;

public class Triangle {

	public static void main(String[] args) {

		List<List<Integer>> triangle = new ArrayList<>();
		List<Integer> row1 = new ArrayList<>();
		row1.add(2);

		List<Integer> row2 = new ArrayList<>();
		row2.add(3);
		row2.add(4);

		List<Integer> row3 = new ArrayList<>();
		row3.add(6);
		row3.add(5);
		row3.add(7);

		List<Integer> row4 = new ArrayList<>();
		row4.add(4);
		row4.add(1);
		row4.add(8);
		row4.add(3);

		triangle.add(row1);
		triangle.add(row2);
		triangle.add(row3);
		triangle.add(row4);

		System.out.println(minimumTotal(triangle));
	}

	public static int minimumTotal(List<List<Integer>> triangle) {

		int[] temp = new int[triangle.get(triangle.size() - 1).size()];
		
		for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++) {
			temp[i] = triangle.get(triangle.size() - 1).get(i);			
		}
		for (int i = triangle.size() - 2; i >= 0; i--) {
			List<Integer> row = triangle.get(i);
			
			for (int j = 0; j < row.size(); j++) {
				temp[j] = Math.min(row.get(j) + temp[j], row.get(j) + temp[j + 1]);				
			}
		}
		return temp[0];
	}
}
