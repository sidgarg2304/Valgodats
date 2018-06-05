package com.vishal.interviews.top100linkedquestions.medium;

import java.util.*;

public class CourseSchedule {

	public static void main(String[] args) {

	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (prerequisites == null || prerequisites.length == 0 || numCourses == 1) {
			return true;
		}

		int[] depCnt = new int[numCourses];
		for (int[] p : prerequisites) {
			depCnt[p[0]]++;
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (depCnt[i] == 0) {
				queue.offer(i);
			}
		}

		int numFinished = 0;
		while (!queue.isEmpty()) {
			int c = queue.poll();
			numFinished++;
			for (int[] p : prerequisites) {
				if (p[1] == c) {
					depCnt[p[0]]--;
					if (depCnt[p[0]] == 0) {
						queue.offer(p[0]);
					}
				}
			}
		}

		return numFinished == numCourses;
	}

}
