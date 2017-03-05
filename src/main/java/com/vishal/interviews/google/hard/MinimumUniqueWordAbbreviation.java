package com.vishal.interviews.google.hard;

import java.util.ArrayList;
import java.util.List;


/**
 * 411. Minimum Unique Word Abbreviation
 * A string such as "word" contains the following abbreviations:

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Given a target string and a set of strings in a dictionary, find an abbreviation of this target string with the smallest possible length such that it does not conflict with abbreviations of the strings in the dictionary.

Each number or letter in the abbreviation is considered length = 1. For example, the abbreviation "a32bc" has length = 4.

Note:
In the case of multiple answers as shown in the second example below, you may return any one of them.
Assume length of target string = m, and dictionary size = n. You may assume that m ≤ 21, n ≤ 1000, and log2(n) + m ≤ 20.
Examples:
"apple", ["blade"] -> "a4" (because "5" or "4e" conflicts with "blade")

"apple", ["plain", "amber", "blade"] -> "1p3" (other valid answers include "ap3", "a3e", "2p2", "3le", "3l1").
 */

/**
 * It's NP-hard
I think this problem is NP-hard. For proof, I'll reduce the set cover decision problem to it. The example there is:

U = {1, 2, 3, 4, 5}
S = {{1, 2, 3}, {2, 4}, {3, 4}, {4, 5}}
Now I'd encode that for Minimum Unique Word Abbreviation like this:

target: "oooo"
dict:   "looo" (word 1)
        "lloo" (word 2)
        "lolo" (word 3)
        "olll" (word 4)
        "oool" (word 5)
The five dictionary words correspond to the five elements of U. And every word has four letters, corresponding to the four subsets in S. You can see for example the second subset {2, 4} encoded as the second colum in the dictionary, which has l in words 2 and 4 (and otherwise only o).

(Side note: You can build an abbreviation by picking letters and then replacing the unpicked ones with numbers. For example, when you have leetcode and pick the letters l, t and the last e, you get l2t3e. This way you can get all 2|word| possible abbreviations from the 2|word| possible ways of picking, as I've done in the first solution here.)

Now an optimal abbreviation for the target is "o2o", which we get by picking the first "o" because that distinguishes the target from words {1, 2, 3} and by picking the last "o" because that distinguishes the target from words {4, 5}. Just like picking the subsets {1, 2, 3} and {4, 5} cover all of U in the set cover problem.

A little problem is that if I switch the third and fourth element of S, then an optimal abbreviation picks the first and third "o", so instead of "o2o" we'd get "o1o1". That's a different length. So instead of the above encoding, I'd really do this, inserting "x" before and after each letter:

target: "xoxoxoxox"
dict:   "xlxoxoxox"
        "xlxlxoxox"
        "xlxoxlxox"
        "xoxlxlxlx"
        "xoxoxoxlx"
Now "1o5o1" is an optimal abbreviation, and when I switch third and fourth element of S again, I instead get "1o3o3", which still has the same length.

To be precise and usable: When I pick k letters, the optimal abbreviation will have those k letters as well as k+1 numbers, so length 2k+1. That means minimizing the abbreviation length is equivalent to minimizing the number of picked letters, which is equivalent to minimizing the number of picked elements of S in the decision problem.

Summary: To solve a given set cover decision problem instance, I translate it to a Minimum Unique Word Abbreviation instance like above, and then from the computed optimal abbreviation, I subtract 1 from its length and divide it by 2 to get the number of picked letters, which is the minimum number of elements of S that cover U. And with that, I can directly answer the original set cover instance.

Moral of the story: Don't feel bad about writing a brute force solution :-)
 * @author vkotha
 *
 */
public class MinimumUniqueWordAbbreviation {

	public static void main(String[] args) {

	}

}

/**
 * Trie + Bruteforce
Abbreviation number is pretty like wild card and it can match all the characters appearing in the trie.
There's 3 functions:
addTrie: add string to the trie
search: search a string to determine if that's the one in the trie (wild card mode)
abbrGenerator: generate all the possible abbreviations given certain length (which is num parameter).

PS: the search function is pretty ugly. hope someone can help it :P
 */
class MinimumUniqueWordAbbreviationUsingTrie {

	class Trie {
		Trie[] next = new Trie[26];
		boolean isEnd = false;
	}

	Trie root = new Trie();
	List<String> abbrs;

	public String minAbbreviation(String target, String[] dictionary) {
		for (String s : dictionary) {
			addTrie(s);
		}
		for (int i = 0; i < target.length(); i++) {
			abbrs = new ArrayList<>();
			abbrGenerator(target, 0, "", 0, i + 1);
			for (String s : abbrs) {
				if (search(s, root, 0, 0) == false)
					return s;
			}
		}
		return "";
	}

	public void addTrie(String s) {
		Trie cur = root;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (cur.next[c - 'a'] == null) {
				cur.next[c - 'a'] = new Trie();
			}
			cur = cur.next[c - 'a'];
		}
		cur.isEnd = true;
	}

	public boolean search(String target, Trie root, int i, int loop) {
		if (root == null)
			return false;

		if (loop != 0) {
			for (int a = 0; a < 26; a++) {
				if (search(target, root.next[a], i, loop - 1))
					return true;
			}
			return false;
		}
		if (i == target.length()) {
			if (root.isEnd)
				return true;
			return false;
		}
		if (Character.isDigit(target.charAt(i))) {
			int tmp = 0;
			while (i < target.length() && Character.isDigit(target.charAt(i))) {
				tmp = tmp * 10 + target.charAt(i) - '0';
				i++;
			}
			return search(target, root, i, tmp);
		} else {
			return search(target, root.next[target.charAt(i) - 'a'], i + 1, 0);
		}
	}

	public void abbrGenerator(String target, int i, String tmp, int abbr, int num) {
		if (i == target.length()) {
			if (num == 0 && abbr == 0)
				abbrs.add(tmp);
			if (num == 1 && abbr != 0)
				abbrs.add(tmp + abbr);
			return;
		}
		if (num <= 0)
			return;
		char cur = target.charAt(i);
		abbrGenerator(target, i + 1, abbr == 0 ? tmp + cur : tmp + abbr + cur, 0, abbr == 0 ? num - 1 : num - 2);
		abbrGenerator(target, i + 1, tmp, abbr + 1, num);
	}
}

/**
 * Java DFS+Trie+Binary Search 90ms
 * 
 * Use Trie to build a dictionary with a function to check abbreviation.
 * 
 * Use DFS with backtracking to generate the abbreviations of a given length.
 * 
 * Use binary search to find the smallest possible length.
 *
 */
class MinimumUniqueWordAbbreviationUsingDFS {
	class Node { // Trie Node
		Node[] nodes;
		boolean isWord;

		Node() {
			nodes = new Node[26];
			isWord = false;
		}

		void add(String str) { // add a word to Trie
			if (str.length() == 0)
				isWord = true; // end of a word
			else {
				int idx = str.charAt(0) - 'a'; // insert a new node
				if (nodes[idx] == null)
					nodes[idx] = new Node();
				nodes[idx].add(str.substring(1));
			}
		}

		boolean isAbbr(String abbr, int num) {
			if (num > 0) { // number of '*'
				for (Node node : nodes) {
					if (node != null && node.isAbbr(abbr, num - 1))
						return true;
				}
				return false; // not exist in the dictionary
			} else {
				if (abbr.length() == 0)
					return isWord; // at the end of the addr
				int idx = 0; // get the number of '*' at the start of the abbr
				while (idx < abbr.length() && abbr.charAt(idx) >= '0' && abbr.charAt(idx) <= '9') {
					num = (num * 10) + (abbr.charAt(idx++) - '0');
				}
				if (num > 0)
					return isAbbr(abbr.substring(idx), num); // start with number
				else { // start with non-number
					if (nodes[abbr.charAt(0) - 'a'] != null)
						return nodes[abbr.charAt(0) - 'a'].isAbbr(abbr.substring(1), 0);
					else
						return false; // not exist in the dictionary
				}
			}
		}
	}

	void getAbbs(char[] cc, int s, int len, StringBuilder sb, List<String> abbs) { // DFS
																											 // with
																											 // backtracking
		boolean preNum = (sb.length() > 0) && (sb.charAt(sb.length() - 1) >= '0') && (sb.charAt(sb.length() - 1) <= '9');
		if (len == 1) {
			if (s < cc.length) {
				if (s == cc.length - 1)
					abbs.add(sb.toString() + cc[s]); // add one char
				if (!preNum)
					abbs.add(sb.toString() + (cc.length - s)); // add a number
			}
		} else if (len > 1) {
			int last = sb.length();
			for (int i = s + 1; i < cc.length; i++) {
				if (!preNum) { // add a number
					sb.append(i - s);
					getAbbs(cc, i, len - 1, sb, abbs);
					sb.delete(last, sb.length());
				}
				if (i == s + 1) { // add one char
					sb.append(cc[s]);
					getAbbs(cc, i, len - 1, sb, abbs);
					sb.delete(last, sb.length());
				}
			}
		}
	}

	public String minAbbreviation(String target, String[] dictionary) {
		List<String> dict = new ArrayList<>();
		int len = target.length();
		for (String str : dictionary)
			if (str.length() == len)
				dict.add(str);
		if (dict.isEmpty())
			return "" + len;
		Node root = new Node();
		for (String str : dict)
			root.add(str);
		char[] cc = target.toCharArray();
		String ret = null;

		int min = 1, max = len;
		while (max >= min) {
			int mid = min + ((max - min) / 2);
			List<String> abbs = new ArrayList<>();
			getAbbs(cc, 0, mid, new StringBuilder(), abbs);
			boolean conflict = true;
			for (String abbr : abbs) {
				if (!root.isAbbr(abbr, 0)) {
					conflict = false;
					ret = abbr;
					break;
				}
			}
			if (conflict) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}
		return ret;
	}
}
