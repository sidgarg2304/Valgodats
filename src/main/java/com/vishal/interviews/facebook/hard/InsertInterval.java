package com.vishal.interviews.facebook.hard;

import java.util.*;

import com.vishal.interviews.util.Interval;

public class InsertInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> res = new ArrayList<>();

		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.st - i2.st;
			}
		});

		for (int i = 0; i < intervals.size(); i++) {
			Interval cur = intervals.get(i);
			if (newInterval.st > cur.en) {
				res.add(cur);
			} else if (newInterval.en < cur.st) {
				res.add(newInterval);
				newInterval = cur;
			} else {
				newInterval = new Interval(Math.min(cur.st, newInterval.st), Math.max(newInterval.en, cur.en));
			}
		}
		res.add(newInterval);

		return res;
	}

}
