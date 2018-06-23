package com.vishal.interviews.salesforce;

import java.util.*;

/**
 * given char array = {a,a,a,a,b,b,b,c,c,d,d,,e,,f,f} output should be --
 * {a,4,b,3,c,2,d,2,e,f,2}, i.e. occurrences of every element followed by
 * character, without using other array.
 *
 */
public class FindCountOfEveryElement {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(findCountOfEveryElementLoop(
				new char[] { 'a', 'a', 'a', 'a', 'b', 'b', 'b', 'c', 'c', 'd', 'd', 'e', 'f', 'f' })));
	}

	static Object[] findCountOfEveryElementLoop(char[] arr) {

		int numUniqueElements = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[i - 1]) {
				numUniqueElements++;

			}
		}
		//consider last element
		numUniqueElements++;

		Object[] res = new Object[numUniqueElements * 2];
		int st = 0;
		int r = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[i - 1]) {
				res[r++] = arr[i - 1];
				res[r++] = i - st;
				st = i;
			}
		}
		//consider last element
		res[r++] = arr[arr.length - 1];
		res[r++] = arr.length - st;

		return res;
	}

	static List<Object[]> findCountOfEveryElementLoopList(char[] arr) {
		List<Object[]> res = new ArrayList<>();

		int st = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[i - 1]) {
				res.add(new Object[] { arr[i - 1], i - st });
				st = i;
			}
		}
		res.add(new Object[] { arr[arr.length - 1], arr.length - st });
		return res;
	}

	static Map<Character, Integer> findCountOfEveryElementHashMap(char[] arr) {
		Map<Character, Integer> res = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			res.put(arr[i], res.getOrDefault(arr[i], 0) + 1);
		}

		return res;
	}

}
