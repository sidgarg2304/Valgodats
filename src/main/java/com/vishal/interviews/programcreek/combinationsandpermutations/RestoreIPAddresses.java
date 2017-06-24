package com.vishal.interviews.programcreek.combinationsandpermutations;

import java.util.*;

public class RestoreIPAddresses {

	public static void main(String[] args) {

		System.out.println(restoreIpAddresses("25525511135"));
	}

	public static List<String> restoreIpAddresses(String s) {
		List<String> finalRes = new ArrayList<>();

		List<List<String>> res = new ArrayList<>();

		dfs(s, 0, new ArrayList<String>(), res);

		for (List<String> r : res) {
			
			StringBuilder sb = new StringBuilder();
			for (String a : r) {
				sb.append(a);
				sb.append(".");
			}
			sb.deleteCharAt(sb.length() - 1);
			finalRes.add(sb.toString());
		}

		return finalRes;
	}

	static void dfs(String s, int pos, List<String> temp, List<List<String>> res) {

		
		if (temp.size() == 4 && pos == s.length()) {
			res.add(new ArrayList<>(temp));
			return;
		}

		if (pos >= s.length() || temp.size() > 4) {
			return;
		}

		for (int i = pos; i < pos + 3; i++) {

			if (i >= s.length()) {
				continue;
			}
			
			String sub = s.substring(pos, i + 1);
			
			if(sub.startsWith("0") && sub.length() > 1){
				continue;
			}
			int val = Integer.parseInt(sub);
			if (val >= 0 && val <= 255) {
				temp.add(sub);
				dfs(s, i + 1, temp, res);
				temp.remove(temp.size() - 1);
			}
		}
	}

}
