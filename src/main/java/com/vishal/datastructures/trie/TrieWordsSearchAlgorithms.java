package com.vishal.datastructures.trie;

import java.util.HashSet;
import java.util.Set;

public class TrieWordsSearchAlgorithms {

	public static void main(String[] args) {
		testfindLongestValidStringByRemovingCharacters();
	}

	static void testfindLongestValidStringByRemovingCharacters() {
		Set<String> dictionary = new HashSet<>();
		dictionary.add("ale");
		dictionary.add("apple");
		findLongestValidStringByRemovingCharacters("abpcplea", dictionary);
	}

	// abpcplea
	static void findLongestValidStringByRemovingCharacters(String s, Set<String> dictionary) {

		Trie trie = new Trie();
		for (String w : dictionary) {
			trie.insert(w);
		}

		int maxLen = Integer.MIN_VALUE;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i); // a
			if (trie.root.childern[c - 'a'] != null) {
				TrieNode p = trie.root.childern[c - 'a']; // node for a

				System.out.println("searching for char " + c);
				int j = i + 1; // b

				while (j < s.length()) {
					char n = s.charAt(j);
					if (p.childern[n - 'a'] != null) {
						p = p.childern[n - 'a'];
						if (p.isWord) {
							maxLen = Math.max(maxLen, p.word.length());
						}
					}

					j++;
				}
			}
		}
		System.out.println("maxLen is " + maxLen);
	}

}
