package com.vishal.interviews.google.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 425. Word Squares
 * 
 * Given a set of words (without duplicates), find all word squares you can build from them.

A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).

For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.

b a l l
a r e a
l e a d
l a d y
Note:
There are at least 1 and at most 1000 words.
All words will have the exact same length.
Word length is at least 1 and at most 5.
Each word contains only lowercase English alphabet a-z.
Example 1:

Input:
["area","lead","wall","lady","ball"]

Output:
[
  [ "wall",
    "area",
    "lead",
    "lady"
  ],
  [ "ball",
    "area",
    "lead",
    "lady"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
Example 2:

Input:
["abat","baba","atan","atal"]

Output:
[
  [ "baba",
    "abat",
    "baba",
    "atan"
  ],
  [ "baba",
    "abat",
    "baba",
    "atal"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
 */
public class WordSquares {

	public static void main(String[] args) {

	}

}

/**
 * Explained. My Java solution using Trie [126ms 16/16]
My first approach is brute-force, try every possible word sequences, and use the solution of Problem 422 (https://leetcode.com/problems/valid-word-square/) to check each sequence. This solution is straightforward, but too slow (TLE).

A better approach is to check the validity of the word square while we build it.
Example: ["area","lead","wall","lady","ball"]
We know that the sequence contains 4 words because the length of each word is 4.
Every word can be the first word of the sequence, let's take "wall" for example.
Which word could be the second word? Must be a word start with "a" (therefore "area"), because it has to match the second letter of word "wall".
Which word could be the third word? Must be a word start with "le" (therefore "lead"), because it has to match the third letter of word "wall" and the third letter of word "area".
What about the last word? Must be a word start with "lad" (therefore "lady"). For the same reason above.

The picture below shows how the prefix are matched while building the sequence.

In order for this to work, we need to fast retrieve all the words with a given prefix. There could be 2 ways doing this:

Using a hashtable, key is prefix, value is a list of words with that prefix.

Trie, we store a list of words with the prefix on each trie node.

The implemented below uses Trie.
 *
 */
class WordSquaresTrie {
	class TrieNode {
		List<String> startWith;
		TrieNode[] children;

		TrieNode() {
			startWith = new ArrayList<>();
			children = new TrieNode[26];
		}
	}

	class Trie {
		TrieNode root;

		Trie(String[] words) {
			root = new TrieNode();
			for (String w : words) {
				TrieNode cur = root;
				for (char ch : w.toCharArray()) {
					int idx = ch - 'a';
					if (cur.children[idx] == null)
						cur.children[idx] = new TrieNode();
					cur.children[idx].startWith.add(w);
					cur = cur.children[idx];
				}
			}
		}

		List<String> findByPrefix(String prefix) {
			List<String> ans = new ArrayList<>();
			TrieNode cur = root;
			for (char ch : prefix.toCharArray()) {
				int idx = ch - 'a';
				if (cur.children[idx] == null)
					return ans;

				cur = cur.children[idx];
			}
			ans.addAll(cur.startWith);
			return ans;
		}
	}

	public List<List<String>> wordSquares(String[] words) {
		List<List<String>> ans = new ArrayList<>();
		if (words == null || words.length == 0)
			return ans;
		int len = words[0].length();
		Trie trie = new Trie(words);
		List<String> ansBuilder = new ArrayList<>();
		for (String w : words) {
			ansBuilder.add(w);
			search(len, trie, ans, ansBuilder);
			ansBuilder.remove(ansBuilder.size() - 1);
		}

		return ans;
	}

	private void search(int len, Trie tr, List<List<String>> ans, List<String> ansBuilder) {
		if (ansBuilder.size() == len) {
			ans.add(new ArrayList<>(ansBuilder));
			return;
		}

		int idx = ansBuilder.size();
		StringBuilder prefixBuilder = new StringBuilder();
		for (String s : ansBuilder)
			prefixBuilder.append(s.charAt(idx));
		List<String> startWith = tr.findByPrefix(prefixBuilder.toString());
		for (String sw : startWith) {
			ansBuilder.add(sw);
			search(len, tr, ans, ansBuilder);
			ansBuilder.remove(ansBuilder.size() - 1);
		}
	}
}

/**
 * Java DFS+Trie 54 ms, 98% so far
By considering the word squares as a symmetric matrix, my idea is to go through the top right triangular matrix in left-to-right and then down order.
For example, with the case of ["area","lead","wall","lady","ball"] where length = 4,
we start with 4 empty string
""
""
""
""
Next, [0,0] , "a","b", "l", "w" can be placed, we start with "a"
"a"
""
""
""
[0,1] go right, "r" can be placed after "a", but no words start with "r" at [1,0], so this DFS ends.
"ar"
""
""
""
Now, start with "b" at [0,0]
"b"
""
""
""
We can have "ba" at [0,1] and there is a word start with "a"
"ba"
"a"
""
""
Next
"bal"
"a"
"l"
""
Next
"ball"
"a"
"l"
"l"
When finish the first row, go down to next row and start at [1,1]
"ball"
"ar"
"l"
"l"
..... so on and so forth until reaching [4,4]
 *
 */
class WordSquaresDFS {
	class Node {
		Node[] nodes;
		String word;

		Node() {
			this.nodes = new Node[26];
			this.word = null;
		}
	}

	void add(Node root, String word) {
		Node node = root;
		for (char c : word.toCharArray()) {
			int idx = c - 'a';
			if (node.nodes[idx] == null)
				node.nodes[idx] = new Node();
			node = node.nodes[idx];
		}
		node.word = word;
	}

	void helper(int row, int col, int len, Node[] rows, List<List<String>> ret) {
		if ((col == row) && (row == len)) { // last char
			List<String> res = new ArrayList<String>();
			for (int i = 0; i < len; i++) {
				res.add(new String(rows[i].word));
			}
			ret.add(res);
		} else { // from left to right and then go down to the next row
			if (col < len) { // left to right first
				Node pre_row = rows[row];
				Node pre_col = rows[col];
				for (int i = 0; i < 26; i++) { // find all the possible next char
					if ((rows[row].nodes[i] != null) && (rows[col].nodes[i] != null)) {
						rows[row] = rows[row].nodes[i];
						if (col != row)
							rows[col] = rows[col].nodes[i];
						helper(row, col + 1, len, rows, ret);
						rows[row] = pre_row;
						if (col != row)
							rows[col] = pre_col;
					}
				}
			} else { // reach the end of column, go to the next row
				helper(row + 1, row + 1, len, rows, ret);
			}
		}
	}

	public List<List<String>> wordSquares(String[] words) {
		List<List<String>> ret = new ArrayList<>();
		if (words == null || words.length == 0)
			return ret;
		Node root = new Node();
		int len = words[0].length();
		for (String word : words)
			add(root, word);
		Node[] rows = new Node[len];
		for (int i = 0; i < len; i++)
			rows[i] = root;
		helper(0, 0, len, rows, ret);
		return ret;
	}
}

/**
 * 121ms Java solution using Trie and BackTracking
 *
 */
class WordSquaresBackTracking {
	TrieNode root = new TrieNode();

	public List<List<String>> wordSquares(String[] words) {
		List<List<String>> ans = new ArrayList<>();
		if (words.length == 0)
			return ans;
		buildTrie(words);
		int length = words[0].length();
		findSquare(ans, length, new ArrayList<>());
		return ans;
	}

	private void findSquare(List<List<String>> ans, int length, List<String> temp) {
		if (temp.size() == length) {
			ans.add(new ArrayList<>(temp));
			return;
		}
		int index = temp.size();
		StringBuilder sb = new StringBuilder();
		for (String s : temp) {
			sb.append(s.charAt(index));
		}
		String s = sb.toString();
		TrieNode node = root;
		for (int i = 0; i < s.length(); i++) {
			if (node.next[s.charAt(i) - 'a'] != null) {
				node = node.next[s.charAt(i) - 'a'];
			} else {
				node = null;
				break;
			}
		}
		if (node != null) {
			for (String next : node.words) {
				temp.add(next);
				findSquare(ans, length, temp);
				temp.remove(temp.size() - 1);
			}
		}
	}

	private void buildTrie(String[] words) {
		for (String word : words) {
			TrieNode node = root;
			char[] array = word.toCharArray();
			for (char c : array) {
				node.words.add(word);
				if (node.next[c - 'a'] == null) {
					node.next[c - 'a'] = new TrieNode();
				}
				node = node.next[c - 'a'];
			}
			node.words.add(word);
		}
	}

	class TrieNode {
		TrieNode[] next = new TrieNode[26];
		List<String> words = new ArrayList<>();
	}
}
