package com.vishal.interviews.google.easy;

/**
 * 459. Repeated Substring Pattern
 * 
 * Given a non-empty string check if it can be constructed by taking a substring
 * of it and appending multiple copies of the substring together. You may assume
 * the given string consists of lowercase English letters only and its length
 * will not exceed 10000.
 * 
 * Example 1: Input: "abab"
 * 
 * Output: True
 * 
 * Explanation: It's the substring "ab" twice. Example 2: Input: "aba"
 * 
 * Output: False Example 3: Input: "abcabcabcabc"
 * 
 * Output: True
 * 
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc"
 * twice.)
 */
public class RepeatedSubstringPattern {

	public static void main(String[] args) {
	}

	/**
	 * The length of the repeating substring must be a divisor of the length of
	 * the input string
	 * 
	 * Search for all possible divisor of str.length, starting for length/2
	 * 
	 * If i is a divisor of length, repeat the substring from 0 to i the number
	 * of times i is contained in s.length
	 * 
	 * If the repeated substring is equals to the input str return true
	 * 
	 * @param str
	 * @return
	 */
	public boolean repeatedSubstringPatternSimple(String str) {
		int l = str.length();
		for (int i = l / 2; i >= 1; i--) {
			if (l % i == 0) {
				int m = l / i;
				String subS = str.substring(0, i);
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < m; j++) {
					sb.append(subS);
				}
				if (sb.toString().equals(str))
					return true;
			}
		}
		return false;
	}

	public boolean repeatedSubstringPatternONUsingKMP(String str) {
		// This is the kmp issue
		int[] prefix = kmp(str);
		int len = prefix[str.length() - 1];
		int n = str.length();
		return (len > 0 && n % (n - len) == 0);
	}

	private int[] kmp(String s) {
		int len = s.length();
		int[] res = new int[len];
		char[] ch = s.toCharArray();
		int i = 0, j = 1;
		res[0] = 0;
		while (i < ch.length && j < ch.length) {
			if (ch[j] == ch[i]) {
				res[j] = i + 1;
				i++;
				j++;
			} else {
				if (i == 0) {
					res[j] = 0;
					j++;
				} else {
					i = res[i - 1];
				}
			}
		}
		return res;
	}

	/**
	 * Solution 1: Let us start with the very naive solution. It uses 188 ms to
	 * solve 100 test cases. The idea is that when we see a character in str that
	 * matches the very first character of str, we can start to hoping that str
	 * is a built by copies of the substring composed by all characters before
	 * the reappearance of the its first character.
	 * 
	 * @param str
	 * @return
	 */
	public boolean repeatedSubstringPatternHard1(String str) {
		int l = str.length();
		if (l == 1) {
			return false;
		}
		StringBuilder sb = new StringBuilder();
		char first = str.charAt(0);
		sb.append(first);
		int i = 1;
		while (i <= l / 2) {
			char c = str.charAt(i++);
			if (c == first && isCopies(str, sb.toString())) {
				return true;
			} else {
				sb.append(c);
			}
		}
		return false;
	}

	private boolean isCopies(String str, String substr) {
		if (str.length() % substr.length() != 0) {
			return false;
		}
		for (int i = substr.length(); i < str.length(); i += substr.length()) {
			if (!str.substring(i).startsWith(substr)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Solution 2: The problem of the first solution is that we do not use the
	 * knowledge of failed matching, and the Knuth-Morris-Pratt algorithm is a
	 * classic example of how knowledge of failed tries can be use to guide
	 * future search.
	 * 
	 * In fact we only need to compute the pattern table (the lps array, see
	 * below) in the Knuth-Morris-Pratt algorithm.
	 * 
	 * The entry lps[i] is the length of the longest proper prefix that is also a
	 * suffix of (s[0], ..., s[i]), or equivalently, length of the longest prefix
	 * that is also a proper suffix of (s[0], ..., s[i]). lps[0] is 0, since a
	 * single - character string has no proper prefix or proper suffix. Here is a
	 * very detailed explanation on the KMP algorithm and how lps is computed
	 * dynamically.
	 * 
	 * After we get lps, we relate the property of the lps table to the property
	 * of a string being constructed by joining copies of its substring.
	 * 
	 * One on hand, if str = (s[0], ..., s[km - 1]) is constructed by joining m
	 * copies of its substring substr = (s[0], ..., s[k-1]), and assuming that
	 * substr is the finest making blockstr can be boiled down to, meaning str is
	 * not constructed by joining copies of any proper substring of substr. Then
	 * we must have lps[km - 1] equals (m - 1)k.
	 * 
	 * On the other hand, assuming that the longest proper prefix of string str
	 * that is also a suffix, and the remaining string remainderStr obtained by
	 * removing prefix from str satisfies the following 3 properties:
	 * 
	 * 1. remainderStr is a proper substring of str,
	 * 
	 * 2. |str| is divisiable by
	 * 
	 * 3. |remainderStr|, remainderStr is a prefix of prefixStr.
	 * 
	 * We can show by induction that str is constructed by joining copies of
	 * remainderStr. Here is the code. It solve the 100 test cases in 29ms. A
	 * great improvement over the native approach! Remember the statement above,
	 * since we are going to use it again.
	 * 
	 * @param str
	 * @return
	 */
	public boolean repeatedSubstringPatternHard2(String str) {
		int l = str.length();
		int[] lps = new int[l];
		int leading = 1;
		int chasing = 0;
		while (leading < l) {
			if (str.charAt(chasing) == str.charAt(leading)) {
				chasing++;
				lps[leading] = chasing;
				leading++;
			} else {
				if (chasing > 0) {
					chasing = lps[chasing - 1];
				} else {
					chasing = 0;
					leading++;
				}
			}
		}
		int lp = lps[l - 1];
		return (lp > 0 && l % (l - lp) == 0 && str.startsWith(str.substring(lp)));
	}

	/**
	 * Can the problem be solved efficiently without KMP? The following solution
	 * runs even faster (23ms on 100 test cases)
	 * 
	 * @param str
	 * @return
	 */
	public boolean repeatedSubstringPatternHard3(String str) {
		int l = str.length();
		for (int i = l / 2; i > 0; i--) {
			if (l % i == 0) {
				String substr = str.substring(0, i);
				int j = i;
				while (j < l) {
					if (!str.substring(j, j + i).equals(substr)) {
						break;
					} else {
						j += i;
					}
				}
				if (j == l) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Want clearer code that runs even faster ? Here is it. The idea is stated
	 * at the end of the explanation for solution 2. Without really find the
	 * longest proper prefix that is also a suffix as in solution 2 and see
	 * whether the three properties are matched, we just test each remainderStr,
	 * from the longest possible that satisfies condition 1 and 2, that whether
	 * the corresponding prefix and suffix match each other. It solve 100 test
	 * cases in 16ms. So maybe now, you really want to prove the statement since
	 * it lead to such a clean and fast solution? It is not hard to prove by
	 * induction.
	 * 
	 * @param str
	 * @return
	 */
	public boolean repeatedSubstringPatternHard4(String str) {
		int l = str.length();
		for (int i = (l + 1) / 2; i < l; i++) {
			if (l % (l - i) == 0) {
				String prefix = str.substring(0, i);
				String remainder = str.substring(i);
				String suffix = str.substring(l - i);
				if (str.startsWith(remainder) && suffix.equals(prefix)) {
					return true;
				}
			}
		}
		return false;
	}

}
