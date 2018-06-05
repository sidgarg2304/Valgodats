package com.vishal.interviews.topinterviewquestions.hard;

import java.util.*;

import com.vishal.interviews.util.Point;

public class MaxPointsonaLine {

	public static void main(String[] args) {

	}

	public int maxPoints(Point[] points) {

		if (points == null || points.length == 0) {
			return 0;
		}

		if (points.length <= 2) {
			return points.length;
		}

		int res = 2;
		for (int i = 0; i < points.length; i++) {
			Map<Double, Integer> map = new HashMap<>();
			int samePoints = 0;
			int sameX = 0;

			for (int j = 0; j < points.length; j++) {
				if (i == j) {
					continue;
				}

				if (points[i].x == points[j].x && points[i].y == points[j].y) {					
					samePoints++;
					res = Math.max(res, samePoints);
					continue;
				}

				if (points[i].x == points[j].x) {
					sameX++;
					continue;
				}

				double slope = (points[j].y - points[i].y) / (points[j].x - points[i].x);				
				map.put(slope, map.getOrDefault(slope, 0) + 1);
				res = Math.max(res, map.get(slope));
			}
						
			res = Math.max(res, sameX);
		}
		
		return res;
	}

}
