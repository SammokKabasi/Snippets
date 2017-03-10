package com.leetcode.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		long a = System.nanoTime();
		HashSet<List<Integer>> set = new HashSet<>(3);

		HashMap<Integer, Integer> map = new HashMap<>(nums.length);
		// create a hashmap that maps num to index
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		// System.out.println(map);
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				i++;
			}
			for (int j = i + 1; j < nums.length; j++) {
				// System.out.println(i+","+j);
				int diff = 0 - (nums[i] + nums[j]);
				Integer diffIndex = map.get(diff);
				if (diffIndex == null || i == diffIndex || j == diffIndex) {
					continue;
				}
				ArrayList<Integer> res = new ArrayList<>();
				res.add(nums[i]);
				res.add(nums[j]);
				res.add(diff);
				Collections.sort(res);
				set.add(res);
			}
		}
		long b = System.nanoTime();
		System.out.println(b - a);
		return new ArrayList<>(set);
	}

	public static void main(String[] args) {
		int[] ints = { 12, 0, 3, -14, 5, -11, 11, -5, -2, -1, 6, -7, -10, 1, 4, 1, 1, 9, -3, 6, -15, 0, 6, 1, 6, -12, 3, 7, 11, -6, -8, 0, 9, 3, -7, -1, 7, -10, 1, 13, -4, -7, -9, -7, 9, 3, 1, -13, -3, 13, 8, -11, -9, -8, -3, 4, -13, 7, -11, 5, -14,
				-4, -9, 10, 6, -9, -6, -9, -12, 11, -11, -9, 11, -5, 0, -3, 13, -14, -1, -13, 7, -7, 14, 5, 0, -4, -6, -6, -11, -2, 14, -10, 2, 12, 8, -7, -11, -13, -9, 14, 5, -5, -9, 1, -2, 6, 5, -12, -1, -10, -9, -9, -10, 12, 11 };
		System.out.println(new Solution().threeSum(ints));
	}
}
