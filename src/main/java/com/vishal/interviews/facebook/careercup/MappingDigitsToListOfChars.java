package com.vishal.interviews.facebook.careercup;

import java.util.*;

/**
 * Given a mapping from digits to list of letters and a string of digits of arbitrary length determine all possible ways to replace the digits with letters. 

Input Mapping = { 

'1' → ['A', 'B', 'C'], 

'2' → ['D', 'E', 'F'], 

... 

} 

Avg length of map values - N 

Input String = “12” - K 
Expected Output = [“AD”, “AE”, “AF”, “BD”, “BE”, “BF”, “CD”, “CE”, “CF”]
 *
 */
public class MappingDigitsToListOfChars {

	public static void main(String[] args) {

		System.out.println(mapDigits("12"));
		System.out.println(mapDigitsBFS("12"));
	}

	static List<String> mapDigitsBFS(String s) {
		List<String> res = new ArrayList<>();

		String[] map = { "", "ABC", "DEF" };
		Queue<String> queue = new LinkedList<>();
		queue.offer("");

		for (int i = 0; i < s.length(); i++) {
			String cur = map[s.charAt(i) - '0'];
			int l = queue.size();
			for (int j = 0; j < l; j++) {
				String prev = queue.poll();
				for (int k = 0; k < cur.length(); k++) {
					queue.offer(prev + cur.charAt(k));
				}
			}
		}

		res.addAll(queue);
		return res;
	}

	static List<String> mapDigits(String s) {
		Map<Integer, char[]> map = new HashMap<>();
		map.put(1, new char[] { 'A', 'B', 'C' });
		map.put(2, new char[] { 'D', 'E', 'F' });

		List<String> res = new ArrayList<>();

		dfs(s, "", 0, map, res);
		return res;
	}

	static void dfs(String s, String cur, int pos, Map<Integer, char[]> map, List<String> res) {
		if (cur.length() == s.length()) {
			res.add(cur);
			return;
		}

		int c = s.charAt(pos) - '0';
		char[] arr = map.get(c);
		for (int i = 0; i < arr.length; i++) {
			cur += arr[i];
			dfs(s, cur, pos + 1, map, res);
			cur = cur.substring(0, cur.length() - 1);
		}
	}

}
