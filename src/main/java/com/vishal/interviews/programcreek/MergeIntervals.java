package com.vishal.interviews.programcreek;

import java.util.*;

import com.vishal.algorithms.interval.Interval;

public class MergeIntervals {

	public static void main(String[] args) {

	}

	public List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.getLow() - b.getLow();
			}
		});
		List<Interval> res = new ArrayList<>();
		Interval pre = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval cur = intervals.get(i);

			if (cur.getLow() <= pre.getHigh()) {
				pre = new Interval(pre.getLow(), Math.max(cur.getHigh(), pre.getHigh()));
			} else {
				res.add(pre);
				pre = cur;
			}
		}

		res.add(pre);

		return res;
	}

}
