package com.vishal.interviews.google.medium;

import java.util.List;

/**
 * 469. Convex Polygon
 * 
 * Given a list of points that form a polygon when joined sequentially, find if
 * this polygon is convex (Convex polygon definition:
 * https://en.wikipedia.org/wiki/Convex_polygon).
 * 
 * Note:
 * 
 * 1. There are at least 3 and at most 10,000 points.
 * 
 * 2. Coordinates are in the range -10,000 to 10,000.
 * 
 * 3. You may assume the polygon formed by given points is always a simple
 * polygon (Simple polygon definition). In other words, we ensure that exactly
 * two edges intersect at each vertex, and that edges otherwise don't intersect
 * each other. Example 1:
 * 
 * [[0,0],[0,1],[1,1],[1,0]]
 * 
 * Answer: True
 * 
 * Explanation:
 * 
 * ...*******
 *
 * ...*.....*
 *
 * ...*.....*
 *
 * ...*******
 * 
 * Example 2:
 * 
 * ...*******
 * 
 * ...*.*...*
 *
 * ...*.....*
 *
 * ...*******
 * 
 * 
 * [[0,0],[0,10],[10,10],[10,0],[5,5]]
 * 
 * Answer: False
 * 
 * Explanation:
 */
public class ConvexPolygon {

	public static void main(String[] args) {

	}

	public boolean isConvexEasySolution(List<List<Integer>> points) {
		int flag = 0;
		for (int i = 0; i < points.size(); i++) {
			int angle = getAngle(points, i);
			if (angle == 0)
				continue;
			if (flag == 0)
				flag = angle > 0 ? 1 : -1;
			else if (flag > 0 != angle > 0)
				return false;
		}
		return true;
	}

	private int getAngle(List<List<Integer>> points, int i) {
		List<Integer> c = points.get(i % points.size());
		List<Integer> b = points.get((i + 1) % points.size());
		List<Integer> a = points.get((i + 2) % points.size());
		return (a.get(1) - b.get(1)) * (b.get(0) - c.get(0)) - (b.get(1) - c.get(1)) * (a.get(0) - b.get(0));
	}

}

/**
 * Beyond my knowledge... Java solution with in-line explanation
 * 
 * Well, I have to say that this problem is beyond my knowledge. @Ipeq1
 * and @zzg_zzm have explained how to solve this problem in their posts
 * https://discuss.leetcode.com/topic/70643/i-believe-this-time-it-s-far-beyond-
 * my-ability-to-get-a-good-grade-of-the-contest
 * https://discuss.leetcode.com/topic/70664/c-7-line-o-n-solution-to-check-
 * convexity-with-cross-product-of-adajcent-vectors-detailed-explanation The
 * algorithm itself is not hard but I have no idea there exists such a way to
 * determine if a polygon is convex or not. Laugh at me for my ignorance... I
 * believe 90% of programmers can solve this problem if they were given the
 * formula.
 * 
 * Anyway, following is the Java solution with in-line explanation. Accepted,
 * 32ms. Reference:
 * http://csharphelper.com/blog/2014/07/determine-whether-a-polygon-is-convex-in
 * -c/
 *
 * 
 */
class Solution {
	public boolean isConvex(List<List<Integer>> points) {
		// For each set of three adjacent points A, B, C, find the cross product
		// AB · BC. If the sign of
		// all the cross products is the same, the angles are all positive or
		// negative (depending on the
		// order in which we visit them) so the polygon is convex.
		boolean gotNegative = false;
		boolean gotPositive = false;
		int numPoints = points.size();
		int B, C;
		for (int A = 0; A < numPoints; A++) {
			// Trick to calc the last 3 points: n - 1, 0 and 1.
			B = (A + 1) % numPoints;
			C = (B + 1) % numPoints;

			int crossProduct = crossProductLength(points.get(A).get(0), points.get(A).get(1), points.get(B).get(0),
					points.get(B).get(1), points.get(C).get(0), points.get(C).get(1));
			if (crossProduct < 0) {
				gotNegative = true;
			} else if (crossProduct > 0) {
				gotPositive = true;
			}
			if (gotNegative && gotPositive)
				return false;
		}

		// If we got this far, the polygon is convex.
		return true;
	}

	// Return the cross product AB x BC.
	// The cross product is a vector perpendicular to AB and BC having length
	// |AB| * |BC| * Sin(theta) and
	// with direction given by the right-hand rule. For two vectors in the X-Y
	// plane, the result is a
	// vector with X and Y components 0 so the Z component gives the vector's
	// length and direction.
	private int crossProductLength(int Ax, int Ay, int Bx, int By, int Cx, int Cy) {
		// Get the vectors' coordinates.
		int BAx = Ax - Bx;
		int BAy = Ay - By;
		int BCx = Cx - Bx;
		int BCy = Cy - By;

		// Calculate the Z coordinate of the cross product.
		return (BAx * BCy - BAy * BCx);
	}
}
