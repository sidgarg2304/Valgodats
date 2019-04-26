package com.vishal.interviews.facebook.hard;

public class MedianofTwoSortedArrays {

	public static void main(String[] args) {

	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int n = nums1.length + nums2.length;

		if (n % 2 == 0) {
			// {1,2,3,4}
			// find 2nd and 3rd element
			return (findKthElement(nums1, 0, nums2, 0, n / 2) + findKthElement(nums1, 0, nums2, 0, n / 2 + 1)) / 2.0;
		} else {
			// {1,2,3}
			// find 2nd element
			return findKthElement(nums1, 0, nums2, 0, n / 2 + 1);
		}
	}

	int findKthElement(int[] nums1, int st1, int[] nums2, int st2, int k) {

		if (st1 >= nums1.length) {
			return nums2[st2 + k - 1];
		}

		if (st2 >= nums2.length) {
			return nums1[st1 + k - 1];
		}

		if (k == 1) {
			return Math.min(nums1[st1], nums2[st2]);
		}

		int m1 = st1 + k / 2 - 1;
		int m2 = st2 + k / 2 - 1;

		int mid1 = m1 < nums1.length ? nums1[m1] : Integer.MAX_VALUE;
		int mid2 = m2 < nums2.length ? nums2[m2] : Integer.MAX_VALUE;

		if (mid1 < mid2) {
			return findKthElement(nums1, m1 + 1, nums2, st2, k - k / 2);
		} else {
			return findKthElement(nums1, st1, nums2, m2 + 1, k - k / 2);
		}
	}

}
