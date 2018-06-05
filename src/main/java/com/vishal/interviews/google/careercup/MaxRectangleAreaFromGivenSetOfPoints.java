package com.vishal.interviews.google.careercup;

/**
 * Given a set of co-ordinates x1,y1 and x2, y2 such they they along with x-axis
 * would form a rectangle having height as min(y1,y2) and width as x2-x1
 * 
 * Assume input is sorted with x coordinates
 * 
 * (2,3), (7,6), (9,5), (14,2)
 * 
 * output is 24
 *
 */
public class MaxRectangleAreaFromGivenSetOfPoints {

	public static void main(String[] args) {

		System.out.println(maxArea(new int[][] { { 2, 3 }, { 7, 6 }, { 9, 5 }, { 14, 2 } }));
	}

	static int maxArea(int[][] points) {
		int i = 0;
		int j = points.length - 1;

		int max = 0;
		while (i < j) {
			int area = (points[j][0] - points[i][0]) * (Math.min(points[j][1], points[i][1]));

			max = Math.max(area, max);

			if (points[i][1] < points[j][1]) {
				i++;
			} else {
				j--;
			}
		}

		return max;
	}

}
