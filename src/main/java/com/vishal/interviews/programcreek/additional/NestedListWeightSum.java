package com.vishal.interviews.programcreek.additional;

import java.util.*;

import com.vishal.interviews.util.NestedInteger;

public class NestedListWeightSum {

	public static void main(String[] args) {

	}

	public int depthSum(List<NestedInteger> nestedList) {
		Queue<NestedInteger> queue = new LinkedList<>();

		for (NestedInteger n : nestedList) {
			queue.offer(n);
		}

		int res = 0;
		int level = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				NestedInteger cur = queue.poll();
				if (cur.isInteger()) {
					res += cur.val * level;
				} else {
					for (NestedInteger n : cur.nestedIntegers) {
						queue.offer(n);
					}
				}
			}
			level++;
		}

		return res;
	}

}
