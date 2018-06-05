package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

import com.vishal.interviews.util.Interval;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Interval> merge(List<Interval> intervals) {

		
		List<Interval> res = new ArrayList<>();

		if(intervals == null || intervals.size() == 0){
			return res;
		}
		
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.st - i2.st;
			}
		});

		Interval pre = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval cur = intervals.get(i);
			if (cur.st <= pre.en) {
				pre = new Interval(pre.st, Math.max(cur.en, pre.en));
			} else {
				res.add(pre);
				pre = cur;
			}
		}
		res.add(pre);
		return res;
	}

}
