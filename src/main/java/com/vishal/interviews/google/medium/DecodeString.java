package com.vishal.interviews.google.medium;

import java.util.Stack;

/**
 * 394. Decode String
 * 
 * Given an encoded string, return it's decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any
 * digits and that digits are only for those repeat numbers, k. For example,
 * there won't be input like 3a or 2[4].
 * 
 * Examples:
 * 
 * s = "3[a]2[bc]", return "aaabcbc".
 * 
 * s = "3[a2[c]]", return "accaccacc".
 * 
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
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
	public String decodeStringUsingStack(String s) {
      String res = "";
      Stack<Integer> countStack = new Stack<>();
      Stack<String> resStack = new Stack<>();
      int idx = 0;
      while (idx < s.length()) {
          if (Character.isDigit(s.charAt(idx))) {
              int count = 0;
              while (Character.isDigit(s.charAt(idx))) {
                  count = 10 * count + (s.charAt(idx) - '0');
                  idx++;
              }
              countStack.push(count);
          }
          else if (s.charAt(idx) == '[') {
              resStack.push(res);
              res = "";
              idx++;
          }
          else if (s.charAt(idx) == ']') {
              StringBuilder temp = new StringBuilder (resStack.pop());
              int repeatTimes = countStack.pop();
              for (int i = 0; i < repeatTimes; i++) {
                  temp.append(res);
              }
              res = temp.toString();
              idx++;
          }
          else {
              res += s.charAt(idx++);
          }
      }
      return res;
  }
	
	/**
	 * Java short and easy-understanding solution using stack
	 * @param s
	 * @return
	 */
	public String decodeStringShortUsingStack(String s) {
      Stack<Integer> count = new Stack<>();
      Stack<String> result = new Stack<>();
      int i = 0;
      result.push("");
      while (i < s.length()) {
          char ch = s.charAt(i);
          if (ch >= '0' && ch <= '9') {
              int start = i;
              while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') i++;
              count.push(Integer.parseInt(s.substring(start, i + 1)));
          } else if (ch == '[') {
              result.push("");
          } else if (ch == ']') {
              String str = result.pop();
              StringBuilder sb = new StringBuilder();
              int times = count.pop();
              for (int j = 0; j < times; j += 1) {
                  sb.append(str);
              }
              result.push(result.pop() + sb.toString());
          } else {
              result.push(result.pop() + ch);
          }
          i += 1;
      }
      return result.pop();
  }
}
