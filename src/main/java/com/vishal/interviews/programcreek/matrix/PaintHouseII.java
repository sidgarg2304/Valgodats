package com.vishal.interviews.programcreek.matrix;

public class PaintHouseII {

	public static void main(String[] args) {

	}

	public int minCostII(int[][] costs) {
		if (costs == null || costs.length == 0) {
			return 0;
		}

		int prevMin = 0;
		int prevSecMin = 0;
		int prevMinIndex = -1;

		for (int i = 0; i < costs.length; i++) {
			int curMin = Integer.MAX_VALUE;
			int curSecMin = Integer.MAX_VALUE;
			int curMinIndex = -1;
			for (int j = 0; j < costs[0].length; j++) {
				int val = costs[i][j];
				if (j == prevMinIndex) {
					val += prevSecMin;
				} else {
					val += prevMin;
				}

				if (val < curMin) {
					curSecMin = curMin;
					curMin = val;
					curMinIndex = j;
				} else if (val < curSecMin) {
					curSecMin = val;
				}
			}

			prevMin = curMin;
			prevSecMin = curSecMin;
			prevMinIndex = curMinIndex;
		}

		return prevMin;
	}

}
