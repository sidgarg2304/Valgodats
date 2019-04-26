package com.vishal.interviews.facebook.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import com.vishal.interviews.util.Interval;

/**
 * 253. Meeting Rooms II
 * 
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms
 * required.
 * 
 * For example,
 * 
 * Given [[0, 30],[5, 10],[15, 20]],
 * 
 * return 2.
 */
public class MeetingRoomsII {

	public static void main(String[] args) {

	}

	public int minMeetingRoomsMinHeap(Interval[] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;

		// Sort the intervals by start time
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.st - b.st;
			}
		});

		// Use a min heap to track the minimum end time of merged intervals
		PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.en - b.en;
			}
		});

		// start with the first meeting, put it to a meeting room
		heap.offer(intervals[0]);

		for (int i = 1; i < intervals.length; i++) {
			// get the meeting room that finishes earliest
			Interval interval = heap.poll();

			if (intervals[i].st >= interval.en) {
				// if the current meeting starts right after
				// there's no need for a new room, merge the interval
				interval.en = intervals[i].en;
			} else {
				// otherwise, this meeting needs a new room
				heap.offer(intervals[i]);
			}

			// don't forget to put the meeting room back
			heap.offer(interval);
		}

		return heap.size();
	}

	/**
	 * Explanation of "Super Easy Java Solution Beats 98.8%"
	 * 
	 * @param intervals
	 * @return
	 */
	public int minMeetingRoomsSuperEasy(Interval[] intervals) {
		int[] starts = new int[intervals.length];
		int[] ends = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			starts[i] = intervals[i].st;
			ends[i] = intervals[i].en;
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		int rooms = 0;
		int endsItr = 0;
		for (int i = 0; i < starts.length; i++) {
			if (starts[i] < ends[endsItr])
				rooms++;
			else
				endsItr++;
		}
		return rooms;
	}

}



/**
 * Simulate event queue procession. Create event for each start and end of
 * intervals. Then for start event, open one more room; for end event, close one
 * meeting room. At the same time, update the most rooms that is required.
 * 
 * Be careful of events like [(end at 11), (start at 11)]. Put end before start
 * event when they share the same happening time, so that two events can share
 * one meeting room.
 * 
 *
 */
class SolutionProcessEventQueue {

	private static final int START = 1;

	private static final int END = 0;

	private class Event {
		int time;
		int type; // end event is 0; start event is 1

		public Event(int time, int type) {
			this.time = time;
			this.type = type;
		}
	}

	public int minMeetingRooms(Interval[] intervals) {
		int rooms = 0; // occupied meeting rooms
		int res = 0;

		// initialize an event queue based on event's happening time
		Queue<Event> events = new PriorityQueue<>(new Comparator<Event>() {
			@Override
			public int compare(Event e1, Event e2) {
				// for same time, let END event happens first to save rooms
				return e1.time != e2.time ? e1.time - e2.time : e1.type - e2.type;
			}
		});

		// create event and push into event queue
		for (Interval interval : intervals) {
			events.offer(new Event(interval.st, START));
			events.offer(new Event(interval.en, END));
		}

		// process events
		while (!events.isEmpty()) {
			Event event = events.poll();
			if (event.type == START) {
				rooms++;
				res = Math.max(res, rooms);
			} else {
				rooms--;
			}
		}

		return res;
	}

}
