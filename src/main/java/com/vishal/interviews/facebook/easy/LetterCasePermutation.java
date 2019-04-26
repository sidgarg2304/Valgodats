package com.vishal.interviews.facebook.easy;

import java.util.*;

/**
 * 784. Letter Case Permutation
 * 
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
Note:

S will be a string with length at most 12.
S will consist only of letters or digits.
 *
 */
public class LetterCasePermutation {

	public static void main(String[] args) {

	}
	
	public List<String> letterCasePermutationDFS(String S) {
		List<String> res = new ArrayList<>();

		dfs(S, 0, res, "");
		return res;
	}

	void dfs(String S, int p, List<String> res, String cur) {
		if (p == S.length()) {
			res.add(cur);
			return;
		}

		char c = S.charAt(p);
		if (Character.isAlphabetic(c)) {
			dfs(S, p + 1, res, cur + Character.toLowerCase(c));
			dfs(S, p + 1, res, cur + Character.toUpperCase(c));
		} else {
			dfs(S, p + 1, res, cur + c);
		}
	}
	
	/**
	 * Approach #1: Recursion [Accepted]
Intuition

Maintain the correct answer as we increase the size of the prefix of S we are considering.

For example, when S = "abc", maintain ans = [""], and update it to ans = ["a", "A"], ans = ["ab", "Ab", "aB", "AB"], ans = ["abc", "Abc", "aBc", "ABc", "abC", "AbC", "aBC", "ABC"] as we consider the letters "a", "b", "c".

Algorithm

If the next character c is a letter, then we will duplicate all words in our current answer, and add lowercase(c) to every word in the first half, and uppercase(c) to every word in the second half.

If instead c is a digit, we'll add it to every word.
	 */
	public List<String> letterCasePermutation(String S) {
      List<StringBuilder> ans = new ArrayList();
      ans.add(new StringBuilder());

      for (char c: S.toCharArray()) {
          int n = ans.size();
          if (Character.isLetter(c)) {
              for (int i = 0; i < n; ++i) {
                  ans.add(new StringBuilder(ans.get(i)));
                  ans.get(i).append(Character.toLowerCase(c));
                  ans.get(n+i).append(Character.toUpperCase(c));
              }
          } else {
              for (int i = 0; i < n; ++i)
                  ans.get(i).append(c);
          }
      }

      List<String> finalans = new ArrayList();
      for (StringBuilder sb: ans)
          finalans.add(sb.toString());
      return finalans;
  }
	
	/**
	 * Approach #2: Binary Mask [Accepted]
Intuition

Say there are BB letters in the string S. There will be 2^B2
​B
​​  strings in the answer, which we can represent uniquely by the bitmask bits.

For example, we could represent a7b by 00, a7B by 01, A7b by 10, and A7B by 11. Note that numbers are not part of the bitmask.

Algorithm

For every possible bitmask, construct the correct result to put in the final answer. If the next letter in the word is a letter, write a lowercase or uppercase letter depending on the bitmask. Otherwise, write the digit as given.
	 */
	public List<String> letterCasePermutationBinaryMask(String S) {
      int B = 0;
      for (char c: S.toCharArray())
          if (Character.isLetter(c))
              B++;

      List<String> ans = new ArrayList();

      for (int bits = 0; bits < 1<<B; bits++) {
          int b = 0;
          StringBuilder word = new StringBuilder();
          for (char letter: S.toCharArray()) {
              if (Character.isLetter(letter)) {
                  if (((bits >> b++) & 1) == 1)
                      word.append(Character.toLowerCase(letter));
                  else
                      word.append(Character.toUpperCase(letter));
              } else {
                  word.append(letter);
              }
          }

          ans.add(word.toString());
      }

      return ans;

  }

}
