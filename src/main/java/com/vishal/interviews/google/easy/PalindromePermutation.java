package com.vishal.interviews.google.easy;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/**
 * 266
 * 
 * Given a string, determine if a permutation of the string could form a
 * palindrome.
 * 
 * For example, "code" -> False, "aab" -> True, "carerac" -> True.
 *
 */
public class PalindromePermutation {

	public static void main(String[] args) {

	}

	/**
	 * Java solution w/Set, one pass, without counters.
	 * 
	 * The idea is to iterate over string, adding current character to set if set
	 * doesn't contain that character, or removing current character from set if
	 * set contains it. When the iteration is finished, just return set.size()==0
	 * || set.size()==1.
	 * 
	 * set.size()==0 corresponds to the situation when there are even number of
	 * any character in the string, and set.size()==1 corresponds to the fact
	 * that there are even number of any character except one.
	 * 
	 * @param s
	 * @return
	 */
	public boolean canPermutePalindrome(String s) {
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < s.length(); ++i) {
			if (!set.contains(s.charAt(i)))
				set.add(s.charAt(i));
			else
				set.remove(s.charAt(i));
		}
		return set.size() == 0 || set.size() == 1;
	}

	/**
	 * Just check that no more than one character appears an odd number of times.
	 * Because if there is one, then it must be in the middle of the palindrome.
	 * So we can't have two of them.
	 * 
	 * @param s
	 * @return
	 */
	public boolean canPermutePalindromeUsingBitSet(String s) {
		BitSet bs = new BitSet();
		for (byte b : s.getBytes())
			bs.flip(b);
		return bs.cardinality() < 2;
	}

	/**
	 * Explanation
	 * 
	 * The basic idea is using HashSet to find the number of single characters,
	 * which should be at most 1.
	 * 
	 * @param s
	 * @return
	 */
	public boolean canPermutePalindromeSimple(String s) {
		Set<Character> set = new HashSet<Character>();
		for (char c : s.toCharArray())
			if (set.contains(c))
				set.remove(c);// If char already exists in set, then remove it from
								  // set
			else
				set.add(c);// If char doesn't exists in set, then add it to set
		return set.size() <= 1;
	}

	/**
	 * Java AC 8 lines
	 * 
	 * @param s
	 * @return
	 */
	public boolean canPermutePalindromeAC(String s) {
		char[] A = new char[256];
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (A[s.charAt(i)] > 0)
				A[s.charAt(i)]--;
			else
				A[s.charAt(i)]++;
		}
		for (int i = 0; i < 256; i++) {
			if (A[i] != 0)
				count++;
		}
		return count <= 1;
	}

}
