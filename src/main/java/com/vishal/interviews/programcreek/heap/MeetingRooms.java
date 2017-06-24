package com.vishal.interviews.programcreek.heap;
import java.util.*;


import com.vishal.interviews.util.Interval;

public class MeetingRooms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canAttendMeetings(Interval[] intervals) {

		if (intervals == null || intervals.length <= 1) {
			return true;
		}

		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.st - i2.st;
			}
		});
		
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].st < intervals[i-1].en) {
				return false;
			}
		}

		return true;
	}
}
