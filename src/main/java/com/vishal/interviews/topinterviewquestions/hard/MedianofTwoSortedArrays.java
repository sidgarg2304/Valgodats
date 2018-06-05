package com.vishal.interviews.topinterviewquestions.hard;

public class MedianofTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int l = nums1.length + nums2.length;

		if (l % 2 == 0) {
			return (findKthElement(nums1, 0, nums2, 0, l / 2 + 1) + findKthElement(nums1, 0, nums2, 0, l / 2)) / 2;
		} else {
			return findKthElement(nums1, 0, nums2, 0, l / 2 + 1);
		}
	}

	int findKthElement(int[] nums1, int st1, int[] nums2, int st2, int k) {

		if (st2 >= nums2.length) {
			return nums1[st1 + k - 1];
		}

		if (st1 >= nums1.length) {
			return nums2[st2 + k - 1];
		}

		if (k == 1) {
			return Math.min(nums1[st1], nums2[st2]);
		}

		int m1 = st1 + (k / 2) - 1;
		int m2 = st2 + (k / 2) - 1;

		int mid1 = m1 < nums1.length ? nums1[m1] : Integer.MAX_VALUE;
		int mid2 = m2 < nums2.length ? nums2[m2] : Integer.MAX_VALUE;

		if (mid1 < mid2) {
			return findKthElement(nums1, m1 + 1, nums2, st2, k / 2);
		} else {
			return findKthElement(nums1, st1, nums2, m2 + 1, k / 2);
		}

	}

}
