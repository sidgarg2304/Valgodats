package com.vishal.interviews.google.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/**
 * 356. Line Reflection
 * 
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis
 * that reflect the given points.
 * 
 * Example 1:
 * 
 * Given points = [[1,1],[-1,1]], return true.
 * 
 * Example 2:
 * 
 * Given points = [[1,1],[-1,-1]], return false.
 * 
 * Follow up:
 * 
 * Could you do better than O(n2)?
 * 
 * Hint:
 * 
 * 1. Find the smallest and largest x-value for all points.
 * 
 * 2. If there is a line then it should be at y = (minX + maxX) / 2.
 * 
 * 3. For each point, make sure that it has a reflected point in the opposite
 * side.
 * 
 */
public class LineReflection {

	public static void main(String[] args) {
	}

	public boolean isReflectedSimpleHashSet(int[][] points) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		HashSet<String> set = new HashSet<>();
		for (int[] p : points) {
			max = Math.max(max, p[0]);
			min = Math.min(min, p[0]);
			String str = p[0] + "a" + p[1];
			set.add(str);
		}
		int sum = max + min;
		for (int[] p : points) {
			// int[] arr = {sum-p[0],p[1]};
			String str = (sum - p[0]) + "a" + p[1];
			if (!set.contains(str))
				return false;

		}
		return true;
	}

}

/**
 * 8ms Java. No hash, just sort. O(1) space
 * 
 * The trick is in comparator.
 * 
 */
class LineReflectionSorting {
	int mid = 0;

	public boolean isReflected(int[][] points) {
		if (points.length <= 1)
			return true;
		int min = points[0][0];
		int max = points[0][0];
		for (int[] p : points) {
			min = Math.min(min, p[0]);
			max = Math.max(max, p[0]);
		}
		mid = (min + max) / 2;

		Arrays.sort(points, new myCompare());

		int left = 0, right = points.length - 1;
		while (left <= right) {
			if ((points[left][0] - min) != (max - points[right][0]))
				return false;
			if (points[left][0] == points[right][0])
				return true;
			if (points[left][1] != points[right][1])
				return false;
			++left;
			--right;
		}
		return true;
	}

	public class myCompare implements Comparator<int[]> {
		@Override
		public int compare(int[] p1, int[] p2) {
			if (p1[0] != p2[0])
				return Integer.compare(p1[0], p2[0]);
			if (p1[0] <= mid)
				return Integer.compare(p1[1], p2[1]);
			return Integer.compare(p2[1], p1[1]);
		}
	}
}

/**
 * 11ms two-pass HashSet-based Java Solution The idea is quite simple. If there
 * exists a line reflecting the points, then each pair of symmetric points will
 * have their x coordinates adding up to the same value, including the pair with
 * the maximum and minimum x coordinates. So, in the first pass, I iterate
 * through the array, adding each point to the hash set, and keeping record of
 * the minimum and maximum x coordinates. Then, in the second pass, I check for
 * every point to the left of the reflecting line, if its symmetric point is in
 * the point set or not. If all points pass the test, then there exists a
 * reflecting line. Otherwise, not.
 * 
 * By the way, here, to hash the content of an array, rather than the reference
 * value, I use Arrays.hashCode(int[]) first, and then re-hash this hash code.
 * You can also use Arrays.toString(int[]) to first convey the 2d array to a
 * string, and then hash the string. But the second method is slower.
 */
class LineReflectionTwoPassHashSet {
	public boolean isReflected(int[][] points) {
		HashSet<Integer> pointSet = new HashSet<>();
		int sum;
		int maxX, minX;

		minX = Integer.MAX_VALUE;
		maxX = Integer.MIN_VALUE;
		for (int[] point : points) {
			maxX = Math.max(maxX, point[0]);
			minX = Math.min(minX, point[0]);
			pointSet.add(Arrays.hashCode(point));
		}

		sum = maxX + minX;
		for (int[] point : points) {
			if (!pointSet.contains(Arrays.hashCode(new int[] { sum - point[0], point[1] }))) {
				return false;
			}
		}
		return true;
	}
}