package com.vishal.interviews.google.hard;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * 391. Perfect Rectangle
 * 
 * Given N axis-aligned rectangles where N > 0, determine if they all together form an exact cover of a rectangular region.

Each rectangle is represented as a bottom-left point and a top-right point. For example, a unit square is represented as [1,1,2,2]. (coordinate of bottom-left point is (1, 1) and top-right point is (2, 2)).


Example 1:

rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [3,2,4,4],
  [1,3,2,4],
  [2,3,3,4]
]

Return true. All 5 rectangles together form an exact cover of a rectangular region.

Example 2:

rectangles = [
  [1,1,2,3],
  [1,3,2,4],
  [3,1,4,2],
  [3,2,4,4]
]

Return false. Because there is a gap between the two rectangular regions.

Example 3:

rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [1,3,2,4],
  [3,2,4,4]
]

Return false. Because there is a gap in the top center.

Example 4:

rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [1,3,2,4],
  [2,2,4,4]
]

Return false. Because two of the rectangles overlap with each other.
 */
public class PerfectRectangle {

	public static void main(String[] args) {

	}
	
	/**
	 * Really Easy Understanding Solution(O(n), Java) The right answer must
	 * satisfy two conditions:
	 * 
	 * the large rectangle area should be equal to the sum of small rectangles
	 * count of all the points should be even, and that of all the four corner
	 * points should be one
	 * 
	 * @param rectangles
	 * @return
	 */
	public boolean isRectangleCoverEasy(int[][] rectangles) {

		if (rectangles.length == 0 || rectangles[0].length == 0)
			return false;

		int x1 = Integer.MAX_VALUE;
		int x2 = Integer.MIN_VALUE;
		int y1 = Integer.MAX_VALUE;
		int y2 = Integer.MIN_VALUE;

		HashSet<String> set = new HashSet<String>();
		int area = 0;

		for (int[] rect : rectangles) {
			x1 = Math.min(rect[0], x1);
			y1 = Math.min(rect[1], y1);
			x2 = Math.max(rect[2], x2);
			y2 = Math.max(rect[3], y2);

			area += (rect[2] - rect[0]) * (rect[3] - rect[1]);

			String s1 = rect[0] + " " + rect[1];
			String s2 = rect[0] + " " + rect[3];
			String s3 = rect[2] + " " + rect[3];
			String s4 = rect[2] + " " + rect[1];

			if (!set.add(s1))
				set.remove(s1);
			if (!set.add(s2))
				set.remove(s2);
			if (!set.add(s3))
				set.remove(s3);
			if (!set.add(s4))
				set.remove(s4);
		}

		if (!set.contains(x1 + " " + y1) || !set.contains(x1 + " " + y2) || !set.contains(x2 + " " + y1)
				|| !set.contains(x2 + " " + y2) || set.size() != 4)
			return false;

		return area == (x2 - x1) * (y2 - y1);
	}

	/**
	 * O(n log n) sweep line solution Standard sweep line solution.
	 * 
	 * Basic idea:
	 * 
	 * Sort by x-coordinate.
	 * 
	 * Insert y-interval into TreeSet, and check if there are intersections.
	 * 
	 * Delete y-interval.
	 * 
	 * @param rectangles
	 * @return
	 */
	public boolean isRectangleCoverSweepLineSol(int[][] rectangles) {
		PriorityQueue<Event> pq = new PriorityQueue<Event>();
		// border of y-intervals
		int[] border = { Integer.MAX_VALUE, Integer.MIN_VALUE };
		for (int[] rect : rectangles) {
			Event e1 = new Event(rect[0], rect);
			Event e2 = new Event(rect[2], rect);
			pq.add(e1);
			pq.add(e2);
			if (rect[1] < border[0])
				border[0] = rect[1];
			if (rect[3] > border[1])
				border[1] = rect[3];
		}
		TreeSet<int[]> set = new TreeSet<int[]>(new Comparator<int[]>() {
			@Override
			// if two y-intervals intersects, return 0
			public int compare(int[] rect1, int[] rect2) {
				if (rect1[3] <= rect2[1])
					return -1;
				else if (rect2[3] <= rect1[1])
					return 1;
				else
					return 0;
			}
		});
		int yRange = 0;
		while (!pq.isEmpty()) {
			int time = pq.peek().time;
			while (!pq.isEmpty() && pq.peek().time == time) {
				Event e = pq.poll();
				int[] rect = e.rect;
				if (time == rect[2]) {
					set.remove(rect);
					yRange -= rect[3] - rect[1];
				} else {
					if (!set.add(rect))
						return false;
					yRange += rect[3] - rect[1];
				}
			}
			// check intervals' range
			if (!pq.isEmpty() && yRange != border[1] - border[0]) {
				return false;
				// if (set.isEmpty()) return false;
				// if (yRange != border[1] - border[0]) return false;
			}
		}
		return true;
	}

}

class Event implements Comparable<Event> {
	int time;
	int[] rect;

	public Event(int time, int[] rect) {
		this.time = time;
		this.rect = rect;
	}
	
	public int compareTo(Event that) {
		if (this.time != that.time) return this.time - that.time;
		else return this.rect[0] - that.rect[0];
	}
}

/**
 * Short Java solution with explanation (updated) If all rectangles can form an
 * exact rectangular area, they should follow these conditions:
 * 
 * The sum of area of all small rectangles should equal to the area of large
 * rectangle. At any position except outer four corners, the amount of
 * overlapping corners should be even (2, 4). Corners that overlap at the same
 * point should be different type (top-left, top-right, bottom-left,
 * bottom-right). So, I used
 * 
 * Four int variables to record the boundaries of large rectangle and then
 * calculate the area.
 * 
 * A hashmap that maps corner with its type.
 * 
 * Four numbers (1, 2, 4, 8) to represent four types of corner. Then use bit
 * manipulation to modify and check. O(n) time complexity, O(n) space, 112 ms
 * run time.
 */
class PerfectRectangleShort {
	Map<String, Integer> map = new HashMap<String, Integer>();

	public boolean isRectangleCover(int[][] rectangles) {
		if (rectangles.length == 0 || rectangles[0].length == 0)
			return false;
		int lx = Integer.MAX_VALUE, ly = lx, rx = Integer.MIN_VALUE, ry = rx, sum = 0;
		for (int[] rec : rectangles) {
			lx = Math.min(lx, rec[0]);
			ly = Math.min(ly, rec[1]);
			rx = Math.max(rx, rec[2]);
			ry = Math.max(ry, rec[3]);
			sum += (rec[2] - rec[0]) * (rec[3] - rec[1]);
			// bottom-left
			if (overlap(rec[0] + " " + rec[1], 1))
				return false;
			// top-left
			if (overlap(rec[0] + " " + rec[3], 2))
				return false;
			// bottom-right
			if (overlap(rec[2] + " " + rec[1], 4))
				return false;
			// top-right
			if (overlap(rec[2] + " " + rec[3], 8))
				return false;
		}
		int count = 0;
		Iterator<Integer> iter = map.values().iterator();
		while (iter.hasNext()) {
			Integer i = iter.next();
			if (i != 15 && i != 12 && i != 10 && i != 9 && i != 6 && i != 5 && i != 3)
				count++;
		}
		return count == 4 && sum == (rx - lx) * (ry - ly);
	}

	private boolean overlap(String corner, Integer type) {
		Integer temp = map.get(corner);
		if (temp == null)
			temp = type;
		else if ((temp & type) != 0)
			return true;
		else
			temp |= type;
		map.put(corner, temp);
		return false;
	}
}
