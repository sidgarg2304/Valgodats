package com.vishal.interviews.facebook.medium;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<>();

		List<List<String>> list = new ArrayList<>();

		dfs(s, 0, new ArrayList<>(), list);
		for (List<String> r : list) {
			StringBuilder sb = new StringBuilder();
			for (String str : r) {
				sb.append(str);
				sb.append(".");
			}
			sb.deleteCharAt(sb.length() - 1);
			res.add(sb.toString());
		}
		return res;
	}

	void dfs(String s, int p, List<String> temp, List<List<String>> res) {
		if (p == s.length() && temp.size() == 4) {
			res.add(new ArrayList<>(temp));
			return;
		}

		if (p >= s.length() || temp.size() > 4) {
			return;
		}

		for (int i = p; i < p + 3; i++) {
			if (i >= s.length()) {
				continue;
			}

			String sub = s.substring(p, i + 1);
			if (sub.startsWith("0") && sub.length() > 1) {
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
