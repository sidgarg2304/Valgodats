package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

public class FourSumII {

	public static void main(String[] args) {

	}

	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				int sum = A[i] + B[j];
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
		}

		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				int sum = C[i] + D[j];
				res += map.getOrDefault(-sum, 0);
			}
		}

		return res;
	}

}
