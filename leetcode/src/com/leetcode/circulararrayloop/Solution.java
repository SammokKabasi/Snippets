package com.leetcode.circulararrayloop;

public class Solution {
	public boolean circularArrayLoop(Integer[] nums) {
		int i = 0;
		int direction = 0;
		if (nums.length == 0) {
			return false;
		}

		for (int x = 0; x <= 2 * nums.length; x++) {
			int new_i = i + nums[i];
			if (new_i >= nums.length) {
				new_i = Math.floorMod(new_i, nums.length);
				direction++;
			} else if (new_i < 0) {
				new_i = Math.floorMod(new_i, nums.length);
				direction--;
			}
			if (new_i == i) {
				return false;
			} else {
				i = new_i;
			}
			if (direction > 1 || direction < -1) {
				return true;
			}
		}
		return false;

	}

	public static void main(String[] args) {
		Integer nums[] = { 2, -1, 2, 2, 2 };
		System.out.println(new Solution().circularArrayLoop(nums));
	}
}