package com.vishal.interviews.facebook.easy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 252. Meeting Rooms
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could 
 * attend all meetings.
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return false.
 *
 */
public class MeetingRooms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * AC clean Java solution
	 */
	public boolean canAttendMeetings(Interval[] intervals) {
		  if (intervals == null)
		    return false;

		  // Sort the intervals by start time
		  Arrays.sort(intervals, new Comparator<Interval>() {
		    public int compare(Interval a, Interval b) { return a.start - b.start; }
		  });
		  
		  for (int i = 1; i < intervals.length; i++)
		    if (intervals[i].start < intervals[i - 1].end)
		      return false;
		  
		  return true;
		}
	
	/**
	 * Easy JAVA solution beat 98%
	 * @param intervals
	 * @return
	 */
	public boolean canAttendMeetings2(Interval[] intervals) {
        int len=intervals.length;
        if(len==0){
            return true;
        }
        int[]begin=new int[len];
        int[]stop=new int[len];
        for(int i=0;i<len;i++){
            begin[i]=intervals[i].start;
            stop[i]=intervals[i].end;
        }
        Arrays.sort(begin);
        Arrays.sort(stop);
        int endT=0;
        for(int i=1;i<len;i++){
            if(begin[i]<stop[i-1]){
                return false;
            }
        }
        return true;
}

}

class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	  }
