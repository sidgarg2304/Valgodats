package com.vishal.interviews.google.easy;

/**
 * 758. Bold Words in String
 * 
 * 
 * Given a set of keywords words and a string S, make all appearances of all keywords in S bold. Any letters between <b> and </b> tags become bold.

The returned string should use the least number of tags possible, and of course the tags should form a valid combination.

For example, given that words = ["ab", "bc"] and S = "aabcd", we should return "a<b>abc</b>d". Note that returning "a<b>a<b>b</b>c</b>d" would use more tags, so it is incorrect.

Note:

words has length in range [0, 50].
words[i] has length in range [1, 10].
S has length in range [0, 500].
All characters in words[i] and S are lowercase letters.
 *
 */
public class BoldWordsinString {

	public static void main(String[] args) {

	}

	/**
	 * Approach #1: Brute Force [Accepted]
Intuition

Let's try to learn which letters end up bold, since the resulting answer will just be the canonical one - we put bold tags around each group of bold letters.

To do this, we'll check for all occurrences of each word and mark the corresponding letters bold.

Algorithm

Let's work on first setting mask[i] = true if and only if the i-th letter is bold. For each starting position i in S, for each word, if S[i] starts with word, we'll set the appropriate letters bold.

Now armed with the correct mask, let's try to output the answer. A letter in position i is the first bold letter of the group if mask[i] && (i == 0 || !mask[i-1]), and is the last bold letter if mask[i] && (i == N-1 || !mask[i+1]). Alternatively, we could use itertools.groupby in Python.

Once we know which letters are the first and last bold letters of a group, we know where to put the "<b>" and "</b>" tags.

Complexity Analysis

Time Complexity: O(N\sum w_i)O(N∑w
​i
​​ ), where NN is the length of S and w_iw
​i
​​  is the sum of W.

Space Complexity: O(N)O(N).
	 */
	public String boldWords(String[] words, String S) {
      int N = S.length();
      boolean[] mask = new boolean[N];
      for (int i = 0; i < N; ++i)
          for (String word: words) search: {
              for (int k = 0; k < word.length(); ++k)
                  if (k+i >= S.length() || S.charAt(k+i) != word.charAt(k))
                      break search;

              for (int j = i; j < i+word.length(); ++j)
                  mask[j] = true;
          }

      StringBuilder ans = new StringBuilder();
      int anchor = 0;
      for (int i = 0; i < N; ++i) {
          if (mask[i] && (i == 0 || !mask[i-1]))
              ans.append("<b>");
          ans.append(S.charAt(i));
          if (mask[i] && (i == N-1 || !mask[i+1]))
              ans.append("</b>");
      }
      return ans.toString();
  }

  public boolean match(String S, int i, int j, String T) {
      for (int k = i; k < j; ++k)
          if (k >= S.length() || S.charAt(k) != T.charAt(k-i))
              return false;
      return true;
  }
}
