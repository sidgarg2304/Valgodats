package com.vishal.interviews.topinterviewquestions.easy;

public class CountandSay {

	public static void main(String[] args) {

	}

	public String countAndSay(int n) {
		if (n <= 0) {
			return "";
		}

		String prev = "1";
		for (int i = 2; i <= n; i++) {
			StringBuilder cur = new StringBuilder();
			int cnt = 1;
			char p = prev.charAt(0);
			for (int j = 1; j < prev.length(); j++) {
				char c = prev.charAt(j);
				if (c != p) {
					cur.append(cnt);
					cur.append(p);
					cnt = 1;
					p = c;
				} else {
					cnt++;
				}
			}
			cur.append(cnt);
			cur.append(p);
			prev = cur.toString();
		}
		return prev;
	}

}
