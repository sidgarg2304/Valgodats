package com.vishal.interviews.uber.medium;

import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {

	public static void main(String[] args) {

	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {

		int[] res = new int[numCourses];
		int[] depCount = new int[numCourses];

		for (int[] p : prerequisites) {
			depCount[p[0]]++;
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < depCount.length; i++) {
			if (depCount[i] == 0) {
				queue.offer(i);
			}
		}

		int coursesFinished = 0;
		while (!queue.isEmpty()) {
			int curCourse = queue.poll();
			res[coursesFinished++] = curCourse;
			for (int[] p : prerequisites) {
				if (p[1] == curCourse) {
					depCount[p[0]]--;
					if (depCount[p[0]] == 0) {
						queue.offer(p[0]);
					}
				}
			}
		}

		if (coursesFinished == numCourses) {
			return res;
		}
		return new int[] {};
	}

}
