package com.vishal.interviews.programcreek.heap;

public class RangeAddition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] getModifiedArray(int length, int[][] updates) {
		int[] res = new int[length];

		for (int[] up : updates) {
			res[up[0]] += up[2];
			if (up[1] + 1 < res.length) {
				res[up[1] + 1] -= up[2];
			}
		}

		for (int i = 1; i < res.length; i++) {
			res[i] += res[i - 1];
		}
		return res;
	}

}
