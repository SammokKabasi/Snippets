package com.sammok.medianof2sortedarrays;

import java.util.ArrayList;

public class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		return findMedian(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1);

	}

	public double findMedian(int[] nums1, int[] nums2, int startNums1, int endNums1, int startNums2, int endNums2) {

		if (nums1.length == 0 && nums2.length == 0) {
			return 0d;
		}

//		// if nums1 size is 0
//		if (nums1.length == 0) {
//			if (nums2.length % 2 == 1) {
//				return nums2[(nums2.length - 1) / 2];
//			} else {
//				return ((double) nums2[(nums2.length - 1) / 2] + (double) nums2[nums2.length / 2] / 2);
//
//			}
//		}
//		if (nums2.length == 0) {
//			if (nums1.length % 2 == 1) {
//				return nums1[(nums1.length - 1) / 2];
//			} else {
//				return ((double) nums1[(nums1.length - 1) / 2] + (double) nums1[nums1.length / 2] / 2);
//
//			}
//		}

		for (int i = startNums1; i <= endNums1; i++) {
			// System.out.print(nums1[i] + " ");
		}
		// System.out.println();
		for (int i = startNums2; i <= endNums2; i++) {
			// System.out.print(nums2[i] + " ");
		}
		// System.out.println();
		// base case- when both arrays have only 2 integers
//		if (endNums1 - startNums1 == 1 && endNums2 - startNums2 == 1) {
//			return (Math.max((double) nums1[startNums1], (double) nums2[startNums2]) + Math.min((double) nums1[endNums1], (double) nums2[endNums2])) / 2;
//		}

		int len1 = findLength(startNums1, endNums1);
		int len2 = findLength(startNums2, endNums2);

		// if one of the arrays reaches size 2
		if (len1 <= 2 || len2 <= 2) {
			// merge the two arrays

			int i = startNums1;
			int j = startNums2;
			ArrayList<Integer> merged = new ArrayList<>();

			for (; i <= endNums1 && j <= endNums2; ) {
				if (nums1[i] < nums2[j]) {
					merged.add(nums1[i]);
					i++;
				} else {
					merged.add(nums2[j]);
					j++;
				}
			}
			while (i <= endNums1) {
				merged.add(nums1[i]);
				i++;
			}
			while (j <= endNums2) {
				merged.add(nums2[j]);
				j++;
			}
			if (merged.size() % 2 == 1) {
				return merged.get((merged.size()-1) / 2);
			} else {
				
				double a = (double)merged.get((merged.size()-1)/ 2);
				double b= (double)merged.get(((merged.size())) / 2);
				return (a+b)/2;

			}
		}

		// first find medians of 2 arrays

		double median1 = findMedianOfArray(nums1, startNums1, endNums1);
		double median2 = findMedianOfArray(nums2, startNums2, endNums2);
		// System.out.println("Median 1 is " + median1);
		// System.out.println("Median 2 is " + median2);

		int newStartNums1 = startNums1;
		int newEndNums1 = endNums1;
		int newStartNums2 = startNums2;
		int newEndNums2 = endNums2;

		int temp1 = startNums1 + (endNums1 - startNums1) / 2;
		int temp2 = startNums2 + (endNums2 - startNums2) / 2;

		// System.out.println("temp->"+ nums1[temp1] + ", " + nums2[temp2]);
		// System.out.println();
		// System.out.println();
		if (median1 < median2) {
			newStartNums1 = temp1;

			if (len2 % 2 == 1) {// array length is even, remove the first n/2-1
								// elements
				newEndNums2 = temp2;
			} else {// remove the first n/2 elements
				newEndNums2 = temp2 + 1;
			}

			return findMedian(nums1, nums2, newStartNums1, newEndNums1, newStartNums2, newEndNums2);
		} else if (median1 > median2) {
			newStartNums2 = temp2;

			if (len1 % 2 == 1) {
				newEndNums1 = temp1;
			} else {
				newEndNums1 = temp1 + 1;
			}
			return findMedian(nums1, nums2, newStartNums1, newEndNums1, newStartNums2, newEndNums2);

		} else {
			return median1;
		}

	}

	private int findLength(int startNums, int endNums) {
		return endNums - startNums + 1;

	}

	private double findMedianOfArray(int[] nums, int startNums, int endNums) {

		int len = findLength(startNums, endNums);
		// System.out.println("Inside find median with length = " + len);

		int temp = startNums + (endNums - startNums) / 2;

		if (len % 2 == 0) { // even number of elements
			return ((double) nums[temp] + (double) nums[temp + 1]) / 2;
		} else {
			return (double) nums[temp];
		}
	}

	public static void main(String[] args) {
		int nums1[] = { 1,2};
		int nums2[] = { 3,4 };
		double s = new Solution().findMedianSortedArrays(nums1, nums2);
		System.out.println("The answer is -> " + s);

	}
}
