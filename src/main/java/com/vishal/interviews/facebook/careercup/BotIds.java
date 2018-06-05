package com.vishal.interviews.facebook.careercup;

import java.util.*;

/**
 * A bot is an id that visit the site m times in the last n seconds, given a
 * list of logs with id and time sorted by time, return all the bots's id
 */
public class BotIds {

	public static void main(String[] args) {

	}

	public Set<String> getBots(Log[] logs, int m, int n) {
		Set<String> set = new HashSet<>();

		Map<String, Integer> map = new HashMap<>();

		int h = logs.length - 1;
		int l = 0;
		long target = System.currentTimeMillis() - n;
		int start = -1;
		while (l <= h) {
			int mid = l + (h - l) / 2;
			if (logs[mid].time == target) {
				int f = mid;
				while (logs[f].time == target) {
					f--;
				}

				f++;
				start = f;
				break;
			} else if (logs[mid].time < target) {
				h = mid + 1;
			} else {
				l = mid - 1;
			}
		}
		
		for (int i = start; i < logs.length; i++) {
			map.put(logs[i].id, map.getOrDefault(logs[i].id, 0) + 1);
		}

		for (String id : map.keySet()) {
			if (map.get(id) == m) {
				set.add(id);
			}
		}
		return set;
	}
}

class Log {
	String id;
	int time;
}

// 10 - l1 -
// 10 - l2
// 10 - l3
// 10 - l4
// 10 - l5
// 11 - l1
