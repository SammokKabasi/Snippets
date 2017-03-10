package com.leetcode.twosum;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int i = 0;
		for (int num : nums) {
			if (map.containsKey(target - num)) {
				return new int[] { i, map.get(target - num) };
			}
			map.put(num, i);
			i++;
		}
		return new int[] { -1, -1 };
	}

	public static void main(String[] args) {
		int[] x = new Solution().twoSum(new int[] { 2, 7, 11, 15 }, 9);
		System.out.println(Arrays.toString(x));
	}
}