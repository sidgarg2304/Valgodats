package com.vishal.interviews.programcreek.graph;

import java.util.*;

public class CourseScheduleII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		if (prerequisites == null) {
			throw new IllegalArgumentException("illegal prerequisites array");
		}

		int[] res = new int[numCourses];

		int[] depCount = new int[numCourses];

		for (int[] pre : prerequisites) {
			depCount[pre[0]]++;
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (depCount[i] == 0) {
				queue.offer(i);
			}
		}

		int r = 0;
		while (!queue.isEmpty()) {
			int course = queue.poll();
			res[r++] = course;

			for (int[] pre : prerequisites) {
				if (pre[1] == course) {
					depCount[pre[0]]--;
					if (depCount[pre[0]] == 0) {
						queue.offer(pre[0]);
					}
				}
			}
		}

		if (r == numCourses) {
			return res;
		}
		return new int[] {};

	}

}
