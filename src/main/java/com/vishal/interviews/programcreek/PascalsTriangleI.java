package com.vishal.interviews.programcreek;

import java.util.*;

/**
 * Given numRows, generate the first numRows of Pascal's triangle. For example, given numRows = 5, the result should be:

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]*
 */
public class PascalsTriangleI {

	public static void main(String[] args) {

		System.out.println(generate(5));
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<>();
		
		if(numRows == 0){
			return res;
		}

		List<Integer> row = new ArrayList<>();
		row.add(1);

		res.add(row);

		for (int i = 1; i < numRows; i++) {
			List<Integer> curRow = new ArrayList<>();
			curRow.add(1);

			for (int j = 1; j < row.size(); j++) {
				curRow.add(row.get(j) + row.get(j - 1));
			}

			curRow.add(1);

			res.add(curRow);
			row = curRow;
		}

		return res;
	}
}
