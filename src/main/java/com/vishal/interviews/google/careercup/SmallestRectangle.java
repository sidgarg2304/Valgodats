package com.vishal.interviews.google.careercup;

import java.util.*;

import com.vishal.interviews.util.Point;

public class SmallestRectangle {

	public static void main(String[] args) {

	}

	int smallestRectangle(Point[] points) {
		Set<String> set = new HashSet<>();
		for (Point p : points) {
			set.add("" + p.x + "-" + p.y);
		}

		int res = Integer.MAX_VALUE;
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				int x1 = points[i].x;
				int y1 = points[i].y;
				int x2 = points[i].x;
				int y2 = points[i].x;

				if (set.contains("" + x1 + "-" + y2) && set.contains("" + x2 + "-" + y1)) {
					res = Math.min(res, (x2 - x1) * (y2 - y1));
				}
			}
		}
		return res;
	}

}
