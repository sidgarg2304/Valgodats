package com.vishal.interviews.uber.hard;

import java.util.*;

import com.vishal.interviews.util.Interval;

public class InsertInterval {

	public static void main(String[] args) {

	}

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> res = new ArrayList<>();
		Interval p = newInterval;
		for (int i = 0; i < intervals.size(); i++) {
			Interval c = intervals.get(i);
			if (c.st > p.en) {
				res.add(p);
				p = c;
			} else if (p.st > c.en) {
				res.add(c);
			} else {
				p = new Interval(Math.min(p.st, c.st), Math.max(p.en, c.en));
			}
		}
		res.add(p);

		return res;

	}

}
