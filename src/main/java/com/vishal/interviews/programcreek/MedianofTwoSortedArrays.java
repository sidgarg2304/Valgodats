package com.vishal.interviews.programcreek;

public class MedianofTwoSortedArrays {

	public static void main(String[] args) {

	}

	// 1 2 3
	// 4 5
	// 1 2 3 4 5
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int l1 = nums1.length;
		int l2 = nums2.length;

		int l = l1 + l2;

		if (l % 2 == 0) {
			return (findKthElement(nums1, nums2, 0, 0, l / 2) + findKthElement(nums1, nums2, 0, 0, (l / 2) + 1)) / 2;
		} else {
			return findKthElement(nums1, nums2, 0, 0, (l / 2) + 1);
		}
	}

	double findKthElement(int[] nums1, int[] nums2, int s1, int s2, int k) {

		if (s1 > nums1.length - 1) {
			return nums2[s2 + k - 1];
		}

		if (s2 > nums2.length - 1) {
			return nums1[s1 + k - 1];
		}

		if (k == 1) {
			return Math.min(nums1[s1], nums2[s2]);
		}

		int m1 = s1 + k / 2 - 1;
		int m2 = s2 + k / 2 - 1;

		int mid1 = m1 < nums1.length ? nums1[m1] : Integer.MAX_VALUE;
		int mid2 = m2 < nums2.length ? nums2[m2] : Integer.MAX_VALUE;

		if (mid1 < mid2) {
			return findKthElement(nums1, nums2, m1 + 1, s2, k - k / 2);
		} else {
			return findKthElement(nums1, nums2, s1, m2 + 1, k - k / 2);
		}
	}

}
