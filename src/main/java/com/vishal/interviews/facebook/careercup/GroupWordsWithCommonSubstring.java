package com.vishal.interviews.facebook.careercup;

import java.util.*;

/**
 * Group a list of words so that the same group of words have a common substring, and this common substring is also in the word lists, 
example 
[cow "," cold "," an "," co "], return [[" can "," an "], [" cow "," cold "," co "]] 
["can", "cow", "cold"], return [["can"], ["cow"], ["cold"]] 
["c", "ca", "can"], return [["c", "ca", "can"]] 
 *
 */
public class GroupWordsWithCommonSubstring {

	public static void main(String[] args) {

		groupWords(new String[]{"cow", "cold", "can", "an", "co"});
		groupWords(new String[]{"can", "c", "ca"});
	}

	public static List<List<String>> groupWords(String[] s) {

		Set<String> set = new HashSet<>();
		for (String cur : s) {
			set.add(cur);
		}
		
		Map<String, List<String>> map = new HashMap<>();
		for (String cur : s) {
			for(int i = 0; i< cur.length(); i++){
				String left = cur.substring(0,i);
				String right = cur.substring(i);
				if(set.contains(left)){
					if(!map.containsKey(left)){
						map.put(left, new ArrayList<>());
					}
					map.get(left).add(cur);
				}
				
				if(set.contains(right)){
					if(!map.containsKey(right)){
						map.put(right, new ArrayList<>());
					}
					map.get(right).add(cur);
				}
			}
		}
		
		System.out.println(map);
		List<List<String>> res = new ArrayList<>();
		res.addAll(map.values());
		
		return res;
	}

}
