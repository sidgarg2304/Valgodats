package com.vishal.interviews.uber.hard;

import java.util.*;

public class MaxPointsonaLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxPoints(Point[] points) {
		
		if(points == null || points.length == 0) {
			return 0;
		}

		int res = 2;
		
		for (int i = 0; i < points.length; i++) {
			Point p = points[i];
			Map<Double, Integer> map = new HashMap<>();
			int samePoints = 0;
			int sameX = 0;
			int sameY = 0;
			for (int j = 0; j < points.length; j++) {
				Point q = points[j];

				if (p == q) {
					continue;
				}

				if (p.x == q.x && p.y == q.y) {
					samePoints++;
					continue;
				}

				if (p.x == q.x) {
					sameX++;
					continue;
				}

				if (p.y == q.y) {
					sameY++;
					continue;
				}

				double slope = (double) (q.x - p.x) / (q.y - p.y);

				map.put(slope, map.getOrDefault(slope, 0) + 1);

				res = Math.max(res, 1 + map.get(slope) + samePoints);
			}
			
			res = Math.max(res, 1 + samePoints + sameX);
			res = Math.max(res, 1 + samePoints + sameY);
			
		}
		
		return res;
	}

	class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
