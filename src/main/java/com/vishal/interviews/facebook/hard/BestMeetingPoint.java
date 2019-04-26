package com.vishal.interviews.facebook.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestMeetingPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minTotalDistance(int[][] grid) {

		if (grid == null || grid.length == 0) {
			return 0;
		}

		List<Integer> rows = new ArrayList<>();
		List<Integer> cols = new ArrayList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					rows.add(i);
					cols.add(j);
				}
			}
		}

		int res = 0;
		for (int i : rows) {
			res += Math.abs(i - rows.get(rows.size() / 2));
		}
		Collections.sort(cols);
		for (int i : cols) {
			res += Math.abs(i - cols.get(cols.size() / 2));
		}

		return res;
	}

}
