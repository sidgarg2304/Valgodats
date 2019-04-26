package com.vishal.interviews.google.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 833. Find And Replace in String
 * 
 * To some string S, we will perform some replacement operations that replace groups of letters with new ones (not necessarily the same size).

Each replacement operation has 3 parameters: a starting index i, a source word x and a target word y.  The rule is that if x starts at position i in the original string S, then we will replace that occurrence of x with y.  If not, we do nothing.

For example, if we have S = "abcd" and we have some replacement operation i = 2, x = "cd", y = "ffff", then because "cd" starts at position 2 in the original string S, we will replace it with "ffff".

Using another example on S = "abcd", if we have both the replacement operation i = 0, x = "ab", y = "eee", as well as another replacement operation i = 2, x = "ec", y = "ffff", this second operation does nothing because in the original string S[2] = 'c', which doesn't match x[0] = 'e'.

All these operations occur simultaneously.  It's guaranteed that there won't be any overlap in replacement: for example, S = "abc", indexes = [0, 1], sources = ["ab","bc"] is not a valid test case.

Example 1:

Input: S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
Output: "eeebffff"
Explanation: "a" starts at index 0 in S, so it's replaced by "eee".
"cd" starts at index 2 in S, so it's replaced by "ffff".
Example 2:

Input: S = "abcd", indexes = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]
Output: "eeecd"
Explanation: "ab" starts at index 0 in S, so it's replaced by "eee". 
"ec" doesn't starts at index 2 in the original S, so we do nothing.
Notes:

0 <= indexes.length = sources.length = targets.length <= 100
0 < indexes[i] < S.length <= 1000
All characters in given inputs are lowercase letters.
 
 *
 */
public class FindAndReplaceinString {

	public static void main(String[] args) {

	}
	
	public String findReplaceStringSimple(String S, int[] indexes, String[] sources, String[] targets) {

		StringBuilder res = new StringBuilder();

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < indexes.length; i++) {
			map.put(indexes[i], i);
		}

		int i = 0;
		while (i < S.length()) {
			if (map.containsKey(i)) {
				String src = sources[map.get(i)];
				int st = i;
				int en = i + src.length();

				if (src.equals(S.substring(st, en))) {
					res.append(targets[map.get(i)]);
					i = en;
				} else {
					res.append(S.charAt(i++));
				}

			} else {
				res.append(S.charAt(i++));
			}
		}
		return res.toString();
	}
	
	/**
	 * Approach #1: Direct [Accepted]
Intuition and Algorithm

We showcase two different approaches. In both approaches, we work on finding whether the replacement operation is successful or not.

In Java, we work with a match array, recording match[ix] = i if the ith replacement operation is successful and involves the index S[ix]. Because the limits are low, we can work with substrings for convenience.

Then, we build the answer using this match array. We repeatedly either write the next character S[ix], or targets[match[ix]] depending on the value of match[ix].

In Python, we sort our replacement jobs (i, x, y) in reverse order. If S[i:].startswith(x) (we use a longer check that checks each index), then we can replace that section S[i:i+len(x)] with the target y. We used a reverse order so that edits to S do not interfere with the rest of the queries.

Complexity Analysis

Time Complexity: O(NQ)O(NQ), where NN is the length of S, and we have QQ replacement operations. (Our complexity could be faster with a more accurate implementation, but it isn't necessary.)

Space Complexity: O(N)O(N), if we consider targets[i].length <= 100 as a constant bound.
	 * @return
	 */
	public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
      int N = S.length();
      int[] match = new int[N];
      Arrays.fill(match, -1);

      for (int i = 0; i < indexes.length; ++i) {
          int ix = indexes[i];
          if (S.substring(ix, ix + sources[i].length()).equals(sources[i]))
              match[ix] = i;
      }

      StringBuilder ans = new StringBuilder();
      int ix = 0;
      while (ix < N) {
          if (match[ix] >= 0) {
              ans.append(targets[match[ix]]);
              ix += sources[match[ix]].length();
          } else {
              ans.append(S.charAt(ix++));
          }
      }
      return ans.toString();
  }

}
