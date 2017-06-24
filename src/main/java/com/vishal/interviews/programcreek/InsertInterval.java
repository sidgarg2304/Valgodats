package com.vishal.interviews.programcreek;

import java.util.*;

import com.vishal.algorithms.interval.Interval;

public class InsertInterval {

	public static void main(String[] args) {

	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> res = new ArrayList<>();

		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.getLow() - b.getLow();
			}
		});
		for (int i = 0; i < intervals.size(); i++) {
			Interval cur = intervals.get(i);
			if (cur.getHigh() < newInterval.getLow()) {
				res.add(cur);
			} else if (newInterval.getHigh() < cur.getLow()) {
				res.add(newInterval);
				newInterval = cur;
			} else {
				newInterval = new Interval(Math.min(newInterval.getLow(), cur.getLow()),
						Math.max(newInterval.getHigh(), cur.getHigh()));
			}
		}
		res.add(newInterval);
		return res;
	}

}
