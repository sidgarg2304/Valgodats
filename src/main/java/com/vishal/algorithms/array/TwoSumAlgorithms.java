package com.vishal.algorithms.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSumAlgorithms {

	public static void main(String[] args) {
		findTowSumSinglePair(new int[] { 3, 3, 11, 15 }, 6);
		findTowSumSinglePair(new int[] { 3, 11, 15 }, 6);
		findTowSumSinglePairPositions(new int[] { 3, 3, 11, 15 }, 6);
		printTwoSumPairsWithoutDups(new int[] { 1, 3, 4, 6, 8 }, 7);
		printTwoSumPairsWithDups(new int[] { 1, 3, 6, 4, 3, -1, 8, 1, 6 }, 7);
	}

	// 2,7,11,15 & 9 -> 0,1
	public static void findTowSumSinglePair(int[] a, int sum) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			int pairVal = sum - a[i];
			if (set.contains(pairVal)) {
				System.out.println("found pair " + pairVal + " and " + a[i]);
				return;
			} else {
				set.add(a[i]);
			}
		}
		
		System.out.println("no pair found");
	}

	// 2,7,11,15 & 9 -> 0,1
	public static void findTowSumSinglePairPositions(int[] a, int sum) {
		Map<Integer, Integer> pairMap = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			int pairVal = sum - a[i];
			if (pairMap.containsKey(pairVal)) {
				System.out.println("found pair " + pairMap.get(pairVal) + " and " + i);
				return;
			} else {
				pairMap.put(a[i], i);
			}
		}
	}

	public static void printTwoSumPairsWithoutDups(int[] a, int sum) {
		Map<Integer, Integer> pairMap = new HashMap<>();

		for (int i = 0; i < a.length; i++) {
			int pairVal = sum - a[i];
			if (pairMap.containsKey(pairVal)) {
				pairMap.put(pairVal, a[i]);
			} else {
				pairMap.put(a[i], null);
			}
		}
		System.out.println(pairMap);
	}

	public static void printTwoSumPairsWithDups(int[] a, int sum) {
		Map<Integer, ArrayList<Integer>> pairMap = new HashMap<>();

		for (int i = 0; i < a.length; i++) {
			int pairVal = sum - a[i];
			if (pairMap.containsKey(pairVal)) {
				pairMap.get(pairVal).add(a[i]);
			}

			if (!pairMap.containsKey(a[i])) {
				pairMap.put(a[i], new ArrayList<>());
			}
		}

		System.out.println(pairMap);
	}

}
