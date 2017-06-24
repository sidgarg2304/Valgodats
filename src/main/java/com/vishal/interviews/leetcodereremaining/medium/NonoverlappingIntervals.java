package com.vishal.interviews.leetcodereremaining.medium;

import java.util.*;

import com.vishal.interviews.util.Interval;

public class NonoverlappingIntervals {

	public static void main(String[] args) {

	}

	public int eraseOverlapIntervals(Interval[] intervals) {

		if (intervals == null || intervals.length <= 1) {
			return 0;
		}

		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				return a.en - b.en;
			}
		});

		int en = intervals[0].en;
		int overlapCnt = 0;
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].st >= en) {
				overlapCnt++;
				en = intervals[i].en;
			}
		}

		return intervals.length - overlapCnt;
	}
}
