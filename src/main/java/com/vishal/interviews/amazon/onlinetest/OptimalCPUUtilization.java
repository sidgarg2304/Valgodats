package com.vishal.interviews.amazon.onlinetest;

import java.util.*;

/**
 * 
 * https://cmis.aspiringminds.in/generateReports.php?data=YvxRSzV7xzokU5g9NBTMkRGO7LzG8gxGPTZcGIlEcG7vjtlHsO7J4jJuuMoVoOZnkyADM8YgKCZQJl7uZTXL0AtdqNYWUdsIj52Xnbt3IQWdz%2F5nusVUeaGiDjbkMc0n
 * 
 * 
 * Example 2: Input: deviceCapacity = 10 foregroundAppList = [[1, 3], [2, 5],
 * [3, 7], [4, 10]] backgroundAppList = [[1, 2], [2, 3], [3, 4], [4, 5]]
 * 
 * Output: [[2, 4], [3, 2]] There are two pairs of foreground and background
 * applications possible that optimally utilizes the given device. Application 2
 * from foregroundAppList uses 5 memory units, and application 4 from
 * backgroundAppList also uses 5 memory units. Combined, they add up to 10 units
 * of memory. Similarly, application 3 from foregroundAppList uses 7 memory
 * units, and application 2 from backgroundAppList uses 3 memory units. These
 * also add up to 10 units of memory. Therefore, the pairs of foreground and
 * background applications that optimally utilize the device are [2, 4] and [3,
 * 2].
 * 
 * @author vkotha
 *
 */
public class OptimalCPUUtilization {

	public static void main(String[] args) {
		List<List<Integer>> foregroundAppList = new ArrayList<>();

		List<Integer> fore1 = new ArrayList<>();
		fore1.add(1); // id
		fore1.add(3); // needed capacity

		List<Integer> fore2 = new ArrayList<>();
		fore2.add(2);
		fore2.add(5);

		List<Integer> fore3 = new ArrayList<>();
		fore3.add(3);
		fore3.add(7);

		List<Integer> fore4 = new ArrayList<>();
		fore4.add(4);
		fore4.add(10);

		foregroundAppList.add(fore1);
		foregroundAppList.add(fore2);
		foregroundAppList.add(fore3);
		foregroundAppList.add(fore4);

		List<List<Integer>> backgroundAppList = new ArrayList<>();
		
		List<Integer> back1 = new ArrayList<>();
		back1.add(1); // id
		back1.add(2);// needed capacity
		
		List<Integer> back2 = new ArrayList<>();
		back2.add(2); // id
		back2.add(3);// needed capacity
		
		List<Integer> back3 = new ArrayList<>();
		back3.add(3); // id
		back3.add(4);// needed capacity
		
		List<Integer> back4 = new ArrayList<>();
		back4.add(4); // id
		back4.add(5);// needed capacity
		
		backgroundAppList.add(back1);
		backgroundAppList.add(back2);
		backgroundAppList.add(back3);
		backgroundAppList.add(back4);

		System.out.println(optimalUtilization(10, foregroundAppList, backgroundAppList));

	}

	// input has taskid and it's capacity needed
	// find combinations between foreground and background ids which occupies
	// closest to deviceCapacity
	public static List<List<Integer>> optimalUtilization(int deviceCapacity, List<List<Integer>> foregroundAppList,
			List<List<Integer>> backgroundAppList) {

		Collections.sort(foregroundAppList, (a, b) -> a.get(1) - b.get(1));
		Collections.sort(backgroundAppList, (a, b) -> a.get(1) - b.get(1));

		Map<Integer, List<List<Integer>>> sumMap = new HashMap<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (List<Integer> f : foregroundAppList) {
			map.put(f.get(1), f.get(0));
		}
		
		for (List<Integer> b : backgroundAppList) {				
			for (int c = deviceCapacity; c >= 0; c--) {				
				if (map.containsKey(c - b.get(1))) {
					List<Integer> temp = new ArrayList<>();
					temp.add(map.get(c - b.get(1)));
					temp.add(b.get(0));
					if (!sumMap.containsKey(c)) {
						sumMap.put(c, new ArrayList<>());
					}
					sumMap.get(c).add(temp);					
					break;
				}
			}
		}

		for (int c = deviceCapacity; c >= 0; c--) {
			if (sumMap.containsKey(c)) {
				return sumMap.get(c);
			}
		}

		return new ArrayList<>();

	}

}
