package com.vishal.interviews.google.hard;

import java.util.*;

import com.vishal.interviews.util.Point;
/**
 * 587. Erect the Fence

There are some trees, where each tree is represented by (x,y) coordinate in a two-dimensional garden. Your job is to fence the entire garden using the minimum length of rope as it is expensive. The garden is well fenced only if all the trees are enclosed. Your task is to help find the coordinates of trees which are exactly located on the fence perimeter.

Example 1:
Input: [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
Output: [[1,1],[2,0],[4,2],[3,3],[2,4]]
Explanation:

Example 2:
Input: [[1,2],[2,2],[4,2]]
Output: [[1,2],[2,2],[4,2]]
Explanation:

Even you only have trees in a line, you need to use rope to enclose them. 
Note:

All trees should be enclosed together. You cannot cut the rope to enclose trees that will separate them in more than one group.
All input integers will range from 0 to 100.
The garden has at least one tree.
All coordinates are distinct.
Input points have NO order. No order required for output.
 *
 */
public class ErecttheFence {

	public static void main(String[] args) {

	}
	
	public List<Point> outerTrees(Point[] points) {
      Set<Point> res = new HashSet<>();

		Point first = points[0];
		int firstIndex = 0;
		for (int i = 1; i < points.length; i++) {
			if (points[i].x < first.x) {
				first = points[i];
				firstIndex = i;
			}
		}

		res.add(first);

		// find next point from the current point. Do until we hit back our
		// current point
		Point cur = first;
		int curIndex = firstIndex;
		do {

			Point next = points[0];
			int nextIndex = 0;

			for (int i = 1; i < points.length; i++) {

				if (i == curIndex) {
					continue;
				}

				int cross = crossProduct(next, points[i], cur);
				if (nextIndex == curIndex || cross > 0
						|| (cross == 0 && distance(cur, points[i]) > distance(cur, next))) {
					next = points[i];
					nextIndex = i;
				}
			}
			for (int i = 0; i < points.length; i++) {

				if (i == curIndex) {
					continue;
				}
				int cross = crossProduct(cur, points[i], next);
				if (cross == 0) {
					res.add(points[i]);
				}

			}

			cur = next;
			curIndex = nextIndex;
		} while (curIndex != firstIndex);

		return new ArrayList<>(res);
  }
  
  int crossProduct(Point p1, Point p2, Point p3) {
		return ((p3.y - p2.y) * (p2.x - p1.x)) - ((p2.y - p1.y) * (p3.x - p2.x));
	}

	int distance(Point p1, Point p2) {
		return (p1.y - p2.y) * (p1.y - p2.y) + (p1.x - p2.x) * (p1.x - p2.x);
	}

}
