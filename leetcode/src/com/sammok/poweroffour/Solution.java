package com.sammok.poweroffour;

public class Solution {
	public boolean isPowerOfFour(int num) {

		if(num==1) {
			return true;
		}
		if (num < 4) {
			return false;
		}
		Double dNumber = Math.log(Double.valueOf(num)) / Math.log(4);
		if (Math.floor(dNumber) == dNumber) {
			return true;
		} else {
			return false;
		}

	}

	public static void main(String[] args) {
		System.out.println(new Solution().isPowerOfFour(8));
	}
}
