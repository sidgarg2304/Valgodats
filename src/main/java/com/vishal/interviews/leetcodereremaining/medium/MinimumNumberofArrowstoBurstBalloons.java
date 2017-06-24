package com.vishal.interviews.leetcodereremaining.medium;

import java.util.*;

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 *
 */
public class MinimumNumberofArrowstoBurstBalloons {

	public static void main(String[] args) {

	}

	public int findMinArrowShots(int[][] points) {

		if (points == null || points.length == 0) {
			return 0;
		}

		int res = 1;

		/**
		 * we have to sort using end since we are choosing the first arrow
		 * position as end position and we have to make sure we pick the smallest
		 * one. For Eg: 7,12 9,10 should be placed as 9,10 and 7, 12. So, we pick
		 * up position 10 as arrow so that both can be shot
		 */
		Arrays.sort(points, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[1] - b[1];
			}
		});

		int curArrawPos = points[0][1];
		for (int i = 1; i < points.length; i++) {
			int[] cur = points[i];
			if (curArrawPos >= cur[0] && curArrawPos <= cur[1]) {
				continue;
			}
			res++;
			curArrawPos = cur[1];
		}
		return res;
	}

}
