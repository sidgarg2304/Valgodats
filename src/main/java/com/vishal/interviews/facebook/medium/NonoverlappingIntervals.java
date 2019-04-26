package com.vishal.interviews.facebook.medium;

import java.util.Arrays;

import com.vishal.interviews.util.Interval;

public class NonoverlappingIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int eraseOverlapIntervals(Interval[] intervals) {

		if (intervals == null || intervals.length == 0) {
			return 0;
		}

		Arrays.sort(intervals, (a, b) -> a.en - b.en);

		Interval p = intervals[0];
		int overlapCnt = 0;
		for (int i = 1; i < intervals.length; i++) {
			Interval c = intervals[i];
            // not overlap
			if (c.st >= p.en) {				
                p = c;
			} else {
                //overlap
                overlapCnt++;
            }
		}
		return overlapCnt;
	}

}
