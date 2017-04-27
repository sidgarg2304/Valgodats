package com.vishal.interviews.linkedin.medium;

import java.util.List;

/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class ShortestWordDistance {

	public static void main(String[] args) {

	}
	
	static int shortestDistance(String[] words, String word1, String word2){
		
		int p1 = -1;
		int p2 = -1;
		
		int res = Integer.MAX_VALUE;
		
		for(int i = 0; i< words.length;i++){
			String cur = words[i];
			if(cur.equals(word1)){
				p1 = i;
			}
			
			if(cur.equals(word1)){
				p2 = i;
			}
			
			if(p1 != -1 && p2 != -1){
				res = Math.min(res, Math.abs(p1-p2));
			}
		}
		
		return res;
	}

}
