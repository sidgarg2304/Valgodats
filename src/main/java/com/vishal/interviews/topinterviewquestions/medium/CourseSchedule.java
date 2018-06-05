package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

public class CourseSchedule {

	public static void main(String[] args) {

	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {

		if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
			return true;
		}

		int[] depCnt = new int[numCourses];
		for (int[] d : prerequisites) {
			depCnt[d[0]]++;
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < depCnt.length; i++) {
			if (depCnt[i] == 0) {
				queue.offer(i);
			}
		}

		int finishedCnt = 0;
		while (!queue.isEmpty()) {
			int finished = queue.poll();
			finishedCnt++;

			for (int[] d : prerequisites) {
				if (d[1] == finished) {
					depCnt[d[0]]--;
					if (depCnt[d[0]] == 0) {
						queue.offer(d[0]);
					}
				}
			}

		}

		return finishedCnt == numCourses;

	}

}
