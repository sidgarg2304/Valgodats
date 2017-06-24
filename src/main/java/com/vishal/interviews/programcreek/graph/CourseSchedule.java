package com.vishal.interviews.programcreek.graph;

import java.util.*;

public class CourseSchedule {

	public static void main(String[] args) {

	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {

		if (numCourses <= 1 || prerequisites == null || prerequisites.length == 0) {
			return true;
		}

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

		int coursesFinished = 0;
		while (!queue.isEmpty()) {
			int course = queue.poll();
			coursesFinished++;

			for (int[] pre : prerequisites) {
				if (pre[1] == course) {
					depCount[pre[0]]--;
					if (depCount[pre[0]] == 0) {
						queue.offer(pre[0]);
					}
				}
			}
		}
		
		return coursesFinished == numCourses;
	}

}
