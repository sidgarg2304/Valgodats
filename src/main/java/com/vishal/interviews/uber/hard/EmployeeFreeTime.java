package com.vishal.interviews.uber.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeFreeTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
		List<Interval> res = new ArrayList<>();

		List<Interval> flatten = new ArrayList<>();
		for (List<Interval> s : schedule) {
			flatten.addAll(s);
		}

		Collections.sort(flatten, (a, b) -> a.start - b.start);

		Interval p = flatten.get(0);
		for (int i = 1; i < flatten.size(); i++) {
			Interval c = flatten.get(i);
			if(c.start > p.end) {
				res.add(new Interval(p.end, c.start));
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
