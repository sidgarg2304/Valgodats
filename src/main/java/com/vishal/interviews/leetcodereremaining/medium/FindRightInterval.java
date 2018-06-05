package com.vishal.interviews.leetcodereremaining.medium;

import java.util.*;
import com.vishal.interviews.util.Interval;

/**
 * 436. Find Right Interval
 * 
 * Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.

For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.

Note:
You may assume the interval's end point is always bigger than its start point.
You may assume none of these intervals have the same start point.
Example 1:
Input: [ [1,2] ]

Output: [-1]

Explanation: There is only one interval in the collection, so it outputs -1.
Example 2:
Input: [ [3,4], [2,3], [1,2] ]

Output: [-1, 0, 1]

Explanation: There is no satisfied "right" interval for [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point;
For [1,2], the interval [2,3] has minimum-"right" start point.
Example 3:
Input: [ [1,4], [2,3], [3,4] ]

Output: [-1, 2, -1]

Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point.

 *
 */
public class FindRightInterval {

	public static void main(String[] args) {

	}

	public int[] findRightInterval(Interval[] intervals) {

		if (intervals == null || intervals.length == 0) {
			return new int[]{};
		}

		Map<Integer, Integer> map = new HashMap<>();
		int[] starts = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			map.put(intervals[i].st, i);
			starts[i] = intervals[i].st;
		}

		Arrays.sort(starts);

		int[] res = new int[intervals.length];

		for (int i = 0; i < intervals.length; i++) {
			res[i] = -1;
			int end = intervals[i].en;
			int nextStart = binarySearch(starts, end);
			if (nextStart >= end) {
				res[i] = map.get(nextStart);
			}
		}

		return res;
	}

	int binarySearch(int[] starts, int end) {
		int i = 0;
		int j = starts.length - 1;

		while (i <= j) {
			int m = i + (j - i) / 2;
			if (starts[m] < end) {
				i = m + 1;
			} else {
				j = m;
			}
		}

		return starts[i];
	}

}
