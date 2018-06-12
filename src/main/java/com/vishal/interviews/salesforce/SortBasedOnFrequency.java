package com.vishal.interviews.salesforce;

import java.util.*;

public class SortBasedOnFrequency {

	public static void main(String[] args) {

		int[] res = frequencySort(new int[] { 1, 2, 5, 4, 3, 2, 1, 2, 3, 4, 6, 7, 6, 6, 6 });
		System.out.println(Arrays.toString(res));

	}

	public static int[] frequencySort(int[] nums) {

		if (nums == null || nums.length == 0) {
			return new int[] {};
		}

		int maxCnt = 0;
		Map<Integer, Integer> countMap = new HashMap<>();
		for (int i : nums) {
			countMap.put(i, countMap.getOrDefault(i, 0) + 1);
			maxCnt = Math.max(maxCnt, countMap.get(i));
		}

		List<Integer>[] buckets = new List[maxCnt + 1];

		for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
			// key is element
			Integer element = entry.getKey();
			// value is the count
			Integer count = entry.getValue();

			if (buckets[count] == null) {
				buckets[count] = new ArrayList<>();
			}
			// add element to the bucket based on it's count
			buckets[count].add(element);
		}

		int r = 0;
		int[] res = new int[nums.length];

		for (int count = buckets.length - 1; count >= 0; count--) {
			List<Integer> elementsWithThisCount = buckets[count];

			// no elements with this count
			if (elementsWithThisCount == null) {
				continue;
			}

			for (Integer element : elementsWithThisCount) {
				// add element count number of times to the result
				for (int i = 0; i < count; i++) {
					res[r++] = element;
				}
			}

		}

		return res;
	}

}
