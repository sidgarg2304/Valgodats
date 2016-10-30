package com.vishal.algorithms.array.prefixsum;

public class ArrayPrefixSumAlgorithms {

	public static void main(String[] args) {
		testNumOfPassingCars();
		testnumOfDivisibleNumbers();

	}

	public static void testNumOfPassingCars() {
		int[] cars = new int[] { 0, 1, 0, 1, 1 };
		System.out.println(numOfPassingCars(cars));
	}
	
	public static void testnumOfDivisibleNumbers(){
		System.out.println(numOfDivisibleNumbers(6,11,2));
		System.out.println(numOfDivisibleNumbers(6,13,3));
	}

	public static int numOfPassingCars(int[] cars) {
		int numOfPassingCars = 0;

		int numOfCarsWith1 = 0;
		for (int i = cars.length - 1; i >= 0; i--) {
			if (cars[i] == 1) {
				numOfCarsWith1 += 1;
			} else {
				numOfPassingCars += numOfCarsWith1;
			}
		}

		return numOfPassingCars;
	}

	// 6 11 - 6 8 10
	public static int numOfDivisibleNumbers(int st, int en, int k) {
		int res = 0;

		int diff = en-st;
		res = diff/k;
		if(st % k == 0){
			res++;
		}
		return res;
	}

}
