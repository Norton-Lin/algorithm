package day.leetcode_2465;

import java.util.Arrays;
import java.util.HashSet;

class Solution {
	//排序双指针+哈希
    public int distinctAverages(int[] nums) {
    	HashSet<Integer> set = new HashSet<>();
    	Arrays.sort(nums);
    	int i = 0,j = nums.length-1;
    	while(i<j)
    		set.add(nums[i++]+nums[j--]);
    	return set.size();
    	
    }
}