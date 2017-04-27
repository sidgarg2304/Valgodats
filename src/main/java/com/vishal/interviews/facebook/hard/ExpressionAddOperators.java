package com.vishal.interviews.facebook.hard;

import java.util.*;

/**
 * 282. Expression Add Operators
 * 
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Examples: 
"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
 *
 */
public class ExpressionAddOperators {

	public static void main(String[] args) {

	}

	public List<String> addOperators(String num, int target) {
		List<String> res = new ArrayList<>();

		if(num == null || num.length() == 0){
			return res;
		}
		
		dfs(num, target, 0, "", res, 0,0);
		return res;

	}

	static void dfs(String num, int target, int pos, String path, List<String> res, long eval, long mul) {
		
		if(pos == num.length()){
			if(eval == target){
				res.add(path);
			}
			return;
		}

		for (int i = pos; i < num.length(); i++) {

			Long cur = Long.valueOf(num.substring(pos, i + 1));
			if (pos == 0) {
				dfs(num, target, i + 1, path + cur, res, cur, cur);
			} else {
				dfs(num, target, i + 1, path + "+" + cur, res, eval+cur, cur);
				dfs(num, target, i + 1, path + "-" + cur, res, eval - cur, cur);
				dfs(num, target, i + 1, path + "*" + cur, res, (eval - mul) + (mul * cur), (mul * cur));
			}
		}

	}

}
