package com.vishal.interviews.facebook.careercup;

public class GasStation {

	public static void main(String[] args) {

	}

	public int canCompleteCircuit(int[] gas, int[] cost) {

		int totalDiff = 0;
		int curDiff = 0;

		int st = 0;
		for (int i = 0; i < gas.length; i++) {
			int diff = gas[i] - cost[i];
			if (curDiff < 0) {
				curDiff = diff;
				st = i;
			} else {
				curDiff += diff;
			}
			totalDiff += diff;
		}

		if (totalDiff >= 0) {
			return st;
		}

		return -1;
	}
}
