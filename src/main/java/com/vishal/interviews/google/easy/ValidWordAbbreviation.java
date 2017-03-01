package com.vishal.interviews.google.easy;

/**
 * Question No: 408
 * 
 * Given a non-empty string s and an abbreviation abbr, return whether the
 * string matches with the given abbreviation.
 * 
 * A string such as "word" contains only the following valid abbreviations:
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1",
 * "w1r1", "1o2", "2r1", "3d", "w3", "4"] Notice that only the above
 * abbreviations are valid abbreviations of the string "word". Any other string
 * is not a valid abbreviation of "word".
 * 
 * Note: Assume s contains only lowercase letters and abbr contains only
 * lowercase letters and digits.
 * 
 * Example 1: Given s = "internationalization", abbr = "i12iz4n":
 * 
 * Return true.
 * 
 * Example 2: Given s = "apple", abbr = "a2e":
 * 
 * Return false.
 */
public class ValidWordAbbreviation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean validWordAbbreviationSol1(String word, String abbr) {
		int i = 0, j = 0;
		while (i < word.length() && j < abbr.length()) {
			if (word.charAt(i) == abbr.charAt(j)) {
				++i;
				++j;
				continue;
			}
			if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
				return false;
			}
			int start = j;
			while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
				++j;
			}
			int num = Integer.valueOf(abbr.substring(start, j));
			i += num;
		}
		return i == word.length() && j == abbr.length();
	}

	public boolean validWordAbbreviationSol2(String word, String abbr) {
		return word.matches(abbr.replaceAll("[1-9]\\d*", ".{$0}"));
	}

	public boolean validWordAbbreviationSol3(String word, String abbr) {
		int lengthOfWord = word.length();
		int count = 0;
		int index = 0;
		while (index < abbr.length()) {
			int digit = 0;
			while (index < abbr.length() && Character.isDigit(abbr.charAt(index))) {
				if (abbr.charAt(index) == '0' && digit == 0)
					return false;
				else {
					digit = digit * 10 + Integer.parseInt(abbr.charAt(index) + "");
					index++;
				}
			}
			count += digit;
			if (index < abbr.length() && Character.isLetter(abbr.charAt(index))) {
				if (count >= word.length())
					return false;
				if (abbr.charAt(index) != word.charAt(count))
					return false;
				else {
					count++;
					index++;
				}
			}
		}
		return lengthOfWord == count;
	}

	public boolean validWordAbbreviationSol4(String word, String abbr) {
		if (word == null || abbr == null)
			return false;
		int num = 0;
		int idx = 0;

		for (char c : abbr.toCharArray()) {
			if (c == '0' && num == 0)
				return false;
			if (c >= '0' && c <= '9') {
				num = num * 10 + (c - '0');
			} else {
				idx += num;
				if (idx >= word.length() || c != word.charAt(idx))
					return false;
				num = 0;
				idx++;
			}
		}

		return idx + num == word.length() ? true : false;
	}

}
