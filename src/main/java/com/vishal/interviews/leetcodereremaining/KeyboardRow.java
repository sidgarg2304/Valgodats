package com.vishal.interviews.leetcodereremaining;

import java.util.*;

public class KeyboardRow {

	public static void main(String[] args) {

	}

	public String[] findWords(String[] words) {

		if (words == null || words.length == 0) {
			return words;
		}

		Map<Character, Integer> map = new HashMap<>();
		String[] strs = { "QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM" };
		for (int i = 0; i < strs.length; i++) {
			for (int j = 0; j < strs[i].length(); j++) {
				map.put(strs[i].charAt(j), i);
			}
		}
		
		List<String> res = new ArrayList<>();
		for(String w: words){
			if(w.equals("")){
				continue;
			}
						
			int index = map.get(w.toUpperCase().charAt(0));
			for(char c: w.toUpperCase().toCharArray()){
				if(map.get(c) != index){
					index = -1;
				}
			}
			
			if(index != -1){
				res.add(w);
			}
		}
		
		return res.toArray(new String[0]);
	}

}
