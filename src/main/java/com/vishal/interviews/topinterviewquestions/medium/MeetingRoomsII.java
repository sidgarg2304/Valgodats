package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

import com.vishal.interviews.util.Interval;

public class MeetingRoomsII {

	public static void main(String[] args) {

	}

	public int minMeetingRooms(Interval[] intervals) {
		int res = 1;

		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				if (a.st == b.st) {
					return a.en - b.en;
				}
				return a.st - b.st;
			}
		});

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		minHeap.offer(intervals[0].en);

		for (int i = 1; i < intervals.length; i++) {
			if(intervals[i].st < minHeap.peek()){
				res++;
			}else{
				minHeap.poll();
			}
			minHeap.offer(intervals[i].en);
		}

		return res;

	}

}
