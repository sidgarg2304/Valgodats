package com.vishal.interviews.programcreek.math;

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

		int res = 0;

		for (int i = 0; i < points.length; i++) {
			Map<Double, Integer> map = new HashMap<>();
			int sameX = 0;
			int samePoint = 0;
			for (int j = 0; j < points.length; j++) {
				if (j == i) {
					continue;
				}

				if (points[i].x == points[j].x && points[i].y == points[j].y) {
					samePoint++;
				}

				if (points[i].x == points[j].x) {
					sameX++;
					continue;
				}

				double slope = (double) (points[j].y - points[i].y) / (double) (points[j].x - points[i].x);

				map.put(slope, map.getOrDefault(slope, 0) + 1);

				res = Math.max(res, map.get(slope) + samePoint);
			}
			res = Math.max(res, sameX);
		}
		return res;

	}
}
