package com.vishal.interviews.uber.medium;

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

		Collections.sort(intervals, (a, b) -> a.st == b.st ? a.en - b.en : a.st - b.st);
		
		Interval p = intervals.get(0);
		for(int i = 1; i< intervals.size(); i++) {
			Interval c = intervals.get(i);
			if(c.st <= p.en) {
				p = new Interval(p.st, Math.max(p.en, c.en));
			} else {
				res.add(p);
				p = c;
			}
		}
		res.add(p);
		
		return res;
	}

}
