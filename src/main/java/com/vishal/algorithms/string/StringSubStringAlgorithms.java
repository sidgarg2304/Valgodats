package com.vishal.algorithms.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StringSubStringAlgorithms {

	public static void main(String[] args) {
		List<Character> dictionary = new ArrayList<Character>();
		dictionary.add('a');
		dictionary.add('b');
		// dictionary.add('a');
		// findIndicesWithCombinationOfGivenChars("abbaaba", dictionary); //
		// {0,2,4,5}
		// shortestSubStrLengthWithAllChars("ADOBECODEBANC", "ABC");

		// longestCommonPrefx(new String[] { "abc", "abcd", "abcf", "abe" });

		testLongestSubstringWithoutRepeatingCharacters();
		testLongestSubStringWithKUniqueCharacters();
		testshortestSubstringWithAllGivenCharacters();
		
		System.out.println(maxSlidingWindow(new int []{4,2,1,3,7,9}, 3));

	}

	public static void testLongestSubstringWithoutRepeatingCharacters() {

		longestSubstringWithoutRepeatingCharacters("abcadebf"); // 5

	}

	public static void testLongestSubStringWithKUniqueCharacters() {
		longestSubStringWithKUniqueCharacters("abccb", 2); // 4
	}

	public static void testshortestSubstringWithAllGivenCharacters() {
		shortestSubstringWithAllGivenCharacters("ADOBECODEBANC", "ABC"); // 4
	}
	
	public static List<Integer> maxSlidingWindow(int[] nums, int k) {	    
	 
	    List<Integer> result = new ArrayList<>();
	    
	    if(nums==null||nums.length==0)
	        return result;
	    
	    LinkedList<Integer> queue = new LinkedList<>();
	    for(int i = 0; i< nums.length; i++){
	   	 
	   	 if(!queue.isEmpty() && queue.peekFirst() == i -k){
	   		 queue.poll();
	   	 }
	   	 
	   	 while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
	   		 queue.removeLast();
	   	 }
	   	 
	   	 queue.offer(i);
	   	 
	   	 if(i + 1 >= k){
	   		 result.add(nums[queue.peek()]);
	   	 }
	   	 
	    }
	    
	 
	    return result;
	}

	/**
	 * Longest SubString without repeating characters We can just use hashset to
	 * maintain non duplicate characters and keep removing when we know that we
	 * are about to insert a duplicate character
	 * 
	 * @param s
	 */
	public static int longestSubstringWithoutRepeatingCharacters(String s) {

		Set<Character> set = new HashSet<>();

		int st = 0;
		int maxLength = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!set.add(c)) {
				// you have found a duplicate
				maxLength = Math.max(maxLength, (i - st));

				// Keep removing chars from start position until you hit current
				// char.
				// This would help us to prepare our next possible string
				while (!set.isEmpty() && s.charAt(st) == c) {
					set.remove(s.charAt(st));
					st++;

				}
			}
		}
		maxLength = Math.max(maxLength, (s.length() - 1 - st));
		System.out.println("longest substring without repeating characters is " + maxLength);
		return maxLength;
	}

	/**
	 * Longest substring with k unique characters Since we need to keep track of
	 * number of unique characters and number of times each character has
	 * occurred, we use HashMap
	 * 
	 * @param s
	 * @param k
	 */
	public static int longestSubStringWithKUniqueCharacters(String s, int k) {
		int maxSubStrLen = 0;
		int j = 0; // j to track where we started

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}

			if (map.size() > k) {
				maxSubStrLen = Math.max(maxSubStrLen, i - j);
				while (map.size() > k) {
					char dupChar = s.charAt(j);
					int dupCharCount = map.get(dupChar);
					if (dupCharCount == 1) {
						map.remove(dupChar);
					} else {
						map.put(dupChar, dupCharCount - 1);
					}
					j++;
				}
			}
		}
		maxSubStrLen = Math.max(maxSubStrLen, s.length() - j);
		System.out.println("Linges Substring with " + k + " unique characters is " + maxSubStrLen);

		return maxSubStrLen;
	}

	//shortestSubstringWithAllGivenCharacters("ADOBECODEBANC", "ABC"); // 4
	public static void shortestSubstringWithAllGivenCharacters(String s, String win) {

		Map<Character, Integer> dictionaryMap = new HashMap<Character, Integer>();
		for (int i = 0; i < win.length(); i++) {
			char c = win.charAt(i);
			if (dictionaryMap.containsKey(c)) {
				dictionaryMap.put(c, dictionaryMap.get(c) + 1);
			} else {
				dictionaryMap.put(c, 1);
			}
		}

		int minLen = Integer.MAX_VALUE;
		Map<Character, Integer> map = new HashMap<>();
		int st = 0;
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (dictionaryMap.containsKey(c)) {
				if (map.containsKey(c)) {
					if (map.get(c) < dictionaryMap.get(c)) {
						count++;
					}
					map.put(c, map.get(c) + 1);
				} else {
					map.put(c, 1);
					count++;
				}

			}

			if (count == win.length()) {

				char stChar = s.charAt(st);
				while (!dictionaryMap.containsKey(stChar) || map.get(stChar) > dictionaryMap.get(stChar)) {
					if (map.containsKey(stChar) && map.get(stChar) > dictionaryMap.get(stChar)) {
						map.put(stChar, map.get(stChar) - 1);
					}
					st++;
					stChar = s.charAt(st);
				}
				minLen = Math.min(minLen, (i - st + 1));
			}

		}

		System.out.println("shortestSubstringWithAllGivenCharacters is " + minLen);

	}

	// {a,b,a}
	// abacbaacabadbaa
	// result = {0, 4, 8, 12}
	public static void findIndicesWithCombinationOfGivenChars(String s, List<Character> dictionary) {

		int dicLen = dictionary.size();
		List<Integer> resultStartPositions = new ArrayList<>();
		Map<Character, Integer> dictionaryMap = new HashMap<>();

		for (Character c : dictionary) {
			if (dictionaryMap.containsKey(c)) {
				dictionaryMap.put(c, dictionaryMap.get(c) + 1);
			} else {
				dictionaryMap.put(c, 1);
			}
		}

		int st = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int count = 0;
		for (int j = 0; j < s.length(); j++) {
			char c = s.charAt(j);
			// if char present in dictionary
			if (dictionaryMap.containsKey(c)) {
				if (map.containsKey(c)) {
					map.put(c, map.get(c) + 1);
				} else {
					map.put(c, 1);
				}
				count++;

				while (map.get(c) > dictionaryMap.get(c)) {
					char dupChar = s.charAt(st);
					int dupCount = map.get(dupChar);
					if (dupCount == 1) {
						map.remove(dupChar);
					} else {
						map.put(dupChar, dupCount - 1);
					}
					count--;
					st++;
				}

				// We have exact same number of dicLen
				if (count == dicLen) {
					resultStartPositions.add(st);
					char processedChar = s.charAt(st);
					map.put(processedChar, map.get(processedChar) - 1);
					count--;
					st++;
				}
			} else {
				map.clear();
				count = 0;
				st = j + 1;
			}

		}
		System.out.println("start positions are " + resultStartPositions);

	}

	/**
	 * Find the smallest string and then compare each character of this string
	 * with all other strings at same position until u hit a non matching
	 * character
	 * 
	 * @param strs
	 */
	public static void longestCommonPrefx(String[] strs) {
		int minLength = -1;

		String minLenStr = strs[0];
		for (String s : strs) {
			if (s.length() < minLength) {
				minLength = s.length();
				minLenStr = s;
			}
		}

		StringBuilder res = new StringBuilder();
		for (int i = 0; i < minLenStr.length(); i++) {
			char c = minLenStr.charAt(i);
			for (int j = 0; j < strs.length; j++) {
				if (strs[j].charAt(i) != c) {
					System.out.println("longest common prefix among the given strings " + Arrays.toString(strs) + " is "
							+ res.toString());
					return;
				}
			}
			res.append(c);
		}

		System.out.println(
				"longest common prefix among the given strings " + Arrays.toString(strs) + " is " + res.toString());
	}

}
