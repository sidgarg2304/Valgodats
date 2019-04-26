package com.vishal.interviews.facebook.hard;

public class StrobogrammaticNumberIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int res = 0;
	char[][] pairs = new char[][] { { '0', '0' }, { '1', '1' }, { '6', '9' }, { '8', '8' }, { '9', '6' } };

	public int strobogrammaticInRange(String low, String high) {

		for (int len = low.length(); len <= high.length(); len++) {
			dfs(low, high, new char[len], 0, len - 1);
		}
		return res;
	}

	void dfs(String low, String high, char[] cur, int st, int en) {

		if (st > en) {
			String curStr = String.valueOf(cur);			
			if ((curStr.length() == low.length() && curStr.compareTo(low) < 0)
					|| (curStr.length() == high.length() && curStr.compareTo(high) > 0)) {
				return;
			}
			res++;
			return;
		}

		for (char[] pair : pairs) {
			cur[st] = pair[0];
			cur[en] = pair[1];

			if (cur.length != 1 && cur[0] == '0') {
				continue;
			}
			
			if (st == en && pair[0] != pair[1]) {
				continue;
			}

			dfs(low, high, cur, st + 1, en - 1);
		}
	}

}
