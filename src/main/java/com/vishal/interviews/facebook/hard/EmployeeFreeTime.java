package com.vishal.interviews.facebook.hard;

import java.util.*;

public class EmployeeFreeTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

		List<Interval> res = new ArrayList<>();
		if (schedule == null || schedule.isEmpty()) {
			return res;
		}
		List<Interval> flattened = new ArrayList<>();
		for (List<Interval> s : schedule) {
			flattened.addAll(s);
		}

		Collections.sort(flattened, (a, b) -> a.start - b.start);

		Interval p = flattened.get(0);
		for (int i = 1; i < flattened.size(); i++) {
			Interval c = flattened.get(i);
			if (c.start > p.end) {
				res.add(new Interval(p.start, c.start));
				p = c;
			} else {
				p.end = Math.max(p.end, c.end);
			}
		}

		return res;
	}

	class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

}
