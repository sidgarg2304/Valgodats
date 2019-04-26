package com.vishal.interviews.facebook.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpentheLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int openLock(String[] deadends, String target) {

		if (target == null || target.isEmpty()) {
			return -1;
		}

		Set<String> dead = new HashSet<>();
		for (String d : deadends) {
			dead.add(d);
		}

		Queue<String> queue = new LinkedList<>();
		queue.offer("0000");

		Set<String> seen = new HashSet<>();
		seen.add("0000");

		int depth = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				String cur = queue.poll();

				if (cur.equals(target)) {
					return depth;
				}

				if (!dead.contains(cur)) {
					for (int i = 0; i < 4; i++) {
						for (int d = -1; d <= 1; d += 2) {
							int newDigit = ((cur.charAt(i) - '0') + d + 10) % 10;
							String nei = cur.substring(0, i) + String.valueOf(newDigit) + cur.substring(i + 1);
							if (!seen.contains(nei)) {
								seen.add(nei);
								queue.offer(nei);
							}
						}
					}
				}
			}
			depth++;
		}

		return -1;
	}

}
