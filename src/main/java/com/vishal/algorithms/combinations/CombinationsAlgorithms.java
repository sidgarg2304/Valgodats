package com.vishal.algorithms.combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationsAlgorithms {

	public static void main(String[] args) {
		// splitNumberIntoCombinations(4);
		// splitNumberIntoCombinationsWithoutDups(5);
		// int[] a = { 3, 5, 8 };
		// combinations(a);

		testcombinations();

		testgetPermutation();
		
		testcombinationsOfKNumbers();

	}

	public static void testcombinations() {
		combinations(new int[] { 1, 2, 3 });
	}

	public static void testgetPermutation() {
		getPermutation(4, 14);
	}
	
	public static void testcombinationsOfKNumbers(){
		combinationsOfKNumbers(4,2);
	}

	public static String getPermutation(int n, int k) {

		// initialize all numbers
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			numberList.add(i);
		}

		// change k to be index
		k--;

		// set factorial of n
		int curNumsFactorial = 1;
		for (int i = 1; i <= n; i++) {
			curNumsFactorial = curNumsFactorial * i;
		}

		String result = "";

		// find sequence
		for (int i = 0; i < n; i++) {

			int curNumOfElements = n - i; // 4
			// which is also same as factorial of other elements // 24/4 = 6
			int numOfElementsInBox = curNumsFactorial / curNumOfElements;

			// 15/6 = 2. This means that this is the 3rd box and the first element
			// of 3rd box would be the 3rd element which is at position 2
			int boxNumber = k / numOfElementsInBox;

			// get number according to curIndex
			result += numberList.get(boxNumber);
			// remove from list
			numberList.remove(boxNumber);

			// inside 3rd box, there are 6 combinations of 3 elements.
			// 15th position of main box would be 3rd position of this 6 elements
			// box
			k = k % numOfElementsInBox;
			curNumsFactorial = numOfElementsInBox;
		}

		return result.toString();
	}

	public static void combinations(int[] a) {
		List<List<Integer>> combinations = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();

		for (int i : a) {
			list.add(i);
		}
		combinations(list, new ArrayList<Integer>(), combinations);

		System.out.println("combinations " + combinations);
	}

	public static void combinations(List<Integer> a, List<Integer> temp, List<List<Integer>> combinations) {

		if (a.isEmpty()) {
			List<Integer> newCombinationFound = new ArrayList<Integer>();
			newCombinationFound.addAll(temp); // Copy temp elements to new list
														 // object

			combinations.add(newCombinationFound); // place this new combination to
																// the result list
			return;
		}
		for (int i = 0; i < a.size(); i++) {
			int val = a.get(i);
			temp.add(a.get(i));
			a.remove(i);
			combinations(a, temp, combinations);
			temp.remove(temp.size() - 1);
			a.add(i, val);
		}
	}

	public static void combinationsOfKNumbers(int n, int k) {

		List<List<Integer>> result = new ArrayList<>();
		combinationsOfKNumbers(n, k, new ArrayList<Integer>(), result, 1);
		
		System.out.println("combinations of k elements are " + result);
	}

	public static void combinationsOfKNumbers(int n, int k, List<Integer> temp, List<List<Integer>> result, int start) {
		
		if(temp.size() == 2){
			List<Integer> curResult = new ArrayList<>();
			curResult.addAll(temp);
			result.add(curResult);
			return;
		}

		for(int i = start;i<=n;i++){
			temp.add(i);
			combinationsOfKNumbers(n, k, temp, result, i+1);
			temp.remove(temp.size()-1);
		}
		
		
	}

	public static void splitNumberIntoCombinations(int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		splitNumberIntoCombinations(n, new ArrayList<Integer>(), result);
		for (List<Integer> temp : result) {
			System.out.println(temp);
		}
	}

	private static void splitNumberIntoCombinations(int n, List<Integer> temp, List<List<Integer>> result) {
		if (n == 0) {
			List<Integer> list = new ArrayList<Integer>();
			list.addAll(temp); // copy temp elements to new array list
			result.add(list);
			return;
		}

		// for (int i = 1; i <= n - t; i++) {
		// temp.add(i);
		// combinations(n, t + i, temp, result);
		// temp.remove(temp.size() - 1);
		// }

		for (int i = 1; i <= n; i++) {
			temp.add(i);
			splitNumberIntoCombinations(n - i, temp, result);
			temp.remove(temp.size() - 1);
		}
	}

	// Create a result List of List
	// Create a temp empty list
	// Create a recursive function which takes result , temp, input and any
	// additional required variables
	// inside recursive function

	// interate over input array , add one element to temp, call the same
	// function again and then remove the last added element from tmep
	// when you hit boundary condition, copy temp elements to new arraylist and
	// place this new list inside result but place this logic before above for
	// loop

	static void splitNumberIntoCombinationsWithoutDups(int n) {
		int[] p = new int[n];

		int k = 0;

		p[k] = n; // {5,0,0,0, 0}

		while (true) {
			System.out.println(Arrays.toString(p) + " with k " + k);
			printArray(p, k + 1); // 4

			int remVal = 0;
			// Whenever we have 1 in p[k], use this value to decrement p[k-1] and
			// add back p[k] with another 1
			// This while loop adds rem value and takes k position back so that
			// next code will make {3,1,0,0} -> {2,2,0,0}.
			while (k >= 0 && p[k] == 1) {
				System.out.println("entered while loop");
				remVal += p[k];
				k--;
			}

			// if k < 0, all the values are 1 so there are no more partitions
			if (k < 0)
				return;

			// Decrease the p[k] found above and adjust the remVal
			p[k]--; // {4,0,0,0,0}
			remVal++; // 1

			// If remVal is more, then the sorted order is violated. Divide
			// rem_val in differnt values of size p[k] and copy these values at
			// different positions after p[k]
			// 2 1 1
			// k = 0 and 1 1 1
			// remVal = 3
			// 1 1 1, k = 1
			// remVal = 2
			while (remVal > p[k]) {
				System.out.println("entered sec while loop " + " remVal is " + remVal + " and k is " + k);
				p[k + 1] = p[k];
				remVal = remVal - p[k];
				k++;
			}

			// Copy rem_val to next position and increment position
			p[k + 1] = remVal;
			k++;

		}
	}

	static void printArray(int[] p, int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(p[i] + " ");
		}
		System.out.println("");
	}
}