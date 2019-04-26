package com.vishal.interviews.uber.hard;

public class ReachingPoints {

	public static void main(String[] args) {
		ReachingPoints r = new ReachingPoints();
		System.out.println(r.reachingPoints(1, 1, 3, 5));
		System.out.println(r.reachingPoints(1, 1, 2, 2));
	}

	public boolean reachingPoints(int sx, int sy, int tx, int ty) {
		if (sx == tx && sy == ty) {
			return true;
		}

		if (sx > tx || sy > ty) {
			return false;
		}

		return reachingPoints(sx, sx + sy, tx, ty) || reachingPoints(sx + sy, sy, tx, ty);
	}

}
