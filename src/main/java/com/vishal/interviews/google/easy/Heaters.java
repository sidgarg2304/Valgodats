package com.vishal.interviews.google.easy;

import java.util.Arrays;

/**
 * 475. Heaters
 * 
 * Winter is coming! Your first job during the contest is to design a standard
 * heater with fixed warm radius to warm all the houses.
 * 
 * Now, you are given positions of houses and heaters on a horizontal line, find
 * out minimum radius of heaters so that all houses could be covered by those
 * heaters.
 * 
 * So, your input will be the positions of houses and heaters separately, and
 * your expected output will be the minimum radius standard of heaters.
 * 
 * Note:
 * 
 * Numbers of houses and heaters you are given are non-negative and will not
 * exceed 25000.
 * 
 * Positions of houses and heaters you are given are non-negative and will not
 * exceed 10^9.
 * 
 * As long as a house is in the heaters' warm radius range, it can be warmed.
 * 
 * All the heaters follow your radius standard and the warm radius will the
 * same.
 * 
 * Example 1: Input: [1,2,3],[2] Output: 1
 * 
 * Explanation:
 * 
 * The only heater was placed in the position 2, and if we use the radius 1
 * standard, then all the houses can be warmed.
 * 
 * Example 2: Input: [1,2,3,4],[1,4] Output: 1 Explanation:
 * 
 * The two heater was placed in the position 1 and 4. We need to use radius 1
 * standard, then all the houses can be warmed.
 */
public class Heaters {

	public static void main(String[] args) {

	}

	/**
	 * Short and Clean Java Binary Search Solution The idea is to leverage decent
	 * Arrays.binarySearch() function provided by Java.
	 * 
	 * For each house, find its position between those heaters (thus we need the
	 * heaters array to be sorted).
	 * 
	 * Calculate the distances between this house and left heater and right
	 * heater, get a MIN value of those two values. Corner cases are there is no
	 * left or right heater.
	 * 
	 * Get MAX value among distances in step 2. It's the answer. Time complexity:
	 * max(O(nlogn), O(mlogn)) - m is the length of houses, n is the length of
	 * heaters.
	 * 
	 * @param houses
	 * @param heaters
	 * @return
	 */
	public int findRadiusBinarySearch(int[] houses, int[] heaters) {
		Arrays.sort(heaters);
		int result = Integer.MIN_VALUE;

		for (int house : houses) {
			int index = Arrays.binarySearch(heaters, house);
			if (index < 0) {
				index = -(index + 1);
			}
			int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
			int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

			result = Math.max(result, Math.min(dist1, dist2));
		}

		return result;
	}

	/**
	 * 
	 * Simple Java Solution with 2 Pointers
	 * 
	 * Based on 2 pointers, the idea is to find the nearest heater for each
	 * house, by comparing the next heater with the current heater.
	 * 
	 * @param houses
	 * @param heaters
	 * @return
	 */
	public int findRadiusSimpleWithTwoPointers(int[] houses, int[] heaters) {
		Arrays.sort(houses);
		Arrays.sort(heaters);

		int i = 0, j = 0, res = 0;
		while (i < houses.length) {
			while (j < heaters.length - 1 && Math.abs(heaters[j + 1] - houses[i]) <= Math.abs(heaters[j] - houses[i])) {
				j++;
			}
			res = Math.max(res, Math.abs(heaters[j] - houses[i]));
			i++;
		}

		return res;
	}

	public int findRadiusSimpleWithTwoPointersUpdated(int[] houses, int[] heaters) {
		Arrays.sort(houses);
		Arrays.sort(heaters);

		int i = 0, res = 0;
		for (int house : houses) {
			while (i < heaters.length - 1 && heaters[i] + heaters[i + 1] <= house * 2) {
				i++;
			}
			res = Math.max(res, Math.abs(heaters[i] - house));
		}

		return res;
	}

	/**
	 * Java Easy Solution
	 * 
	 * Hi there! I am sharing my solution. The idea is to find the closest heater
	 * to each house and take maximum of the closest distances. Thus initially it
	 * is necessary to sort both houses and heaters by their coordinates. Then
	 * assign two pointers, one for houses and another for heaters. Then start
	 * traversing the houses. If the ith house is located between j-1th heater
	 * and jth heater, then take distance to the closest one and check whether it
	 * is the maximum radius found so far. The corner cases are when a house is
	 * located before the 1st heater, and when a house is located after the last
	 * heater. At the corner case position, there are only distance to consider.
	 * That's it. I think code will clarify the idea more.
	 * 
	 * P.S: Do not forget to sort houses and heaters at the beginning. Most
	 * contestants seem to get wrong answer, because they assumed the input to be
	 * sorted already (including me:=)).
	 * 
	 * @param houses
	 * @param heaters
	 * @return
	 */
	public int findRadiusEasy(int[] houses, int[] heaters) {
		if (houses == null || houses.length == 0)
			return 0;
		Arrays.sort(houses);
		Arrays.sort(heaters);
		int ans = 0;
		int i = 0;
		int j = 0;
		while (i < houses.length) {
			if (houses[i] <= heaters[j]) { // if house is located before heater j.
				if (j == 0) { // corner case when the heater is the first one
					ans = Math.max(ans, heaters[j] - houses[i]);
					i++;
					continue;
				}
			} else { // if house is located after some heater,
				while (j != heaters.length - 1 && heaters[j] < houses[i]) { // then
																								// find
																								// a
																								// heater
																								// that
																								// stands
																								// after
																								// the
																								// house
					j++;
				}
				if (j == 0 || heaters[j] < houses[i]) { // corner cases if j is 0 or
																	 // there is no more heaters
					ans = Math.max(ans, houses[i] - heaters[j]);
					i++;
					continue;
				}
			}
			int dist = Math.min(houses[i] - heaters[j - 1], heaters[j] - houses[i]); // if
																											 // house
																											 // is
																											 // located
																											 // between
																											 // jth
																											 // and
																											 // j-1th
																											 // heaters
			ans = Math.max(ans, dist);
			i++;
		}

		return ans;
	}

}
