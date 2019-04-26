package com.vishal.interviews.facebook.hard;

import java.util.*;

/**
 * 68. Text Justification
 * 
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.

Example 1:

Input:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Example 2:

Input:
words = ["What","must","be","acknowledgment","shall","be"]
maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be",
             because the last line must be left-justified instead of fully-justified.
             Note that the second line is also left-justified becase it contains only one word.
Example 3:

Input:
words = ["Science","is","what","we","understand","well","enough","to","explain",
         "to","a","computer.","Art","is","everything","else","we","do"]
maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
 *
 */
public class TextJustification {

	public static void main(String[] args) {

	}
	
	public List<String> fullJustify(String[] words, int maxWidth) {
      List<String> res = new ArrayList<>();

		int index = 0;

		while (index < words.length) {
			int count = words[index].length();

			int last = index + 1;
			while (last < words.length && count + words[last].length() + 1 <= maxWidth) {
				count += words[last].length() + 1;
				last++;
			}

			int diff = last - index - 1;
			StringBuilder sb = new StringBuilder();
			if (last == words.length || diff == 0) {
				for (int i = index; i < last; i++) {
					sb.append(words[i] + " ");
				}
				sb.deleteCharAt(sb.length() - 1);
				for (int i = sb.length(); i < maxWidth; i++) {
					sb.append(" ");
				}
			} else {

				int s = (maxWidth - count) / diff;
				int r = (maxWidth - count) % diff;

				for (int i = index; i < last; i++) {
					sb.append(words[i]);
					if (i < last - 1) {
						for(int j = 0; j<= (s + ((i - index) < r? 1: 0)); j++){
							sb.append(" ");
						}
					}
				}
			}
			res.add(sb.toString());
			index = last;
		}

		return res;
  }

}
