package com.vishal.interviews.uber.medium;

import java.util.*;

public class CourseSchedule {

	public static void main(String[] args) {

	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {

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
			coursesFinished++;
			for (int[] p : prerequisites) {
				if (p[1] == curCourse) {
					depCount[p[0]]--;
					if (depCount[p[0]] == 0) {
						queue.offer(p[0]);
					}
				}
			}
		}

		return coursesFinished == numCourses;
	}

}
