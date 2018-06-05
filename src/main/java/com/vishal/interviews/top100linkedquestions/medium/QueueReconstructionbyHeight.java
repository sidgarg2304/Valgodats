package com.vishal.interviews.top100linkedquestions.medium;

import java.util.*;

public class QueueReconstructionbyHeight {

	public static void main(String[] args) {

	}

	public int[][] reconstructQueue(int[][] people) {

		Arrays.sort(people, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] == b[0]) {
					return a[1] - b[1];
				}
				return b[0] - a[0];
			}
		});

		List<int[]> res = new ArrayList<>();

		for (int i = 0; i < people.length; i++) {
			res.set(people[i][1], people[i]);
		}
				
		for (int i = 0; i < people.length; i++) {
			people[i] = res.get(i);
		}
		return people;
	}

}
