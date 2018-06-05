package com.vishal.interviews.topinterviewquestions.medium;

public class GasStation {

	public static void main(String[] args) {

	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int totalDiff = 0;

		int diff = 0;
		int st = 0;
		for (int i = 0; i < gas.length; i++) {
			int curDiff = gas[i] - cost[i];
			if (diff < 0) {
				diff = curDiff;
				st = i;
			} else {
				diff += curDiff;
			}
			totalDiff += curDiff;
		}

		if (totalDiff >= 0) {
			return st;
		}
		return -1;

	}

}
