package com.vishal.interviews.google.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 282. Expression Add Operators
 * 
 * Given a string that contains only digits 0-9 and a target value, return all
 * possibilities to add binary operators (not unary) +, -, or * between the
 * digits so they evaluate to the target value.
 * 
 * Examples:
 * 
 * "123", 6 -> ["1+2+3", "1*2*3"]
 * 
 * "232", 8 -> ["2*3+2", "2+3*2"]
 * 
 * "105", 5 -> ["1*0+5","10-5"]
 * 
 * "00", 0 -> ["0+0", "0-0", "0*0"]
 * 
 * "3456237490", 9191 -> []
 */
public class ExpressionAddOperators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/**
 * Java Standard Backtrace AC Solutoin, short and clear
 * 
 * This problem has a lot of edge cases to be considered:
 * 
 * overflow: we use a long type once it is larger than Integer.MAX_VALUE or
 * minimum, we get over it.
 * 
 * 0 sequence: because we can't have numbers with multiple digits started with
 * zero, we have to deal with it too.
 * 
 * a little trick is that we should save the value that is to be multiplied in
 * the next recursion.
 */
class ExpressionAddOperatorsUsingBackTrace {
	public List<String> addOperators(String num, int target) {
		List<String> rst = new ArrayList<String>();
		if (num == null || num.length() == 0)
			return rst;
		helper(rst, "", num, target, 0, 0, 0);
		return rst;
	}

	public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed) {
		if (pos == num.length()) {
			if (target == eval)
				rst.add(path);
			return;
		}
		for (int i = pos; i < num.length(); i++) {
			if (i != pos && num.charAt(pos) == '0')
				break;
			long cur = Long.parseLong(num.substring(pos, i + 1));
			if (pos == 0) {
				helper(rst, path + cur, num, target, i + 1, cur, cur);
			} else {
				helper(rst, path + "+" + cur, num, target, i + 1, eval + cur, cur);

				helper(rst, path + "-" + cur, num, target, i + 1, eval - cur, -cur);

				helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
			}
		}
	}
}

/**
 * Java AC solution, 19ms, beat 100.00%.
 * 
 */
class ExpressionAddOperatorsUsingDFS{
	void dfs(List<String> ret, char[] path, int len, long left, long cur, char[] digits, int pos, int target) {
	    if (pos == digits.length) {
	        if (left + cur == target) ret.add(new String(path, 0, len));
	        return;
	    }
	    long n = 0;
	    int j = len + 1;
	    for (int i = pos; i < digits.length; i++) {
	        n = n * 10 + digits[i] - '0';
	        path[j++] = digits[i];
	        path[len] = '+';
	        dfs(ret, path, j, left + cur, n, digits, i + 1, target);
	        path[len] = '-';
	        dfs(ret, path, j, left + cur, -n, digits, i + 1, target);
	        path[len] = '*';
	        dfs(ret, path, j, left, cur * n, digits, i + 1, target);
	        if (digits[pos] == '0') break; 
	    }
	}
	public List<String> addOperators(String num, int target) {
	    List<String> ret = new LinkedList<>();
	    if (num.length() == 0) return ret;
	    char[] path = new char[num.length() * 2 - 1];
	    char[] digits = num.toCharArray();
	    long n = 0;
	    for (int i = 0; i < digits.length; i++) {
	        n = n * 10 + digits[i] - '0';
	        path[i] = digits[i];
	        dfs(ret, path, i + 1, 0, n, digits, i + 1, target);
	        if (n == 0) break;
	    }
	    return ret;
	}
}