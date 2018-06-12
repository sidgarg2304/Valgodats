package com.vishal.interviews.salesforce;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import com.vishal.interviews.util.Interval;

/**
 * Minimum Number of Platforms Required for a Railway/Bus Station
 * 
 * https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-
 * station/
 * 
 * Given arrival and departure times of all trains that reach a railway station,
 * find the minimum number of platforms required for the railway station so that
 * no train waits. We are given two arrays which represent arrival and departure
 * times of trains that stop
 * 
 * Examples:
 * Input:  arr[]  = {9:00,  9:40, 9:50,  11:00, 15:00, 18:00}
           dep[]  = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
 * 
 * 
 * Output: 3 There are at-most three trains at a time (time between 11:00 to
 * 11:20)
 * 
 *
 */
public class NumberOfPlatforms {

	public static void main(String[] args) {
		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
		System.out.println(findPlatform(arr, dep, arr.length));
	}

	static int findPlatform(int arr[], int dep[], int n) {
		// Sort arrival and departure arrays
		Arrays.sort(arr);
		Arrays.sort(dep);

		// plat_needed indicates number of platforms
		// needed at a time
		int numOfPlatforms = 1, res = 1;
		int i = 1, j = 0;

		// Similar to merge in merge sort to process
		// all events in sorted order
		while (i < n && j < n) {
			// If next event in sorted order is arrival,
			// increment count of platforms needed
			if (arr[i] <= dep[j]) {
				numOfPlatforms++;
				i++;

				// Update result if needed
				if (numOfPlatforms > res)
					res = numOfPlatforms;
			}

			// Else decrement count of platforms needed
			else {
				numOfPlatforms--;
				j++;
			}
		}

		return res;
	}

	// Solution using Number of meetings using Min Heap
	static int findPlatformWithMinHeap(int arr[], int dep[], int n) {
		Interval[] intervals = new Interval[arr.length];
		for (int i = 0; i < arr.length; i++) {
			intervals[i] = new Interval(arr[i], dep[i]);
		}

		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.st - i2.st;
			}
		});

		int res = 1;

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		minHeap.offer(intervals[0].en);

		for (int i = 1; i < intervals.length; i++) {
			Interval c = intervals[i];

			if (c.st >= minHeap.peek()) {
				minHeap.poll();
			} else {
				res++;
			}
			minHeap.offer(c.en);
		}

		return res;
	}
}
