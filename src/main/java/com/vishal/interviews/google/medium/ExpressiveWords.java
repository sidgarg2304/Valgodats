package com.vishal.interviews.google.medium;

import java.util.*;

/**
 * 809. Expressive Words
 * 
 * Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo", "hi" -> "hiiii".  Here, we have groups, of adjacent letters that are all the same character, and adjacent characters to the group are different.  A group is extended if that group is length 3 or more, so "e" and "o" would be extended in the first example, and "i" would be extended in the second example.  As another example, the groups of "abbcccaaaa" would be "a", "bb", "ccc", and "aaaa"; and "ccc" and "aaaa" are the extended groups of that string.

For some given string S, a query word is stretchy if it can be made to be equal to S by extending some groups.  Formally, we are allowed to repeatedly choose a group (as defined above) of characters c, and add some number of the same character c to it so that the length of the group is 3 or more.  Note that we cannot extend a group of size one like "h" to a group of size two like "hh" - all extensions must leave the group extended - ie., at least 3 characters long.

Given a list of query words, return the number of words that are stretchy. 

Example:
Input: 
S = "heeellooo"
words = ["hello", "hi", "helo"]
Output: 1
Explanation: 
We can extend "e" and "o" in the word "hello" to get "heeellooo".
We can't extend "helo" to get "heeellooo" because the group "ll" is not extended.
Notes:

0 <= len(S) <= 100.
0 <= len(words) <= 100.
0 <= len(words[i]) <= 100.
S and all words in words consist only of lowercase letters
 *
 */
public class ExpressiveWords {

	public static void main(String[] args) {

	}
	
	/**
	 * Approach #1: Run Length Encoding [Accepted]
Intuition

For some word, write the head character of every group, and the count of that group. For example, for "abbcccddddaaaaa", we'll write the "key" of "abcda", and the "count" [1,2,3,4,5].

Let's see if a word is stretchy. Evidently, it needs to have the same key as S.

Now, let's say we have individual counts c1 = S.count[i] and c2 = word.count[i].

If c1 < c2, then we can't make the ith group of word equal to the ith word of S by adding characters.

If c1 >= 3, then we can add letters to the ith group of word to match the ith group of S, as the latter is extended.

Else, if c1 < 3, then we must have c2 == c1 for the ith groups of word and S to match.

Complexity Analysis

Time Complexity: O(QK)O(QK), where QQ is the length of words (at least 1), and KK is the maximum length of a word.

Space Complexity: O(K)O(K).
	 */
	public int expressiveWords(String S, String[] words) {
      RLE R = new RLE(S);
      int ans = 0;

      search: for (String word: words) {
          RLE R2 = new RLE(word);
          if (!R.key.equals(R2.key)) continue;
          for (int i = 0; i < R.counts.size(); ++i) {
              int c1 = R.counts.get(i);
              int c2 = R2.counts.get(i);
              if (c1 < 3 && c1 != c2 || c1 < c2)
                  continue search;
          }
          ans++;
      }
      return ans;
  }
}

class RLE {
  String key;
  List<Integer> counts;

  public RLE(String S) {
      StringBuilder sb = new StringBuilder();
      counts = new ArrayList();

      char[] ca = S.toCharArray();
      int N = ca.length;
      int prev = -1;
      for (int i = 0; i < N; ++i) {
          if (i == N-1 || ca[i] != ca[i+1]) {
              sb.append(ca[i]);
              counts.add(i - prev);
              prev = i;
          }
      }

      key = sb.toString();
  }
}