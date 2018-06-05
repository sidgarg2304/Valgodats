package com.vishal.interviews.topinterviewquestions.easy;

import java.util.*;

public class PascalsTriangle {

	public static void main(String[] args) {

	}

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<>();

		if(numRows <= 0){
			return res;
		}
		List<Integer> p = new ArrayList<>();
		p.add(1);

		res.add(p);
		for (int i = 1; i < numRows; i++) {
			List<Integer> c = new ArrayList<>();
			c.add(1);
			for (int j = 1; j < p.size(); j++) {
				c.add(p.get(j - 1) + p.get(j));
			}
			c.add(1);
			res.add(c);
			p = c;
		}
		return res;
	}

}
