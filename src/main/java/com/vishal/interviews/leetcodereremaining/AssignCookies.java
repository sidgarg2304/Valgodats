package com.vishal.interviews.leetcodereremaining;

import java.util.Arrays;

public class AssignCookies {

	public static void main(String[] args) {

	}

	public int findContentChildren(int[] g, int[] s) {

		Arrays.sort(g);
		Arrays.sort(s);
		
		int res = 0;
		
		int i = 0;
		int j = 0;
		while(i < g.length && j<s.length){
			if(g[i] <= s[j]){
				res++;
			}
			i++;
			j++;
		}
		
		return res;
	}

}
