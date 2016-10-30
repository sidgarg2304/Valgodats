package com.vishal.algorithms.pattern;

public class PatternMatchingAlgorithms {

	public static void main(String[] args) {
		testWildCardMatching();
		testPatternMatching();
	}

	public static void testWildCardMatching() {
		System.out.println("String abcdcdf " + (wildCardMatching("abcdcdf", "?b*cdf") ? "" : "does not ")
				+ "match with the wildcard pattern ?b*cdf");
		System.out.println("String abcdcdf " + (wildCardMatching("abcdcdf", "?b*cdfg") ? "" : "does not ")
				+ "match with the wildcard pattern ?b*cdfg");
	}

	public static void testPatternMatching() {
		System.out.println("String cccdef " + (patternMatching("cccdef", "c*d.f") ? "" : "does not ")
				+ "match with the pattern c*d.f");
		System.out.println("String cccdef " + (patternMatching("cccdef", "c*d.fh") ? "" : "does not ")
				+ "match with the pattern c*d.fh");
	}

	// abcdcdf
	// ?b*cdf
	public static boolean wildCardMatching(String s, String p) {
		int i = 0;
		int j = 0;
		int starIndex = -1;
		int iIndex = -1;

		while (i < s.length()) {
			if (j < p.length() && s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
				i++;
				j++;
			} else if (j < p.length() && p.charAt(j) == '*') {
				starIndex = j;
				iIndex = i;
				j++;
			} else if (starIndex != -1) {
				j = starIndex + 1;
				i = iIndex + 1;
				iIndex++;
			} else {
				return false;
			}
		}

		while (j < p.length() && p.charAt(j) == '*') {
			j++;
		}

		return j == p.length();
	}

	public static boolean patternMatching(String s, String p) {
		if (p.length() == 0) {
			return s.length() == 0;
		}

		if (p.length() == 1 || p.charAt(1) != '*') {
			if (s.length() > 0 && s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
				return patternMatching(s.substring(1), p.substring(1));
			} else {
				return false;
			}
		} else {

			// Match complete string with remaining pattern after *
			if (patternMatching(s, p.substring(2))) {
				return true;
			}

			// Keep removing one character at a time as long as it matches with first char of pattern 
			int i = 0;
			while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
				if (patternMatching(s.substring(i + 1), p.substring(2))) {
					return true;
				}
				i++;
			}

		}
		return false;
	}

}
