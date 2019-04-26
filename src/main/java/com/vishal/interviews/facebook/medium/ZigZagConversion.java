package com.vishal.interviews.facebook.medium;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String convert(String s, int numRows) {

		if (numRows == 1) {
			return s;
		}

		List<StringBuilder> rows = new ArrayList<>();
		int curRow = 0;
		boolean goingDown = false;

		for (char c : s.toCharArray()) {
			if (curRow >= rows.size()) {
				StringBuilder sb = new StringBuilder();
				rows.add(sb);
			}
			rows.get(curRow).append(c);
			if (curRow == 0 || curRow == numRows - 1) {
				goingDown = !goingDown;
			}
			curRow += goingDown ? 1 : -1;
		}

		StringBuilder res = new StringBuilder();
		for (StringBuilder row : rows) {
			res.append(row.toString());
		}
		return res.toString();

	}

}
