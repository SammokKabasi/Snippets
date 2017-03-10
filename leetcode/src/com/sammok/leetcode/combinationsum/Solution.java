package com.sammok.leetcode.combinationsum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	List<List<Integer>> list = new ArrayList<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		fun(0, target, 0, new ArrayList<Integer>(), candidates);

		return list;
	}

	private void fun(int currentSum, int target, int index, ArrayList<Integer> curList, int[] candidates) {
		if (currentSum == target) {
			list.add(new ArrayList<>(curList)); //add the answer, its a solution and return
			return;
		}
		if (currentSum > target) { // dont add anything
			return;
		}
		if (index >= candidates.length) {
			return;
		}
		for(int i =index; i<(candidates.length); i++) {
			curList.add(candidates[i]);
			
			//calculate currentSum
			fun(currentSum + candidates[i], target, i, curList, candidates);
			
			//remove the last element and try again
			curList.remove(curList.size()-1);
		}

	}

	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		System.out.println(new Solution().combinationSum(candidates, 10));
		
	}
}
