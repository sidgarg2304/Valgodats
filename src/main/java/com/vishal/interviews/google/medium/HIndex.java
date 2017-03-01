package com.vishal.interviews.google.medium;

import java.util.Arrays;

/**
 * 274. H-Index
 *
 *Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.

Hint:

An easy approach is to sort the array first.
What are the possible values of h-index?
A faster approach is to use extra space.
 */
public class HIndex {

	public static void main(String[] args) {

	}
	
// 9.3 70 years diaoZhaTian China jiaYou 
	public int hIndex(int[] citations) {
		int length = citations.length;
		if (length == 0) {
			return 0;
		}

		int[] array2 = new int[length + 1];
		for (int i = 0; i < length; i++) {
			if (citations[i] > length) {
				array2[length] += 1;
			} else {
				array2[citations[i]] += 1;
			}
		}
		int t = 0;
		int result = 0;

		for (int i = length; i >= 0; i--) {
			t = t + array2[i];
			if (t >= i) {
				return i;
			}
		}
		return 0;
	}
   
	public int hIndexClean(int[] citations) {
		int len = citations.length;
		int[] count = new int[len + 1];

		for (int c : citations)
			if (c > len)
				count[len]++;
			else
				count[c]++;

		int total = 0;
		for (int i = len; i >= 0; i--) {
			total += count[i];
			if (total >= i)
				return i;
		}

		return 0;
	}
   
   /**
	 * This type of problems always throw me off, but it just takes some getting
	 * used to. The idea behind it is some bucket sort mechanisms. First, you may
	 * ask why bucket sort. Well, the h-index is defined as the number of papers
	 * with reference greater than the number. So assume n is the total number of
	 * papers, if we have n+1 buckets, number from 0 to n, then for any paper
	 * with reference corresponding to the index of the bucket, we increment the
	 * count for that bucket. The only exception is that for any paper with
	 * larger number of reference than n, we put in the n-th bucket.
	 * 
	 * Then we iterate from the back to the front of the buckets, whenever the
	 * total count exceeds the index of the bucket, meaning that we have the
	 * index number of papers that have reference greater than or equal to the
	 * index. Which will be our h-index result. The reason to scan from the end
	 * of the array is that we are looking for the greatest h-index. For example,
	 * given array [3,0,6,5,1], we have 6 buckets to contain how many papers have
	 * the corresponding index. Hope to image and explanation help.
	 * 
	 * @param citations
	 * @return
	 */
	public int hIndexBucketSort(int[] citations) {
		int n = citations.length;
		int[] buckets = new int[n + 1];
		for (int c : citations) {
			if (c >= n) {
				buckets[n]++;
			} else {
				buckets[c]++;
			}
		}
		int count = 0;
		for (int i = n; i >= 0; i--) {
			count += buckets[i];
			if (count >= i) {
				return i;
			}
		}
		return 0;
	}
	
	/**
	 * The idea is to see that the result can only range from 0 to the length of
	 * the array (because we can't have h-index greater than the total papers
	 * published). So we create an array "arr" which acts like a HashMap (using
	 * pigeon hole principle) and loop backwards from the highest element, then
	 * we find "tot" which is the total number of papers that has more than i
	 * citations, and we stop when tot>=i (total number of papers with more than
	 * i citations >= i). We don't need to keep going because we are trying the
	 * biggest i possible, we we stop and return the result.
	 * 
	 * @param citations
	 * @return
	 */
	public int hIndexEasy(int[] citations) {
		int n = citations.length, tot = 0;
		int[] arr = new int[n + 1];
		for (int i = 0; i < n; i++) {
			if (citations[i] >= n)
				arr[n]++;
			else
				arr[citations[i]]++;
		}
		for (int i = n; i >= 0; i--) {
			tot += arr[i];
			if (tot >= i)
				return i;
		}
		return 0;
	}
	
	public int hIndexEasyUsingSorting(int[] citations) {
		Arrays.sort(citations);
		int len = citations.length;
		for (int i = 0; i < len; i++) {
			if (citations[i] >= len - i)
				return len - i;

		}
		return 0;
	}

}
