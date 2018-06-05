package com.vishal.interviews.google.careercup;

import com.vishal.interviews.util.TrieNode;

public class LexicographicNextWord {

	public static void main(String[] args) {
		LexicographicNextWord l = new LexicographicNextWord(
				new String[] { "cat", "cow", "dog", "donkey", "zebra", "monkey" });
		System.out.println(l.findNextWord("duck"));
		System.out.println(l.findNextWord("dog"));
	}

	TrieNode root;

	public LexicographicNextWord(String[] words) {
		root = new TrieNode();
		for (String word : words) {
			insert(word);
		}
	}

	void insert(String word) {
		TrieNode c = root;

		for (int i = 0; i < word.length(); i++) {
			int pos = word.charAt(i) - 'a';
			if (c.children[pos] == null) {
				c.children[pos] = new TrieNode();
			}
			c = c.children[pos];
		}

		c.isWord = true;
		c.word = word;
	}

	// wrong solution
	public String findNextWord(String input) {
		return helper(root, input, 0, true);
	}

	String helper(TrieNode root, String input, int pos, boolean match) {

		if (root == null) {
			return null;
		}

		if (root.isWord && !root.word.equals(input)) {
			return root.word;
		}

		int p = (match && pos < input.length()) ? input.charAt(pos) - 'a' : -1;
		if (match && pos < input.length() - 1) {
			if (root.children[p] != null) {
				String cur = helper(root.children[p], input, pos + 1, match);
				if (cur != null) {
					return cur;
				}
			}
		}

		for (int i = p + 1; i < 26; i++) {
			String cur = helper(root.children[i], input, pos + 1, !match);
			if (cur != null) {
				return cur;
			}
		}
		return null;
	}

}
