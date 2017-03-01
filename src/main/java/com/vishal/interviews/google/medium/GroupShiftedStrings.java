package com.vishal.interviews.google.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given a string, we can "shift" each of its letter to its successive letter,
 * for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 * 
 * "abc" -> "bcd" -> ... -> "xyz"
 * 
 * Given a list of strings which contains only lowercase alphabets, group all
 * strings that belong to the same shifting sequence.
 * 
 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 * 
 * A solution is:
 * 
 * [
 * 
 * ["abc","bcd","xyz"],
 * 
 * ["az","ba"],
 * 
 * ["acef"],
 * 
 * ["a","z"]
 * 
 * ]*
 */
public class GroupShiftedStrings {

	public static void main(String[] args) {

	}

	public List<List<String>> groupStringsConcise(String[] strings) {
		List<List<String>> result = new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strings) {
			int offset = str.charAt(0) - 'a';
			String key = "";
			for (int i = 0; i < str.length(); i++) {
				char c = (char) (str.charAt(i) - offset);
				if (c < 'a') {
					c += 26;
				}
				key += c;
			}
			if (!map.containsKey(key)) {
				List<String> list = new ArrayList<String>();
				map.put(key, list);
			}
			map.get(key).add(str);
		}
		for (String key : map.keySet()) {
			List<String> list = map.get(key);
			Collections.sort(list);
			result.add(list);
		}
		return result;
	}

	/**
	 * Concise 10-lines JAVA Solution with explanation
	 * 
	 * Explanation
	 * 
	 * The basic idea is to set a key for each group: the sum of the difference
	 * between the adjacent chars in one string. Then we can easily group the
	 * strings belonging to the same shifting sequence with the same key. The
	 * code is as the following:
	 * 
	 * @param strs
	 * @return
	 */
	public List<List<String>> groupStringsConciseSolution2(String[] strs) {
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		Arrays.sort(strs);
		for (String s : strs) {
			String key = "";
			for (int i = 1; i < s.length(); i++)
				key += String.format("%2d", (s.charAt(i) - s.charAt(i - 1) + 26) % 26);// Difference
																											  // from
																											  // the
																											  // previous
																											  // char.
			if (!map.containsKey(key))
				map.put(key, new ArrayList<String>());
			map.get(key).add(s);
		}
		return new ArrayList<List<String>>(map.values());
	}

	/**
	 * Not sure I did it as good as it can be, as I'm still a beginner at Java
	 * streaming. If you can improve this, I'll be happy to see how.
	 * 
	 * 
	 * @param strings
	 * @return
	 */
	public List<List<String>> groupStringsUsingStream(String[] strings) {
		return new ArrayList<List<String>>(Stream.of(strings)
				.collect(Collectors
						.groupingBy(s -> s.chars().mapToObj(c -> (c - s.charAt(0) + 26) % 26).collect(Collectors.toList())))
				.values());
	}

}
