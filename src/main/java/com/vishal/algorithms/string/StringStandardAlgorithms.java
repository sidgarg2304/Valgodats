package com.vishal.algorithms.string;

import java.util.Arrays;
import java.util.HashSet;

public class StringStandardAlgorithms {

	public static void main(String[] args) {
//		computeKmpPrefixArray("acacabacacabacacac");
//		kmpSubstringSearch("abcxabcdabxabcdabcdabcy", "abcdabcy");
//		kmpSubstringSearch("abcda", "cd");
		
		lengthOfLongestSubstring("abcabcbb");
	}
	
	public static void lengthOfLongestSubstring(String s) {
	    if(s==null || s.length()==0)
	        return;
	 
	    HashSet<Character> set = new HashSet<Character>();
	 
	    int max=0;
	 
	    int i=0;
	    int start=0;
	    while(i<s.length()){
	        char c = s.charAt(i);
	        if(!set.add(c)){
	            max = Math.max(max, set.size());
	            while(start<i&&s.charAt(start)!=c){
	                set.remove(s.charAt(start));
	                start++;
	            }
	            start++;
	        }	 
	        i++;
	    }
	 
	    max = Math.max(max, set.size());
	 
	    System.out.println(max);
	}

	// abcxabcdabxabcdabcdabcy
	// abcdabcy
	public static void kmpSubstringSearch(String s, String pattern) {

		// construct prefix array for the pattern
		int[] t = computeKmpPrefixArray(pattern);

		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == pattern.charAt(j)) {
				if (j == pattern.length() - 1) {
					System.out.println(pattern + " found at index " + (i - j) + " of " + s);
					return;
				}
				j++;
			} else if (j > 0) {
				j = t[j - 1];
			}
		}

	}

	public static int[] computeKmpPrefixArray(String pattern) {
		int[] t = new int[pattern.length()];
		int j = 0;
		// j
		// a c a c a b a c a c a b a c a c a c
		// 0 0 1 2 3
		for (int i = 1; i < pattern.length(); i++) {
			if (pattern.charAt(i) == pattern.charAt(j)) {
				t[i] = ++j;
			} else if (j > 0) {
				j = t[j - 1];
				while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
					j = t[j - 1];
				}
				t[i] = (j == 0) ? 0 : j + 1;
			}
		}
		System.out.println("KMP Prefix Array for the pattern " + pattern + " is " + Arrays.toString(t));
		return t;
	}

}
