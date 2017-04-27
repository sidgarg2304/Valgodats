package com.vishal.interviews.linkedin.medium;

import java.util.*;
/**
 * 187. Repeated DNA Sequences
 * 
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
 */
public class RepeatedDNASequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static List<String> repeatedSequences(String s){
		Map<Character, Integer> map = new HashMap<>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);
		
		List<String> res = new ArrayList<>();
		
		Set<Integer> hashes = new HashSet<>(); // to track if we found a dup
		Set<Integer> hashesAdded = new HashSet<>(); // to track if we have not already added to result
		
		for(int i = 0; i< s.length()-9; i++){
			int hash = 0;
			for(int j = i; j< i+10; j++){
				hash <<=2;
				hash |= map.get(s.charAt(j));
			}
			
			if(!hashes.add(hash) && hashesAdded.add(hash)){
				res.add(s.substring(i, i+10));
			}
		}
		
		return res;
	}

}
