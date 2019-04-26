package com.vishal.interviews.google.easy;

import java.util.*;

public class XofaKindinaDeckofCards {

	public static void main(String[] args) {
		XofaKindinaDeckofCards c = new XofaKindinaDeckofCards();
		System.out.println(c.hasGroupsSizeX(new int[] { 1, 1, 1, 1, 2, 2, 2, 2, 2, 2 }));
	}

	public boolean hasGroupsSizeX(int[] deck) {

		if (deck == null || deck.length < 2) {
			return false;
		}

		Map<Integer, Integer> map = new HashMap<>();

		for (int i : deck) {
			map.put(i, map.getOrDefault(i, 0) + 1);

		}		

		Search: for (int x = 2; x <= deck.length; x++) {
			if (deck.length % x == 0) {
				for (int i : map.values()) {
					if (i % x != 0) {
						continue Search;
					}
				}
				return true;
			}
		}
		return false;

	}

}
