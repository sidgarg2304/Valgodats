package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

public class CourseScheduleII {

	public static void main(String[] args) {

	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] res = new int[numCourses];

		int[] count = new int[numCourses];
		for (int pre[] : prerequisites) {
			count[pre[0]]++;
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < count.length; i++) {
			if (count[i] == 0) {
				queue.offer(i);
			}
		}

		int i = 0;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			res[i++] = cur;

			for (int pre[] : prerequisites) {
				if (pre[1] == cur) {
					count[pre[0]]--;

					if (count[pre[0]] == 0) {
						queue.offer(pre[0]);
					}
				}
			}
		}

		if (i < numCourses) {
			return new int[] {};
		}
		return res;
	}

}
