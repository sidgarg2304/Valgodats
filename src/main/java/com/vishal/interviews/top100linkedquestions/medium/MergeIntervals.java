package com.vishal.interviews.top100linkedquestions.medium;

import java.util.*;

import com.vishal.interviews.util.Interval;

public class MergeIntervals {

	public static void main(String[] args) {

	}

	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<>();

		if (intervals == null || intervals.size() == 0) {
			return res;
		}

		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.st - b.st;
			}
		});

		Interval p = intervals.get(0);

		for (int i = 1; i < intervals.size(); i++) {
			Interval c = intervals.get(i);

			if (p.en < c.st) {
				res.add(p);
				p = c;
			} else {
				p = new Interval(p.st, Math.min(p.en, c.en));
			}
		}

		res.add(p);

		return res;
	}

}
