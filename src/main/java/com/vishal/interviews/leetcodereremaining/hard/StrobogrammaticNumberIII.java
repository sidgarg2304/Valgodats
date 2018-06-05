package com.vishal.interviews.leetcodereremaining.hard;

import java.util.*;

public class StrobogrammaticNumberIII {

	public static void main(String[] args) {

	}

	public int strobogrammaticInRange(String low, String high) {

		for (int len = low.length(); len <= high.length(); len++) {
			dfs(low, high, new char[len], 0, len - 1);
		}
		
		return cnt;
	}

	int cnt = 0;
	char[][] pairs = new char[][] { { '0', '0' }, { '1', '1' }, { '6', '9' }, { '8', '8' }, { '9', '6' } };

	void dfs(String low, String high, char[] temp, int leftPos, int rightPos) {
		if (leftPos > rightPos) {

			String cur = String.valueOf(temp);
			if ((cur.length() == low.length() && cur.compareTo(low) < 0)
					|| (cur.length() == high.length() && cur.compareTo(high) > 0)) {
				return;
			}
			cnt++;
			return;
		}

		for (char[] pair : pairs) {
			temp[leftPos] = pair[0];
			temp[rightPos] = pair[1];

			if (temp.length != 1 && temp[0] == '0') {
				continue;
			}
			
			if (leftPos == rightPos && pair[0] != pair[1]) {
				continue;
			}

			dfs(low, high, temp, leftPos + 1, rightPos - 1);
		}
	}

}
