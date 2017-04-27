package com.vishal.interviews.linkedin.hard;

import java.util.*;

import com.vishal.interviews.linkedin.util.Point;
/**
 * 149. Max Points on a Line
 * 
 * 
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
public class MaxPointsonaLine {

	public static void main(String[] args) {

	}
	
	static int maxPoints(List<Point> points) {

		int res = Integer.MIN_VALUE;

		for (int i = 0; i < points.size(); i++) {
			Point p = points.get(i);
			int samePoint = 0;
			int sameX = 1;
			Map<Double, Integer> map = new HashMap<>();
			for (int j = 0; j < points.size(); j++) {
				Point q = points.get(j);

				if (p.equals(q)) {
					samePoint++;
				}

				if (p.x == q.x) {
					sameX++;
					continue;
				}

				double slope = (double) (p.y - q.y) / (double) (p.x - q.x);
				map.put(slope, map.getOrDefault(slope, 1) + 1);

				res = Math.max(res, map.get(slope) + samePoint);
			}

			res = Math.max(res, sameX);
		}

		return res;

	}

}
