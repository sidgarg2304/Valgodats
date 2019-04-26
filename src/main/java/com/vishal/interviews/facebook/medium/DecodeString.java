package com.vishal.interviews.facebook.medium;

import java.util.*;

/**
 * 394. Decode String
 * 
 * Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 *
 */
public class DecodeString {

	public static void main(String[] args) {

	}
	
	public String decodeStringRec(String s) {

		StringBuilder sb = new StringBuilder();
		String num = "";
		int i = 0;		
		while (i < s.length()) {
			char c = s.charAt(i);
			if (c == '[') {
				int count = 1;
				int en = i + 1;				
				while (en < s.length() && count != 0) {
					
					if (s.charAt(en) == '[') {
						count++;
					}

					if (s.charAt(en) == ']') {
						count--;
					}
					en++;
				}
				String insideBraces = decodeStringRec(s.substring(i + 1, en - 1));
				int numOfTimes = Integer.parseInt(num);
				num = "";
				for (int l = 0; l < numOfTimes; l++) {
					sb.append(insideBraces);
				}
				i = en;
			} else if (Character.isDigit(c)) {
				num += s.charAt(i);
				i++;
			} else {
				sb.append(c);
				i++;
			}
		}
		return sb.toString();
	}
	
	public String decodeString(String s) {
      if(s == null || s.length() == 0){
			return s;
		}
		
      Stack<String> stack = new Stack<>();
      Stack<Integer> countStack = new Stack<>();

      String res = "";
		int i = 0;
		while (i < s.length()) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
			    int en = i;
				while (Character.isDigit(s.charAt(en))) {
					en++;
				}
				int cnt = Integer.parseInt(s.substring(i, en));
				countStack.push(cnt);
				i = en-1;
			} else if (c == '['){
				stack.push(res);
				res = "";
			}else if (c == ']') {
				StringBuilder sb = new StringBuilder(stack.pop());
				int n = countStack.pop();				
				for (int j = 0; j < n; j++) {
					sb.append(res);
				}			
				res = sb.toString();
			} else{
				res += c;
			}			
			i++;
		}
		return res;
  }

}
