package com.vishal.interviews.leetcodereremaining;

import java.util.*;

public class MinimumIndexSumofTwoLists {

	public static void main(String[] args) {

	}

	public String[] findRestaurant(String[] list1, String[] list2) {

		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < list1.length; i++) {
			map.put(list1[i], i);
		}

		List<String> res = new ArrayList<>();
		int minSum = Integer.MAX_VALUE;		
		for (int i = 0; i < list2.length; i++) {

			if (map.containsKey(list2[i])) {
				int indexSum = map.get(list2[i]) + i;
				if (indexSum < minSum) {
					res.clear();
					res.add(list2[i]);
					minSum = indexSum;
				} else if (indexSum == minSum) {
					res.add(list2[i]);
				}
			}
		}
				
		return res.toArray(new String[res.size()]);
	}

}
