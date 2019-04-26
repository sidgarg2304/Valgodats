package com.vishal.interviews.facebook.easy;

/**
 * 680. Valid Palindrome II
 * 
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 *
 */
public class ValidPalindromeII {

	public static void main(String[] args) {

	}
	
	/**
	 * Approach #2: Greedy [Accepted]
Intuition

If the beginning and end characters of a string are the same (ie. s[0] == s[s.length - 1]), then whether the inner characters are a palindrome (s[1], s[2], ..., s[s.length - 2]) uniquely determines whether the entire string is a palindrome.

Algorithm

Suppose we want to know whether s[i], s[i+1], ..., s[j] form a palindrome. If i >= j then we are done. If s[i] == s[j] then we may take i++; j--. Otherwise, the palindrome must be either s[i+1], s[i+2], ..., s[j] or s[i], s[i+1], ..., s[j-1], and we should check both cases.
	 * 
	 * 
	 * Complexity Analysis

Time Complexity: O(N)O(N) where NN is the length of the string. Each of two checks of whether some substring is a palindrome is O(N)O(N).

Space Complexity: O(1)O(1) additional complexity. Only pointers were stored in memory.
	 */
	public boolean isPalindromeRange(String s, int i, int j) {
      for (int k = i; k <= i + (j - i) / 2; k++) {
          if (s.charAt(k) != s.charAt(j - k + i)) return false;
      }
      return true;
  }
  public boolean validPalindrome(String s) {
      for (int i = 0; i < s.length() / 2; i++) {
          if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
              int j = s.length() - 1 - i;
              return (isPalindromeRange(s, i+1, j) ||
                      isPalindromeRange(s, i, j-1));
          }
      }
      return true;
  }
  
	
	/**
	 * Approach #1: Brute Force [Time Limit Exceeded]
Intuition and Algorithm

For each index i in the given string, let's remove that character, then check if the resulting string is a palindrome. If it is, (or if the original string was a palindrome), then we'll return true
	 */
	public boolean isPalindrome(CharSequence s) {
      for (int i = 0; i < s.length() / 2; i++) {
          if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
              return false;
          }
      }
      return true;
  }
  public boolean validPalindromeBruteForce(String s) {
      StringBuilder sb = new StringBuilder(s);
      for (int i = 0; i < s.length(); i++) {
          char c = sb.charAt(i);
          sb.deleteCharAt(i);
          if (isPalindrome(sb)) return true;
          sb.insert(i, c);
      }
      return isPalindrome(s);
  }

}
