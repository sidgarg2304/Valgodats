package com.vishal.algorithms.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ArrayBasicAlgorithms {

	public static void main(String[] args) {

		int[] a = { 1, 1, 1, 2, 2, 4, 5 };
		System.out.println("Input array is " + Arrays.toString(a));

		secLargestElement(a);

		secondMostFrequentNumber(a);

		maxProdOf3Elements(a);

		reverseArray(a);

	}

	public static void secLargestElement(int[] a) {

		int resMax = Integer.MIN_VALUE;
		int resSecMax = Integer.MIN_VALUE;

		for (int i = 0; i < a.length; i++) {
			if (a[i] > resMax) {
				resSecMax = resMax;
				resMax = a[i];
			} else if (a[i] > resSecMax) {
				resSecMax = a[i];
			}
		}

		System.out.println("sec max element is " + resSecMax);

	}

	public static void secondMostFrequentNumber(int[] a) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = Integer.MIN_VALUE;
		int secMax = Integer.MIN_VALUE;
		int maxVal = -100;
		int secMaxVal = -100; // This will be the final result
		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i])) {
				map.put(a[i], map.get(a[i]) + 1);
			} else {
				map.put(a[i], 1);
			}

		}
		for (Integer p : map.keySet()) {
			if (map.get(p) > max) {
				secMax = max;
				secMaxVal = maxVal;
				max = map.get(p);
				maxVal = p;
			} else if (map.get(p) > secMax) {
				secMax = map.get(p);
				secMaxVal = p;
			}
		}

		System.out.println("sec most frequent value is " + secMaxVal);
	}

	public static void maxProdOf3Elements(int[] a) {
		Arrays.sort(a);

		int max1 = a[a.length - 1] * a[a.length - 2] * a[a.length - 3];

		int max2 = a[a.length - 1] * a[0] * a[1];

		int res = max1 > max2 ? max1 : max2;

		System.out.println("Max product of 3 numbers " + res);
	}

	public static void reverseArray(int[] a) {
		int i = 0;
		int j = a.length - 1;

		while (i < j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}

		System.out.println("reverse array is " + Arrays.toString(a));
	}

	public static void addIntegersInArrays(int[] a1, int[] a2) {

		int[] res = new int[a1.length + a2.length];

		int l = a1.length < a2.length ? a1.length : a2.length;

		int j = 0;
		int i = 0;
		for (i = 0; i < l; i++) {
			int resVal = a1[i] + a2[i];
			if (resVal < 10) {
				res[j] = resVal;
				j++;
			} else {
				res[j] = resVal / 10;
				res[j + 1] = resVal % 10;
				j += 2;
			}
		}
		while (i < a1.length) {
			res[j++] = a1[i];
			i++;
		}

		while (i < a2.length) {
			res[j++] = a2[i];
			i++;
		}

		System.out.println(Arrays.toString(res));
	}

	// 0 1 2
	// 3 4 5
	public static void reverseSubsetArr(int[] a, int n) {

		int[] res = new int[a.length];

		int i = 0;

		while (i + n <= a.length) {
			res[i + n - 1] = a[i];
			res[i + n - 2] = a[i + 1];
			res[i + n - 3] = a[i + 2];
			i = i + n;
		}

		System.out.println(Arrays.toString(res));
	}

	public static void findNextGreatest(int[] a1, int[] a2) {

		int[] res = new int[a1.length];
		Map<Integer, Integer> map = new HashMap<>();
		Stack<Integer> stack = new Stack<>();

		for (int i : a2) {
			while (!stack.isEmpty() && stack.peek() < i) {
				map.put(stack.pop(), i);
			}
			stack.push(i);
		}

		for (int i = 0; i < a1.length; i++) {
			res[i] = -1;
			if (map.containsKey(a1[i])) {
				res[i] = map.get(a1[i]);
			}
		}
	}
}
