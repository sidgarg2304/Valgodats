package com.vishal.interviews.uber.medium;

import java.util.*;

public class MeetingRoomsII {

	public static void main(String[] args) {

	}

	public int minMeetingRooms(Interval[] intervals) {

		if (intervals == null || intervals.length == 0) {
			return 0;
		}

		Arrays.sort(intervals, (a, b) -> a.start != b.start ? a.start - b.start : a.end - b.end);

		int res = 1;

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		minHeap.offer(intervals[0].end);
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start < minHeap.peek()) {
				res++;
			} else {
				minHeap.poll();
			}
			minHeap.offer(intervals[i].end);
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
