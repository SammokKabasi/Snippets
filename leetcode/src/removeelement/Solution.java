package removeelement;

public class Solution {
	public int removeElement(int[] nums, int val) {

		int j = 0;
		for (int num : nums) {
			if (val != num) {
				nums[j] = num;
				j++;
			}
		}
		return j;
	}
}