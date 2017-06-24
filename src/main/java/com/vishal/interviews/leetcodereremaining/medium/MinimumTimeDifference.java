package com.vishal.interviews.leetcodereremaining.medium;

import java.util.*;

/**
 * 539. Minimum Time Difference
 * 
 * Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.

Example 1:
Input: ["23:59","00:00"]
Output: 1
 *
 */
public class MinimumTimeDifference {

	public static void main(String[] args) {

	}

	public int findMinDifference(List<String> timePoints) {

		if (timePoints == null || timePoints.size() <= 1) {
			return 0;
		}
		List<Integer> timeInMinutes = new ArrayList<>();

		for (int i = 0; i < timePoints.size(); i++) {
			String[] cur = timePoints.get(i).split(":");
			if (cur[0].equals("00") && cur[1].equals("00")) {
				timeInMinutes.add(1440);
			} else {
				timeInMinutes.add(Integer.valueOf(cur[0]) * 60 + Integer.valueOf(cur[1]));
			}
		}

		Collections.sort(timeInMinutes, new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return a - b;
			}
		});

		int diff = Integer.MAX_VALUE;
		int pre = timeInMinutes.get(0);
		for (int i = 1; i < timeInMinutes.size(); i++) {
			int cur = timeInMinutes.get(i);
			diff = Math.min(diff, cur - pre);
		}
		return diff;
	}

}
