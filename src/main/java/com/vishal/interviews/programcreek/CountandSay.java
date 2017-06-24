package com.vishal.interviews.programcreek;

// 1 11 21 1211 111221 312211
public class CountandSay {

	public static void main(String[] args) {

		System.out.println(countAndSay(5));
	}

	public static String countAndSay(int n) {
		if (n <= 0) {
			return "";
		}

		String res = "1";

		for (int i = 1; i < n; i++) {
			StringBuilder cur = new StringBuilder();
			int cnt = 1;
			for (int j = 1; j < res.length(); j++) {
				char p = res.charAt(j - 1);
				char c = res.charAt(j);
				if (p == c) {
					cnt++;
				} else {
					cur.append(cnt);
					cur.append(p);
					cnt = 1;
				}
			}

			cur.append(cnt);
			cur.append(res.charAt(res.length()-1));
			
			res = cur.toString();
		}

		return res;
	}

}
