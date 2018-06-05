package com.vishal.interviews.util;

public class Point {

	public int x;
	public int y;

	public Point() {
		x = 0;
		y = 0;
	}

	public Point(int a, int b) {
		x = a;
		y = b;
	}

	public boolean equals(Object o) {
		if (o instanceof Point) {
			Point p = (Point) o;
			return p.x == this.x && p.y == this.y;
		}
		return false;
	}
}
