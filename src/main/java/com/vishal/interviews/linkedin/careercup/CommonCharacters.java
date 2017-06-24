package com.vishal.interviews.linkedin.careercup;

import java.util.*;

public class CommonCharacters {

	public static void main(String[] args) {

		System.out.println(commonCharactersCount(new String[] { "aghkafgklt", "dfghako", "qwemnaarkf" }));
	}

	static int commonCharactersCount(String[] strings) {
		Map<Character, Integer> map = new HashMap<>();

		for (String s : strings) {
			Set<Character> set = new HashSet<>();
			for (char a : s.toCharArray()) {
				set.add(a);
			}
			
			for(Character a: set){
				map.put(a, map.getOrDefault(a, 0) + 1);
			}
		}

		int res = 0;		
		for (char a : map.keySet()) {
			if (map.get(a) == strings.length) {
				res++;
			}
		}
		return res;
	}

}
