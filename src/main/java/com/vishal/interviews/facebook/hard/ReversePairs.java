package com.vishal.interviews.facebook.hard;

public class ReversePairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int reversePairs(int[] nums) {

		int[] temp = new int[nums.length];
		return mergeSortAndCount(nums, 0, nums.length - 1, temp);
	}

	int mergeSortAndCount(int[] nums, int st, int en, int[] temp) {
		
		if(st >= en){
            return 0;
        }
		
		int cnt = 0;

		int mid = st + (en - st) / 2;
		cnt += mergeSortAndCount(nums, st, mid, temp);
		cnt += mergeSortAndCount(nums, mid + 1, en, temp);

		int j = mid + 1;
		for (int i = st; i <= mid; i++) {
			while (j <= en && nums[i] / 2.0 > nums[j]) {
				j++;
			}
			cnt += j - mid - 1;
		}
		merge(nums, st, mid, en, temp);
		return cnt;

	}

	void merge(int[] nums, int st, int m, int en, int[] temp) {

		for (int i = st; i <= en; i++) {
			temp[i] = nums[i];
		}

		int i = st;
		int j = m + 1;
		int k = st;

		while (i <= m && j <= en) {
			if (temp[i] < temp[j]) {
				nums[k++] = temp[i++];
			} else {
				nums[k++] = temp[j++];
			}
		}

		while (i <= m) {
			nums[k++] = temp[i++];
		}
	}

}
