package com.vishal.algorithms.combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationsSumAlgorithms {

	public static void main(String[] args) {
		testCombinationsum();
	}

	public static void testCombinationsum() {
		int[] elements = { 2, 3, 6, 7 };
		combinationsum(7, elements);
	}

	public static void combinationsum(int sum, int[] elements) {
		Arrays.sort(elements);
		List<List<Integer>> result = new ArrayList<>();
		combinationsum(sum, elements, new ArrayList<Integer>(), result, 0);

		
		System.out.println("combinations are " + result);
	}

	public static void combinationsum(int sum, int[] elements, List<Integer> temp, List<List<Integer>> result,
			int start) {

		if (sum < 0) {
			return;
		}

		if (sum == 0) {
			List<Integer> curResult = new ArrayList<>();
			curResult.addAll(temp);
			result.add(curResult);
			return;
		}
		for (int i = start; i < elements.length; i++) {
			temp.add(elements[i]);
			combinationsum(sum - elements[i], elements, temp, result, i);
			temp.remove(temp.size() - 1);
		}
	}

}
