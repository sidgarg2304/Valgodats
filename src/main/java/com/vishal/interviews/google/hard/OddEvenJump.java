package com.vishal.interviews.google.hard;

import java.util.*;

public class OddEvenJump {

	public static void main(String[] args) {
		OddEvenJump o = new OddEvenJump();
		System.out.println(o.oddEvenJumps(new int[] { 10, 13, 12, 14, 15 }));

		// System.out.println("*************");
		// System.out.println(o.oddEvenJumps2(new int[] { 10, 13, 12, 14, 15 }));
	}

	// from any index u can make 1st jump, 2nd jump, 3rd jump and 4th jump and so on
	// 1st jump -> to a position which is the next immediate greater/equal number
	// 2nd jump -> to a position which is the next immediate lesser/equal number
	// 3rd jump -> to a position which is the next immediate greater/equal number
	// 4th jump -> to a position which is the next immediate lesser/equal number
	public int oddEvenJumps(int[] A) {
		int n = A.length;
		boolean[] oddJumpToHigerVal = new boolean[n];
		boolean[] evenJumpToLowerVal = new boolean[n];

		// since we are at last index, set both of them to true and by default res
		// is 1 as last index is one of the results
		oddJumpToHigerVal[n - 1] = true;
		evenJumpToLowerVal[n - 1] = true;
		int res = 1;

		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(A[n - 1], n - 1);
		for (int i = n - 2; i >= 0; i--) {
			Integer hi = map.ceilingKey(A[i]); // gives next immediate greater/equal number
			Integer low = map.floorKey(A[i]); // gives next immediate lesser/equal number

			if (hi != null) {
				oddJumpToHigerVal[i] = evenJumpToLowerVal[map.get(hi)];
			}
			if (low != null) {
				evenJumpToLowerVal[i] = oddJumpToHigerVal[map.get(low)];
			}

			// Since we have to make the first (odd) jump to higher value we
			// increment res only if we can make that jump
			if (oddJumpToHigerVal[i]) {
				res++;
			}
			map.put(A[i], i);
		}
		return res;
	}

	public int oddEvenJumps2(int[] A) {
		int n = A.length, res = 1;
		boolean[] higher = new boolean[n], lower = new boolean[n];
		higher[n - 1] = lower[n - 1] = true;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(A[n - 1], n - 1);
		for (int i = n - 2; i >= 0; --i) {
			Integer hi = map.ceilingKey(A[i]);
			Integer lo = map.floorKey(A[i]);
			// System.out.println("hi for " + A[i] + " is " + hi);
			System.out.println("low for " + A[i] + " is " + lo);
			if (hi != null)
				higher[i] = lower[(int) map.get(hi)];
			if (lo != null)
				lower[i] = higher[(int) map.get(lo)];
			if (higher[i])
				res++;
			map.put(A[i], i);
		}
		return res;
	}

}
