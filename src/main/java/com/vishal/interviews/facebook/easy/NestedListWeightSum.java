package com.vishal.interviews.facebook.easy;

import java.util.*;

import com.vishal.interviews.util.NestedInteger;

public class NestedListWeightSum {

	public static void main(String[] args) {

	}

	public int depthSum(List<NestedInteger> nestedList) {

		if (nestedList == null || nestedList.size() == 0) {
			return 0;
		}
		Queue<NestedInteger> queue = new LinkedList<>();

		for (NestedInteger n : nestedList) {
			queue.offer(n);
		}

		int res = 0;
		int depth = 1;
		while (queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				NestedInteger cur = queue.poll();
				if (cur.isInteger()) {
					res += depth * cur.getInteger();
				} else {
					for (NestedInteger n : cur.getList()) {
						queue.offer(n);
					}
				}
			}
			depth++;
		}
		return res;
	}
}
