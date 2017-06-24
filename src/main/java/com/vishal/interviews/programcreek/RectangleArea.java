package com.vishal.interviews.programcreek;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane. Each
 * rectangle is defined by its bottom left corner and top right corner
 * coordinates.
 * 
 * Analysis
 * 
 * This problem can be converted as a overlap internal problem. On the x-axis,
 * there are (A,C) and (E,G); on the y-axis, there are (F,H) and (B,D). If they
 * do not have overlap, the total area is the sum of 2 rectangle areas. If they
 * have overlap, the total area should minus the overlap area.
 * 
 * rectangle-area
 *
 * 
 */
public class RectangleArea {

	public static void main(String[] args) {

	}

	// public int computeArea(int A, int B, int C, int D, int E, int F, int G,
	// int H) {
	public int computeArea(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {

		int rect1Area = (x2 - x1) * (y2 - y1);
		int rect2Area = (x4 - x3) * (y4 - y3);
		int totalArea = rect1Area + rect2Area;

		if (x3 > x2 || x4 < x1 || y3 > y2 || y4 < y1) {
			return totalArea;
		}		

		int lowX = Math.max(x1, x3);
		int highX = Math.min(x4, x2);

		int lowY = Math.max(y1, y3);
		int highY = Math.min(y4, y2);

		return totalArea - ((highX - lowX) * (highY - lowY));

	}
}
