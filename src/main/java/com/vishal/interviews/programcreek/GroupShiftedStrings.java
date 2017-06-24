package com.vishal.interviews.programcreek;

import java.util.*;

public class GroupShiftedStrings {

	public static void main(String[] args) {

	}

	public List<List<String>> groupStrings(String[] strings) {
		List<List<String>> res = new ArrayList<>();

		Map<String, List<String>> map = new HashMap<>();

		for (String s : strings) {
			int diff = s.charAt(0) - 'a';
			char[] arr = s.toCharArray();
			for (int j = 0; j < arr.length; j++) {
				arr[j] -= diff;
				if (arr[j] < 'a') {
					arr[j] += 26;
				}

				String shifted = String.valueOf(arr);
				if (!map.containsKey(shifted)) {
					map.put(shifted, new ArrayList<>());
				}

				map.get(shifted).add(s);
			}
		}

		res.addAll(map.values());
		return res;
	}

}
