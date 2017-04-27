package com.vishal.interviews.google.easy;

/**
 * 541. Reverse String II
 * 
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
 */
public class ReverseStringII {

	public static void main(String[] args) {

	}
	
	static void reverse(String s, int k){
				
		int i = 0;
		
		while(i < s.length()){
			int j = Math.min(i+k-1, s.length()-1);
			reverse(s.toCharArray(), i, j);
			i += 2 *k;
		}
	}
	
	static void reverse(char[] a, int st, int en){
		while(st < en){
			char t = a[st];
			a[st++] = a[en];
			a[en--] = t;
		}
	}

}
