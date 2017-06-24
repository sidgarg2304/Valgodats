package com.vishal.interviews.programcreek;

import java.util.*;

/**
 * Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note: Could you optimize your algorithm to use only O(k) extra space?
 *
 */
public class PascalsTriangleII {

	public static void main(String[] args) {

		System.out.println(getRow(4));
	}

	public static List<Integer> getRow(int rowIndex) {

		List<Integer> res = new ArrayList<>();

		if (rowIndex == 0) {
			return res;
		}

		res.add(1);
		for (int i = 0; i < rowIndex; i++) {
			for (int j = res.size() - 2; j >= 0; j--) {
				res.set(j + 1, res.get(j) + res.get(j + 1));
			}
			res.add(1);
		}

		return res;
	}
}
