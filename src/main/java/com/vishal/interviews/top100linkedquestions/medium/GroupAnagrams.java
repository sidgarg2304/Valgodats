package com.vishal.interviews.top100linkedquestions.medium;

import java.util.*;
public class GroupAnagrams {

	public static void main(String[] args) {

	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
      List<List<String>> res = new ArrayList<>();

		if (strs == null || strs.length == 0) {
			return res;
		}
		
		Map<String, List<String>> map = new HashMap<>();
		for(String s: strs){
			char [] arr = s.toCharArray();
			Arrays.sort(arr);
			String sortedS = String.valueOf(arr);
			if(!map.containsKey(sortedS)){
				map.put(sortedS, new ArrayList<>());
			}
			map.get(sortedS).add(s);
		}
		
		res.addAll(map.values());
		
		return res;
		
	}

}
