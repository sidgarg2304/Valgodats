package com.vishal.interviews.programcreek.heap;

import java.util.*;

import com.vishal.interviews.util.Interval;

public class MeetingRoomsII {

	public static void main(String[] args) {

	}

	public int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.st - i2.st;
			}
		});

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		minHeap.offer(intervals[0].en);

		int res = 1;
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].st < minHeap.peek()) {
				res++;
			} else {
				minHeap.poll();
			}
			minHeap.offer(intervals[i].en);
		}

		return res;
	}

}
