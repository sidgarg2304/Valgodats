package com.vishal.interviews.facebook.medium;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {

		if (prerequisites == null || prerequisites.length == 0) {
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

		int finishedCourses = 0;
		while (!queue.isEmpty()) {
			int curCourse = queue.poll();
			finishedCourses++;
			for (int[] p : prerequisites) {
				if (p[1] == curCourse) {
					depCnt[p[0]]--;
					if (depCnt[p[0]] == 0) {
						queue.offer(p[0]);
					}
				}
			}
		}

		return finishedCourses == numCourses;
	}

}
