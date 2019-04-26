package com.vishal.interviews.uber.hard;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new ArrayList<>();
		if (words == null || words.length == 0) {
			return res;
		}

		int st = 0;
		while (st < words.length) {
			int en = st + 1;
			int len = words[st].length();

			while (en < words.length && 1 + len + words[en].length() < maxWidth) {
				en++;
			}

			int diff = en - st - 1;

			StringBuilder sb = new StringBuilder();
			if (diff == 0 || en == words.length) {
				for (int i = st; i < en; i++) {
					sb.append(words[i]);
					sb.append(" ");
				}
				sb.deleteCharAt(sb.length() - 1);
				for (int i = sb.length(); i < maxWidth; i++) {
					sb.append(" ");
				}
			} else {
				int q = (maxWidth - len) / diff;
				int r = (maxWidth - len) % diff;

				for (int i = st; i < en; i++) {
					sb.append(words[i]);
					if (i != en - 1) {
						for (int s = 0; s <= q + (i - st < r ? 1 : 0); s++) {
							sb.append(" ");
						}
					}
				}
			}

			res.add(sb.toString());
			st = en;
		}
		
		return res;
	}

}
