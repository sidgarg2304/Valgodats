package com.vishal.interviews.google.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 451. Sort Characters By Frequency
 * 
 * Given a string, sort it in decreasing order based on the frequency of
 * characters.
 * 
 * Example 1:
 * 
 * Input: "tree"
 * 
 * Output: "eert"
 * 
 * Explanation: 'e' appears twice while 'r' and 't' both appear once. So 'e'
 * must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 * 
 * Input: "cccaaa"
 * 
 * Output: "cccaaa"
 * 
 * Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a valid
 * answer. Note that "cacaca" is incorrect, as the same characters must be
 * together. Example 3:
 * 
 * Input: "Aabb"
 * 
 * Output: "bbAa"
 * 
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect. Note
 * that 'A' and 'a' are treated as two different characters.
 */
public class SortCharactersByFrequency {

	public static void main(String[] args) {

	}

	public String frequencySortSol1(String s) {
		if (s == null) {
			return null;
		}
		Map<Character, Integer> map = new HashMap();
		char[] charArray = s.toCharArray();
		int max = 0;
		for (Character c : charArray) {
			if (!map.containsKey(c)) {
				map.put(c, 0);
			}
			map.put(c, map.get(c) + 1);
			max = Math.max(max, map.get(c));
		}

		List<Character>[] array = buildArray(map, max);

		return buildString(array);
	}

	private List<Character>[] buildArray(Map<Character, Integer> map, int maxCount) {
		List<Character>[] array = new List[maxCount + 1];
		for (Character c : map.keySet()) {
			int count = map.get(c);
			if (array[count] == null) {
				array[count] = new ArrayList();
			}
			array[count].add(c);
		}
		return array;
	}

	private String buildString(List<Character>[] array) {
		StringBuilder sb = new StringBuilder();
		for (int i = array.length - 1; i > 0; i--) {
			List<Character> list = array[i];
			if (list != null) {
				for (Character c : list) {
					for (int j = 0; j < i; j++) {
						sb.append(c);
					}
				}
			}
		}
		return sb.toString();
	}

	/**
	 * Java O(n) Bucket Sort Solution / O(nlogn) PriorityQueue Solution, easy to
	 * understand The logic is very similar to NO.347 and here we just use a map
	 * a count and according to the frequency to put it into the right bucket.
	 * Then we go through the bucket to get the most frequently character and
	 * append that to the final stringbuilder.
	 */
	public String frequencySortUsingBucketSort(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		List<Character>[] bucket = new List[s.length() + 1];
		for (char key : map.keySet()) {
			int frequency = map.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}
		StringBuilder sb = new StringBuilder();
		for (int pos = bucket.length - 1; pos >= 0; pos--) {
			if (bucket[pos] != null) {
				for (char num : bucket[pos]) {
					for (int i = 0; i < map.get(num); i++) {
						sb.append(num);
					}
				}
			}
		}
		return sb.toString();
	}

	/**
	 * And we have normal way using PriorityQueue as follows:
	 * 
	 * @param s
	 * @return
	 */
	public String frequencySortUsingPriorityQueue(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
				new Comparator<Map.Entry<Character, Integer>>() {
					@Override
					public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
						return b.getValue() - a.getValue();
					}
				});
		pq.addAll(map.entrySet());
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			Map.Entry e = pq.poll();
			for (int i = 0; i < (int) e.getValue(); i++) {
				sb.append(e.getKey());
			}
		}
		return sb.toString();
	}

	/**
	 * Could not find a simpler way to do this. I see people are using
	 * HashMap/TreeMap which are not at all required. If you know bucket sort
	 * then following solution will be easy to understand!
	 * 
	 * @param s
	 * @return
	 */
	public String frequencySortUsingBucketSort2(String s) {
		if (s.length() < 3)
			return s;
		int max = 0;
		int[] map = new int[256];
		for (char ch : s.toCharArray()) {
			map[ch]++;
			max = Math.max(max, map[ch]);
		}
		String[] buckets = new String[max + 1]; // create max buckets
		for (int i = 0; i < 256; i++) { // join chars in the same bucket
			String str = buckets[map[i]];
			if (map[i] > 0)
				buckets[map[i]] = (str == null) ? "" + (char) i : (str + (char) i);
		}
		StringBuilder strb = new StringBuilder();
		for (int i = max; i >= 0; i--) { // create string for each bucket.
			if (buckets[i] != null)
				for (char ch : buckets[i].toCharArray())
					for (int j = 0; j < i; j++)
						strb.append(ch);
		}
		return strb.toString();
	}

}
