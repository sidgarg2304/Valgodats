package com.vishal.interviews.google.hard;

/**
 * 
 * 321. Create Maximum Number
 * 
 * Given two arrays of length m and n with digits 0-9 representing two numbers.
 * Create the maximum number of length k <= m + n from digits of the two. The
 * relative order of the digits from the same array must be preserved. Return an
 * array of the k digits. You should try to optimize your time and space
 * complexity.
 * 
 * Example 1:
 * 
 * nums1 = [3, 4, 6, 5]
 * 
 * nums2 = [9, 1, 2, 5, 8, 3]
 * 
 * k = 5
 * 
 * return [9, 8, 6, 5, 3]
 * 
 * Example 2:
 * 
 * nums1 = [6, 7]
 * 
 * nums2 = [6, 0, 4]
 * 
 * k = 5
 * 
 * return [6, 7, 6, 0, 4]
 * 
 * Example 3:
 * 
 * nums1 = [3, 9]
 * 
 * nums2 = [8, 9]
 * 
 * k = 3
 * 
 * return [9, 8, 9]
 *
 */
public class CreateMaximumNumber {

	public static void main(String[] args) {

	}

	/**
	 * Share my greedy solution Many of the posts have the same algorithm. In
	 * short we can first solve 2 simpler problem
	 * 
	 * Create the maximum number of one array
	 * 
	 * Create the maximum number of two array using all of their digits.
	 * 
	 * For an long and detailed explanation see my blog here.
	 * 
	 * The algorithm is O((m+n)^3) in the worst case. It runs in 22 ms.
	 * 
	 * @param nums1
	 * @param nums2
	 * @param k
	 * @return
	 */
	public int[] maxNumberGreedy(int[] nums1, int[] nums2, int k) {
		int n = nums1.length;
		int m = nums2.length;
		int[] ans = new int[k];
		for (int i = Math.max(0, k - m); i <= k && i <= n; ++i) {
			int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
			if (greater(candidate, 0, ans, 0))
				ans = candidate;
		}
		return ans;
	}

	private int[] merge(int[] nums1, int[] nums2, int k) {
		int[] ans = new int[k];
		for (int i = 0, j = 0, r = 0; r < k; ++r)
			ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
		return ans;
	}

	public boolean greater(int[] nums1, int i, int[] nums2, int j) {
		while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
			i++;
			j++;
		}
		return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
	}

	public int[] maxArray(int[] nums, int k) {
		int n = nums.length;
		int[] ans = new int[k];
		for (int i = 0, j = 0; i < n; ++i) {
			while (n - i + j > k && j > 0 && ans[j - 1] < nums[i])
				j--;
			if (j < k)
				ans[j++] = nums[i];
		}
		return ans;
	}

}

/**
 * Share my 21ms java solution with comments To find the maximum ,we can
 * enumerate how digits we should get from nums1 , we suppose it is i.
 * 
 * So , the digits from nums2 is K - i.
 * 
 * And we can use a stack to get the get maximum number(x digits) from one
 * array.
 * 
 * OK, Once we choose two maximum subarray , we should combine it to the answer.
 * 
 * It is just like merger sort, but we should pay attention to the case: the two
 * digital are equal.
 * 
 * we should find the digits behind it to judge which digital we should choose
 * now.
 * 
 * In other words,we should judge which subarry is bigger than the other.
 * 
 * That's all.
 * 
 * If you have any question or suggest, I am happy you can comment on my blog :
 * Create Maximum Number.
 * 
 * @author vkotha
 *
 */
class CreateMaximumNumber21msSolution {
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int get_from_nums1 = Math.min(nums1.length, k);
		int[] ans = new int[k];
		for (int i = Math.max(k - nums2.length, 0); i <= get_from_nums1; i++) {
			int[] res1 = new int[i];
			int[] res2 = new int[k - i];
			int[] res = new int[k];
			res1 = solve(nums1, i);
			res2 = solve(nums2, k - i);
			int pos1 = 0, pos2 = 0, tpos = 0;

			while (res1.length > 0 && res2.length > 0 && pos1 < res1.length && pos2 < res2.length) {
				if (compare(res1, pos1, res2, pos2))
					res[tpos++] = res1[pos1++];
				else
					res[tpos++] = res2[pos2++];
			}
			while (pos1 < res1.length)
				res[tpos++] = res1[pos1++];
			while (pos2 < res2.length)
				res[tpos++] = res2[pos2++];

			if (!compare(ans, 0, res, 0))
				ans = res;
		}

		return ans;
	}

	public boolean compare(int[] nums1, int start1, int[] nums2, int start2) {
		for (; start1 < nums1.length && start2 < nums2.length; start1++, start2++) {
			if (nums1[start1] > nums2[start2])
				return true;
			if (nums1[start1] < nums2[start2])
				return false;
		}
		return start1 != nums1.length;
	}

	public int[] solve(int[] nums, int k) {
		int[] res = new int[k];
		int len = 0;
		for (int i = 0; i < nums.length; i++) {
			while (len > 0 && len + nums.length - i > k && res[len - 1] < nums[i]) {
				len--;
			}
			if (len < k)
				res[len++] = nums[i];
		}
		return res;
	}
}
