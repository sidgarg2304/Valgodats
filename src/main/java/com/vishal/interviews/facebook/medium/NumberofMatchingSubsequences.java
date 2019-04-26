package com.vishal.interviews.facebook.medium;

import java.util.ArrayList;
import java.util.List;

public class NumberofMatchingSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int numMatchingSubseq(String S, String[] words) {

		int res = 0;
		ArrayList<Node>[] buckets = new ArrayList[26];

		for (int i = 0; i < 26; i++) {
			buckets[i] = new ArrayList<>();
		}

		for (String word : words) {
			buckets[word.charAt(0) - 'a'].add(new Node(word, 0));
		}

		for (char c : S.toCharArray()) {
			List<Node> oldBucket = buckets[c - 'a'];
			buckets[c - 'a'] = new ArrayList<>();

			for (Node n : oldBucket) {				
				n.pos += 1;
				if(n.pos == n.word.length()) {
					res++;
					continue;
				}
				char newChar = n.word.charAt(n.pos);
				buckets[newChar - 'a'].add(n);
			}
			oldBucket.clear();
		}

		return res;
	}

	class Node {
		String word;
		int pos;

		Node(String word, int pos) {
			this.word = word;
			this.pos = pos;
		}
	}

}
