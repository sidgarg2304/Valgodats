package com.vishal.interviews.linkedin.hard;

import java.util.*;
/**
 * 68. Text Justification
 * 
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.
 */
public class TextJustification {

	public static void main(String[] args) {

		textJustified(new String[] { "This", "is", "an", "example", "of", "text", "justification." }, 16);
	}

	static List<String> textJustified(String[] words, int l) {
		int index = 0;

		List<String> lines = new ArrayList<>();
		while (index < words.length) {

			StringBuilder line = new StringBuilder();
			int last = index + 1;
			int count = words[index].length();
			while (last < words.length) {
				if (count + words[last].length() + 1 >= l) {
					break;
				}
				count += words[last].length() + 1;
				last++;
			}

			int diff = last - index - 1;
			// single word or all the words are done
			if (last == words.length || diff == 0) {

				for (int i = index; i < last; i++) {
					line.append(words[i]);
				}

				// append remaining spaces to the end of the string
				for (int i = line.length(); i < l; i++) {
					line.append(" ");
				}

			} else {
				// append spaces between words
				int spaces = (l - count) / diff;
				int r = (l - count) % diff;
				System.out.println("spaces is " + spaces + " and r is " + r);
				for (int i = index; i < last; i++) {
					line.append(words[i]);
					if (i < last - 1) { // for all the words except last one
						for (int j = 0; j <= (spaces + ((i - index) < r ? 1 : 0)); j++) {
							line.append(" ");
						}
					}
				}
			}

			lines.add(line.toString());
			index = last; // last is next start index

		}

		return lines;
	}

}
