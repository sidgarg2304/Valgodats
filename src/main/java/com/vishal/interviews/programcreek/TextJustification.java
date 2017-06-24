package com.vishal.interviews.programcreek;

import java.util.*;

public class TextJustification {

	public static void main(String[] args) {

	}

	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new ArrayList<>();

		int index = 0;
		while (index < words.length) {
			int last = index + 1;

			int count = words[index].length();

			while (last < words.length && count + words[last].length() + 1 <= maxWidth) {
				count += words[last].length() + 1;
				last++;
			}

			int diff = last - index - 1;
			StringBuilder sb = new StringBuilder();
			if (last == words.length || diff == 0) {
				for (int i = index; i < last; i++) {
					sb.append(words[i]);
					sb.append(" ");
				}
				sb.deleteCharAt(sb.length() - 1);
				for (int i = sb.length(); i < maxWidth; i++) {
					sb.append(" ");
				}
				res.add(sb.toString());
			} else {
				int s = (maxWidth - count) / diff;
				int r = (maxWidth - count) % diff;

				for (int i = index; i < last; i++) {
					sb.append(words[i]);

					if (i < last - 1) {
						for (int j = 0; j <= s + (i - index < r ? 1 : 0); j++) {
							sb.append(" ");
						}
					}
				}
			}

			index = last;
		}
		
		return res;
	}

}
