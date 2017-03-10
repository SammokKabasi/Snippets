package com.leetcode.firstmissingpositive;

import java.util.Arrays;

public class Solution {
	public int firstMissingPositive(int[] nums) {
		for (int i = 1; i <= nums.length; i++) {
			while (nums[i - 1] != i && nums[i - 1] > 0 && nums[i - 1] <= nums.length && nums[nums[i - 1] - 1] != nums[i - 1]) {
				swap(nums, i - 1, nums[i - 1] - 1);
			}
		}
		int i = 1;
		for (; i <= nums.length; i++) {
			if (nums[i - 1] != i) {
				return i;
			}
		}
		return i;
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		int solution = new Solution().firstMissingPositive(new int[] { 1, 1 });
		System.out.println(solution);
	}
}