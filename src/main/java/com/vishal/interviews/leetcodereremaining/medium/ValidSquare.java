package com.vishal.interviews.leetcodereremaining.medium;

import java.util.*;

public class ValidSquare {

	public static void main(String[] args) {

	}

	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

		Set<Integer> lengths = new HashSet<>();
		lengths.add(dist(p1, p2));
		lengths.add(dist(p1, p3));
		lengths.add(dist(p1, p4));
		lengths.add(dist(p2, p3));
		lengths.add(dist(p2, p4));
		lengths.add(dist(p3, p4));

		if (!lengths.contains(0) && lengths.size() == 2) {
			return true;
		}

		return false;
	}

	int dist(int[] p1, int[] p2) {
		int xDiff = p1[0] - p2[0];
		int yDiff = p1[1] - p2[1];

		return ((xDiff * xDiff) + (yDiff * yDiff));
	}
}
