package com.leetcode.integerreverse;

public class Solution {
	public int reverse(int x) {
		boolean negative = false;
		if (x < 0) {
			x = Math.abs(x);
		}
		int reverse = 0;
		while (x > 0) {
			int num = x % 10;
			try {
				reverse = Math.addExact(Math.multiplyExact(10, reverse), num);
			} catch (Exception e) {
				return 0;
			}
			x = x / 10; // starting its x/1, then x/10, then x/100
		}
		if (negative) {
			reverse = reverse * -1;
		}
		return reverse;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().reverse(1534236469));

	}
}